package cn.emag.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.emag.framework.dao.BaseIBatisDao;
import cn.emag.framework.utils.DataUtil;
import cn.emag.system.domain.SystemPO;

@Repository("systemIbatisDao")
public class SystemIbatisDao extends BaseIBatisDao {

	public int getSystemCount(SystemPO systemPO) {
		int count = (Integer) (this.getSqlMapClientTemplate().queryForObject(
				"cn.emag.system.domain.SystemPO.getSystemCount", systemPO));

		return count;
	}

	public List<SystemPO> querySystemListByPage(int pageNumber, int pageSize,
			String sortByColumn, boolean sortAsc, Map params) {
		return queryForPaginatedList(
				"cn.emag.system.domain.SystemPO.querySystemListByPage", params,
				pageNumber, pageSize, sortByColumn, sortAsc);
	}

	public int deleteSystems(String systemId) {
		return getSqlMapClientTemplate().delete(
				"cn.emag.system.domain.SystemPO.deleteSystems", systemId);
	}

	public List<SystemPO> querySystemBySystemId(Map params) {
		List<SystemPO> userList = this.getSqlMapClientTemplate().queryForList("cn.emag.system.domain.SystemPO.querySystemListByPage", params);
		return userList;
	}

	public void updateUserInfo(SystemPO systemPOForUpdate) {
		this.getSqlMapClientTemplate().update("cn.emag.system.domain.SystemPO.updateSystem", systemPOForUpdate);
		
	}

	public void saveAddSystem(SystemPO systemPO) {
		int systemId=DataUtil.getNextIntegerID("t_cams_system_seq");
    	systemPO.setSystemId(systemId+"");
    	
        this.getSqlMapClientTemplate().insert("cn.emag.system.domain.SystemPO.saveAddSystem", systemPO);
	}

}
