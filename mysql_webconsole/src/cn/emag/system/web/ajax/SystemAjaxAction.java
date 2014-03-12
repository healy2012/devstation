/**
 * TODO
 * @author Administrator
 * Create on 2011-7-12
 */
package cn.emag.system.web.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import cn.emag.framework.action.JsonAction;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.system.service.MenuService;

public class SystemAjaxAction extends JsonAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3719856205925434463L;

	/**
	 * 根据父节点的code删除所有子节点
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void deleteMenusByCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer navId = getIntegerParameter("navId");
		String parentCode = getStringParameter("parentCode");
		MenuService service = (MenuService) SpringContextHolder
				.getService("menuService");
		service.deleteMenusByCode(navId, parentCode);
		JSONObject json = new JSONObject();
		json.put("result", "success");
		serializer(json);
	}

	/**
	 * 检查树的层级是否存在重复
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void checkMenuSeq(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer navId = getIntegerParameter("navId");
		Integer parentId = getIntegerParameter("parentId");
		Integer seq = getIntegerParameter("seq");
		Integer menuId = getIntegerParameter("menuId");
		MenuService service = (MenuService) SpringContextHolder
				.getService("menuService");
		boolean result = service.checkMenuSeq(navId, parentId, seq, menuId);
		JSONObject json = new JSONObject();
		json.put("result", result);
		serializer(json);
	}
	
}
