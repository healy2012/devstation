package cn.emag.demo.web.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import cn.emag.demo.domain.UserInfo;
import cn.emag.demo.service.PortalInfoService;
import cn.emag.framework.action.BaseAction;
import cn.emag.framework.spring.SpringContextHolder;

public class PortalRemoteValAction extends BaseAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserInfo userInfo;
	
    private InputStream inputStream;      

	
	PortalInfoService portalInfoService = (PortalInfoService)SpringContextHolder.getService("portalInfoService");

    public String validateUser()
	{
       Boolean flag = portalInfoService.isUserExist(userInfo);
    	
       inputStream = new ByteArrayInputStream(flag.toString().getBytes());      

       return SUCCESS;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
    
    
   
}


