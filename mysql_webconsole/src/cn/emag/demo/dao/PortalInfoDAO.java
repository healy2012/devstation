package cn.emag.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.emag.demo.domain.UserInfo;
import cn.emag.framework.dao.BaseIBatisDao;
import cn.emag.framework.utils.DataUtil;

@Repository
public class PortalInfoDAO extends BaseIBatisDao
{
	public void saveUserInfo(UserInfo userInfo) {
//		String userId = String.valueOf(DataUtil.getNextIntegerID("PORTALUSERINFO_SEQ"));
//		userInfo.setUserId(userId);
		this.getSqlMapClientTemplate().insert(
				"cn.emag.portal.domain.UserInfo.saveUserInfo", userInfo);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> queryUserInfoList(Map params)
	{
		List<UserInfo> userList = this.getSqlMapClientTemplate().queryForList("cn.emag.portal.domain.UserInfo.queryUserList", params);
		
		return userList;
	}
	
	@SuppressWarnings("unchecked")
	public List<UserInfo> queryUserInfoListByPage(int pageNumber, int pageSize,
				String sortByColumn, boolean sortAsc, Map<String, String> map) {
			return queryForPaginatedList("cn.emag.portal.domain.UserInfo.queryUserList",
					map, pageNumber, pageSize, sortByColumn, sortAsc);
		

	}
	
	public int getPortalUserCount(UserInfo userInfo)
	{
		int count = (Integer)(this.getSqlMapClientTemplate().queryForObject("cn.emag.portal.domain.UserInfo.queryUserCount",userInfo));
		
		return count;
	}
	
	public void deleteUserInfos(UserInfo userInfo)
	{
		this.getSqlMapClientTemplate().delete("cn.emag.portal.domain.UserInfo.delUser", userInfo);
	
	}
	
	public void updateUserInfo(UserInfo userInfo)
	{
		this.getSqlMapClientTemplate().update("cn.emag.portal.domain.UserInfo.updateUser", userInfo);
	}
	

}
