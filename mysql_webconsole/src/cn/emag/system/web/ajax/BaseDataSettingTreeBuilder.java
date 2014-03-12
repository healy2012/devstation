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
import cn.emag.system.domain.BaseData;
import cn.emag.system.domain.Menu;
import cn.emag.system.service.BaseDataService;
import cn.emag.system.service.MenuService;

public class BaseDataSettingTreeBuilder extends TreeBuilder {

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
		BaseDataService service = (BaseDataService) SpringContextHolder
				.getService("baseDataService");
//		Integer id = Integer.decode(parameter);
		List<Menu> list = service.listAll();
		System.out.println("BaseDataSettingTreeBuilder:list size "+list.size());
		return TreeUtil.buildTree(list, "0", new TreeNodeConverter() {
			public TreeNode convert(Object obj) {
				BaseData menu = (BaseData) obj;
				TreeNode treeNode = new TreeNode();
				treeNode.setId(menu.getBdId().toString());
				treeNode.setName(menu.getBdName()+"[" + menu.getBdLvl() + "]");
				treeNode.setCode(menu.getBdLvl()+"");
				treeNode.setParentId(menu.getBdParentId().toString());
				return treeNode;
			}
		});
	}

}
