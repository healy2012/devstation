package cn.emag.system.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.emag.framework.dao.BaseIBatisDao;
import cn.emag.framework.dao.BaseJdbcDao;
import cn.emag.system.domain.BaseData;

@Repository("baseDataIbatisDao")
public class BaseDataIbatisDao extends BaseIBatisDao {

	/**添加*/
	public Integer  save(BaseData bd){
		System.out.println("BaseDataIbatisDao.save");
		return  (Integer) getSqlMapClientTemplate().insert("cn.emag.system.domain.BaseData.save", bd);
		
	}
	
	/**修改*/
	public void update(BaseData bd){
		System.out.println("BaseDataIbatisDao.update");
		getSqlMapClientTemplate().update("cn.emag.system.domain.BaseData.update", bd);
		
	}
	 
	/**删除(其所有子节点都被删除)*/
	public void delete(Integer id){
		getSqlMapClientTemplate().delete("cn.emag.system.domain.BaseData.delete", id);
	}
	
	/**找到单个byId*/
	public BaseData findById(Integer bdId){
		
		BaseData bd = (BaseData)getSqlMapClientTemplate().
		  queryForObject("cn.emag.system.domain.BaseData.findById", bdId);
		return bd;
	}
	
	/**找到单个byId(包含其子节点) 暂时未处理*/
	public List findChildAndThisById(Integer id){
		
		return null;
	}
	
	/**根据父Id找到其所有直接子类*/
	public List findChildById(Integer id){
		List<BaseData> bds = getSqlMapClientTemplate().queryForList("cn.emag.system.domain.BaseData.findChildById", id);
		return bds;
	}
	
	/**列表 所有的*/
	public List listAll(){
		List<BaseData> list = getSqlMapClientTemplate().queryForList("cn.emag.system.domain.BaseData.listAll");
		return list;
	}
	
	/**列出所有根基*/
	public List listBaseParent(){
		List<BaseData> list = getSqlMapClientTemplate().queryForList("cn.emag.system.domain.BaseData.listBaseParent");
		return list;
	}

	/**检查code  存在返回code*/
	public String checkFlag(String cd) {
		return (String) getSqlMapClientTemplate().
		  queryForObject("cn.emag.system.domain.BaseData.checkFlag", cd);
	}

	public List<BaseData> findChildsByFlag(String flag, String name) {
		BaseData bd = new BaseData();
		bd.setBdFlag(flag);
		bd.setBdName(name);
		List<BaseData> list = getSqlMapClientTemplate().queryForList("cn.emag.system.domain.BaseData.findChildsByFlag",bd);
		return list;
	}
	public List<BaseData> findAllChildsByFlag(String flag, String name) {
		BaseData bd = new BaseData();
		bd.setBdFlag(flag);
		bd.setBdName(name);
		System.out.println("模糊匹配name:"+name);
		List<BaseData> list = getSqlMapClientTemplate().queryForList("cn.emag.system.domain.BaseData.findAllChildsByFlag",bd);
		return list;
	}

	public String findChildMaxCode(String pcode) {
		String maxCode =	(String) getSqlMapClientTemplate().queryForObject("cn.emag.system.domain.BaseData.findChildMaxCode", pcode);
		return maxCode;
	}
	/**返回所有当前父code的 从0001开始的子code*/
	public List findAllChildCode(String pcode){
		List codes = getSqlMapClientTemplate().queryForList("cn.emag.system.domain.BaseData.findAllChildCode", pcode);
		
		return codes;
	}
	
	/**
	 * 查询存在子节点的数据字典
	 * @param flag
	 * @param name
	 * @return
	 */
	public List<BaseData> findDataWithChild() {
        List<BaseData> list = getSqlMapClientTemplate().queryForList("cn.emag.system.domain.BaseData.findDataWithChild");
        return list;
    }
	
	
}
