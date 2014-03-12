package cn.emag.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.emag.system.dao.BaseDataIbatisDao;
import cn.emag.system.domain.BaseData;
import cn.emag.system.service.BaseDataService;
@Service("baseDataService")
public class BaseDataServiceImpl implements BaseDataService {
	@Autowired
	private BaseDataIbatisDao baseDataIbatisDao;

	public void delete(Integer id) {
		baseDataIbatisDao.delete(id);

	}

	public BaseData findById(Integer id) {
		return baseDataIbatisDao.findById(id);
	}

	public List findChildAndThisById(Integer id) {
		return baseDataIbatisDao.findChildAndThisById(id);
	}

	public List findChildById(Integer id) {
		return baseDataIbatisDao.findChildById(id);
	}

	public List listAll() {
		return baseDataIbatisDao.listAll();
	}

	public List listBaseParent() {
		return baseDataIbatisDao.listBaseParent();
	}
	/**
	 * 没有父id就给零
	 * 级别为父级别数 + 1
	 * code算法：父亲code + 自己位置*/
	public Integer save(BaseData bd) {
		bd.setBdParentId(bd.getBdParentId()==null?0:bd.getBdParentId());
		BaseData parent = baseDataIbatisDao.findById(bd.getBdParentId());
		if(null == parent){
			parent = new BaseData();
		}
		String nextCode = getCodeByParentCode(parent.getBdCode());
		if("0000".equals(nextCode)){
			return 0;
		}
		bd.setBdCode(nextCode);
		bd.setBdLvl( (bd.getBdParentId()==0)?1: parent.getBdLvl()+1);
		return baseDataIbatisDao.save(bd);
	}
	
	/**根据父code得到子code*/
	public String getCodeByParentCode(String pCode) {
		if(null == pCode){
			pCode = "____";
		}
		String childMaxCode = baseDataIbatisDao.findChildMaxCode(pCode);
		String end4Code = childMaxCode.substring(childMaxCode.length()-4);
		Integer value = Integer.parseInt(end4Code)+1;
		if(value>=10000){
			value = findVacancyByPcode(pCode);//找空缺的
			if(value==null){
				return "0000";
			}
		}
		String after = changeLen(value,4);
		
		return pCode+after;
	}
	
	/**维持数字的长度转为字符*/
	private static String changeLen(Integer end4Code, int mustLen) {
		int i = mustLen - (end4Code+"").length();
		StringBuffer sb = new StringBuffer();
		for(int j=0;j<i;j++){
			sb.append("0");
		}
		sb.append(end4Code);
		
		return sb.toString();
	}

	public void update(BaseData bd) {
		baseDataIbatisDao.update(bd);
	}
	/**检查flag   存在返回flag*/
	public String checkFlag(String checkFlag) {
		
		return baseDataIbatisDao.checkFlag(checkFlag);
	}

	public List<BaseData> findChildsByFlag(String flag,String name) {
		return baseDataIbatisDao.findChildsByFlag(flag, name);
	}

	public List<BaseData> findAllChildsByFlag(String flag, String name) {
		
		return baseDataIbatisDao.findAllChildsByFlag(flag, name);
	}
	
	public List<BaseData> findDataWithChild(){
	    return baseDataIbatisDao.findDataWithChild();
	}

	/**找到空缺的code */
	public Integer findVacancyByPcode(String pcode) {
		List<String> codes = baseDataIbatisDao.findAllChildCode(pcode);
		int i = 1;
		for(;i<10000;i++){
			Integer code = Integer.parseInt(codes.get(i-1));
			if(i<code){
				return i;
			}
		}
		return null;
	}

}
