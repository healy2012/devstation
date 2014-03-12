package cn.emag.system.service;

import java.util.List;

import cn.emag.system.domain.SystemPO;

public interface SystemService {

	
	
	public int getSystemCount(SystemPO systemPO);

	public List<SystemPO> querySystemListByPage(SystemPO systemPO,
			int pageNumber, int pageSize);

	public int deleteSystems(String systemIds);

	public List<SystemPO> querySystemBySystemId(SystemPO systemForQuery,String sortByColumn,boolean sortAsc);

	public void updateSystemPO(SystemPO systemPO);

	public void saveAddSystem(SystemPO systemPO);

}
