/**
 * TODO
 * @author Administrator
 * Create on 2011-7-1
 */
package cn.emag.demo.web.ajax;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import cn.emag.framework.taglib.tree.TreeBuilder;
import cn.emag.framework.taglib.tree.TreeNode;

public class DemoDynamicTreeBuilder extends TreeBuilder {

	private static List<TreeNode> list = new ArrayList<TreeNode>();
	static {
		createTreeNode("1", "江苏", "0", list, "N");
		createTreeNode("2", "浙江", "0", list, "N");
		createTreeNode("3", "湖南", "0", list, "N");
		createTreeNode("4", "山东", "0", list, "N");

		createTreeNode("5", "南京", "1", list, "N");
		createTreeNode("6", "扬州", "1", list, "N");
		createTreeNode("7", "杭州", "2", list, "N");
		createTreeNode("8", "嘉兴", "2", list, "N");
		createTreeNode("9", "长沙", "3", list, "N");
		createTreeNode("10", "常德", "3", list, "N");
		createTreeNode("11", "济南", "4", list, "N");
		createTreeNode("12", "青岛", "4", list, "N");

		createTreeNode("13", "六合", "5", list, "Y");
		createTreeNode("14", "高邮", "6", list, "Y");
		createTreeNode("15", "余杭", "7", list, "Y");
		createTreeNode("16", "海宁", "8", list, "Y");
		createTreeNode("17", "湘乡", "9", list, "Y");
		createTreeNode("18", "桃源", "10", list, "Y");
		createTreeNode("19", "长清", "11", list, "Y");
		createTreeNode("20", "胶州", "12", list, "Y");
	}

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
		String parentId = getId();
		if (StringUtils.isBlank(parentId)) {
			parentId = "0";
		}
		List<TreeNode> list = getList(parentId);
		return list;
	}

	private List<TreeNode> getList(String parentId) {
		List<TreeNode> lst = new ArrayList<TreeNode>();
		for (Iterator<TreeNode> iterator = list.iterator(); iterator.hasNext();) {
			TreeNode node = iterator.next();
			if (node.getParentId().equals(parentId)) {
				lst.add(node);
			}
		}
		return lst;
	}

	private static void createTreeNode(String id, String name, String parentId,
			List<TreeNode> list, String leafNodeFlag) {
		TreeNode node = new TreeNode();
		node.setId(id);
		node.setName(name);
		node.setParentId(parentId);
		node.setLeafNodeFlag(leafNodeFlag);
		list.add(node);
	}
}
