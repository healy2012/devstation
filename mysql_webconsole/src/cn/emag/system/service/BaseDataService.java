package cn.emag.system.service;

import java.util.List;

import cn.emag.system.domain.BaseData;

public interface BaseDataService {

	/**添加*/
	public Integer  save(BaseData bd);
	
	/**修改*/
	public void update(BaseData bd);
	
	/**删除(其所有子节点都被删除)*/
	public void delete(Integer id);
	
	/**找到单个byId*/
	public BaseData findById(Integer id);
	
	/**找到单个byId(包含其子节点) 暂时未处理*/
	public List findChildAndThisById(Integer id);
	
	/**根据父Id找到其所有直接子类*/
	public List findChildById(Integer id);
	
	/**列表 所有的*/
	public List listAll();
	
	/**列出所有根基*/
	public List listBaseParent();

	/**检查code是否重复*/
	public String checkFlag(String checkFlag);

	
	/**根据flag找到直接子类
	 * @param name */
	public List<BaseData> findChildsByFlag(String flag, String name);
	/**根据flag找到所有子类
	 * @param name */
	public List<BaseData> findAllChildsByFlag(String flag, String name);
	
	public List<BaseData> findDataWithChild();
	
	public  Integer   findVacancyByPcode(String pcode);
}
