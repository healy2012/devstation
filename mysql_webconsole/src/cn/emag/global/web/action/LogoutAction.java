/**
 * TODO
 * @author Administrator
 * Create on 2010-8-24
 */
package cn.emag.global.web.action;

import javax.servlet.http.HttpSession;
import cn.emag.framework.action.BaseAction;
import cn.emag.global.utils.LogUtil;

@SuppressWarnings("serial")
public class LogoutAction extends BaseAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		HttpSession session = getHttpSession();
		session.removeAttribute("CLIENT_SESSION");
		session.invalidate();
		// 记录日志
		LogUtil.info("global", "系统退出", "退出");
		return SUCCESS;
	}
}
