/**
 * TODO
 * @author Administrator
 * Create on 2011-6-30
 */
package cn.emag.demo.web.ajax;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import cn.emag.framework.taglib.tree.TreeBuilder;
import cn.emag.framework.taglib.tree.TreeNode;
import cn.emag.framework.taglib.tree.TreeNodeConverter;
import cn.emag.framework.taglib.tree.TreeUtil;

public class DemoStaticTreeBuilder extends TreeBuilder {

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
		List<TreeNode> list = getList();
		return TreeUtil.buildTree(list, "0", new TreeNodeConverter() {
			public TreeNode convert(Object obj) {
				return (TreeNode) obj;
			}
		});
	}

	private List<TreeNode> getList() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		createTreeNode("1", "江苏", "0", list);
		createTreeNode("2", "浙江", "0", list);
		createTreeNode("3", "湖南", "0", list);
		createTreeNode("4", "山东", "0", list);

		createTreeNode("5", "南京", "1", list);
		createTreeNode("6", "扬州", "1", list);
		createTreeNode("7", "杭州", "2", list);
		createTreeNode("8", "嘉兴", "2", list);
		createTreeNode("9", "长沙", "3", list);
		createTreeNode("10", "常德", "3", list);
		createTreeNode("11", "济南", "4", list);
		createTreeNode("12", "青岛", "4", list);

		createTreeNode("13", "六合", "5", list);
		createTreeNode("14", "高邮", "6", list);
		createTreeNode("15", "余杭", "7", list);
		createTreeNode("16", "海宁", "8", list);
		createTreeNode("17", "湘乡", "9", list);
		createTreeNode("18", "桃源", "10", list);
		createTreeNode("19", "长清", "11", list);
		createTreeNode("20", "胶州", "12", list);
		return list;
	}

	private void createTreeNode(String id, String name, String parentId,
			List<TreeNode> list) {
		TreeNode node = new TreeNode();
		node.setId(id);
		node.setName(name);
		node.setParentId(parentId);
		list.add(node);
	}
}
