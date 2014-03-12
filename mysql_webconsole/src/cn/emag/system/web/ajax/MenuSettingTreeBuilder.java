/**
 * TODO
 * @author Administrator
 * Create on 2011-7-11
 */
package cn.emag.system.web.ajax;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.framework.taglib.tree.TreeBuilder;
import cn.emag.framework.taglib.tree.TreeNode;
import cn.emag.framework.taglib.tree.TreeNodeConverter;
import cn.emag.framework.taglib.tree.TreeUtil;
import cn.emag.system.domain.Menu;
import cn.emag.system.service.MenuService;

public class MenuSettingTreeBuilder extends TreeBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.emag.framework.taglib.tree.TreeBuilder#buildTree(javax.servlet.http
	 * .HttpServletRequest, javax.servlet.ServletContext)
	 */
	@Override
	public List<TreeNode> buildTree(HttpServletRequest request,
			ServletContext context) {
		MenuService service = (MenuService) SpringContextHolder
				.getService("menuService");
		Integer id = Integer.decode(parameter);
		List<Menu> list = service.listAllMenu(id);
		return TreeUtil.buildTree(list, "0", new TreeNodeConverter() {
			public TreeNode convert(Object obj) {
				Menu menu = (Menu) obj;
				TreeNode treeNode = new TreeNode();
				treeNode.setId(menu.getMenuId().toString());
				treeNode.setName(menu.getMenuTitle()+"[" + menu.getMenuSeq() + "]");
				treeNode.setCode(menu.getMenuCode());
				treeNode.setParentId(menu.getMenuParentId().toString());
				return treeNode;
			}
		});
	}

}
