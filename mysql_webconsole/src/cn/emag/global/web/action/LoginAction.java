/**
 * TODO
 * @author Administrator
 * Create on 2010-8-17
 */
package cn.emag.global.web.action;

import java.util.List;
import cn.emag.cams.intf.client.bean.UserDataObject;
import cn.emag.cams.intf.client.service.ObtainUserAuthDataService;
import cn.emag.framework.action.BaseAction;
import cn.emag.framework.security.ClientSession;
import cn.emag.framework.security.ClientSessionHolder;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.global.utils.LogUtil;
import cn.emag.global.web.ajax.GlobalAjaxAction;
import cn.emag.system.domain.Navigator;
import cn.emag.system.service.NavigatorService;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 499737513717579995L;
	
    NavigatorService service = (NavigatorService) SpringContextHolder
       .getService("navigatorService");
    
    ObtainUserAuthDataService userDataService = (ObtainUserAuthDataService) SpringContextHolder
    .getService("obtainUserAuthDataService");
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {

		ClientSession cs = (ClientSession) getHttpSession().getAttribute(
				"CLIENT_SESSION");
		if(cs==null)
			cs = new ClientSession();
		cs.setLogined(true);
		
		String userName = getStringParameter("username");
		String password = getStringParameter("password");
		
		if (!"admin".equals(userName)) {
            throw new IllegalArgumentException("用户名不存在。");
        }
        if (!"9125a8403e31aeefeb6e93eb6e23a7bf".equals(GlobalAjaxAction.getMd5(password))) {
            throw new IllegalArgumentException("密码不正确。");
        }//admin/admin@456?
		
		cs.setUserId(userName);
		cs.setUserName(getStringParameter("username"));
		
		List<Navigator> displayNavigatorList = service.listDisplayNavigator();
		
		cs.addAttribute("displayNavigator", displayNavigatorList);
		
		/*UserDataObject userDataObject = userDataService.getUserDataObject(cs.getUserName());
		
		cs.addAttribute("userDataObject", userDataObject);*/
		
		getHttpSession().setAttribute("CLIENT_SESSION", cs);
		
		ClientSessionHolder.setClientSession(cs);
		// 记录系统日志
		LogUtil.info("global", "系统登录", "登录");
		return SUCCESS;
	}
}
