/**
 * TODO
 * @author Administrator
 * Create on 2011-6-28
 */
package cn.emag.demo.web.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import cn.emag.framework.action.JsonAction;

public class DemoAjaxAction extends JsonAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3874356820743300473L;

	public void test(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject json = new JSONObject();
		json.put("message", "hello,world!");
		serializer(json);
	}
}
