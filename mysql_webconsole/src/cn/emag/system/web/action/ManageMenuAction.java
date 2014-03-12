/**
 * TODO
 * @author Administrator
 * Create on 2011-7-11
 */
package cn.emag.system.web.action;

import org.apache.commons.lang.StringUtils;

import cn.emag.framework.action.BaseAction;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.framework.utils.DataUtil;
import cn.emag.system.domain.Menu;
import cn.emag.system.service.MenuService;

public class ManageMenuAction extends BaseAction {

	private Menu menu;

	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5497685592558431259L;

	/**
	 * 查询菜单
	 * 
	 * @return
	 */
	public String getSystemMenu() {
		String menuId = getStringParameter("menuId");
		if (StringUtils.isNotBlank(menuId)) {
			MenuService service = (MenuService) SpringContextHolder
					.getService("menuService");
			setMenu(service.getMenu(Integer.decode(menuId)));
		}
		return SUCCESS;
	}

	/**
	 * 增加或修改菜单
	 * 
	 * @return
	 */
	public String updateMenu() {
		MenuService service = (MenuService) SpringContextHolder
				.getService("menuService");
		if (menu.getMenuId() == null) {
//			menu.setMenuId(DataUtil.getNextIntegerID("SYS_MENU_SEQ"));
			// parentId == null添加的是一级节点
			if (menu.getMenuParentId() == null) {
				menu.setMenuParentId(0);
			}
			// 生成code
			String code = service.generatorCode(menu.getMenuParentId(), menu
					.getMenuCode());
			menu.setMenuCode(code);
			int menuId = service.insertMenu(menu);
			menu.setMenuId(menuId);
			setFlag("addSuccess");
		} else {
			service.updateMenu(menu);
			setFlag("updateSuccess");
		}
		return SUCCESS;
	}
}
