package cn.emag.demo.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.emag.demo.domain.UserInfo;
import cn.emag.demo.service.PortalInfoService;
import cn.emag.framework.action.PaginationAction;
import cn.emag.framework.spring.SpringContextHolder;

public class PortalUserAction extends PaginationAction
{
    /**
	 * 魔鬼数字，晕
	 */
	private static final long serialVersionUID = 1L;
	
	private List<UserInfo> userInfoList;
	
	private UserInfo userInfo;
	
	private String userIds;
	
	PortalInfoService portalInfoService = (PortalInfoService)SpringContextHolder.getService("portalInfoService");

	@Override
	protected String executePaginationAction(HttpServletRequest request,
			HttpServletResponse response, int pageNumber, int pageSize)
			throws Exception {
	   
		userInfoList = portalInfoService.queryUserInfoListByPage(userInfo,pageNumber,pageSize);
		
		return SUCCESS;
	}
	
	public String delUsers()
	{
	    
	    portalInfoService.deleteUserInfos(userIds);
	    
	    
		return SUCCESS;
	}
	
	public String addUser()
	{
		return SUCCESS;
	}
	
	public String createUser() {
		portalInfoService.saveUserInfo(userInfo);
		return SUCCESS;
	}
	
	public String updateUser()
	{
		UserInfo userInfoForQuery = new UserInfo();
		
		userInfoForQuery.setUserId((userIds.split(","))[0]);
		
		userInfo = portalInfoService.queryUserInfoList(userInfoForQuery,"",true).get(0);
		
		return SUCCESS;
	}
	
	public String updateSaveUser()
	{
		
	    portalInfoService.updateUserInfo(userInfo);
		
		return SUCCESS;
	}

	@Override
	protected int getItemCount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	   return portalInfoService.getPortalUserCount(userInfo);
	
	}
	

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
	
	
	
   
}
