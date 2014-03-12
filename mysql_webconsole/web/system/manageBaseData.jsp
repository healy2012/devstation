<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="emag" uri="/tags/emag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<title>系统菜单管理</title>
		<link href="<%=request.getContextPath()%>/global/css/style.css"
			rel="stylesheet" type="text/css" />  
    	<link href="<%=request.getContextPath()%>/global/css/tree/zTreeStyle1.css" 
		    rel="stylesheet"  type="text/css"/>
		<link href="<%=request.getContextPath()%>/global/css/HeadContent.css" 
		    rel="stylesheet" type="text/css"/>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/jquery1.4.2.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/tree/jquery.ztree-2.6.min.js"></script>
		<style>
			.tree_area {
				OVERFLOW: auto ; 
				width: auto; 
				border:1px solid #cccccc; 
				padding:3px;
				background: #ffffff url("../images/bg_menu.gif") left bottom repeat-x;
			}
		</style>
		<script>
			function onSelect(event, treeId, treeNode) {
				$('iframe[name="main"]').attr('src','<%=request.getContextPath()%>/system/toEditBd.action?bdId=' + treeNode.id);
			}
			$(document).ready(function() {
				// 删除节点
				$('#doRemove').click(function() {   
					var treeNode = tree.getSelectedNode();
					if (!treeNode) {
						alert('请选择要删除的节点。');
						return ;
					} 
					if (window.confirm('该节点的所有子节点将被一起删除，您确定要删除吗？')) {
						var url = '${pageContext.request.contextPath}/system/doDelBd';
						var data = {bdId:treeNode.id,parentCode : treeNode.code};
						//alert("bdId:"+treeNode.id + " parentCode:" + data.parentCode);
						$.post(url,data,function(data) {
							tree.removeNode(treeNode);
							//window.location = '${pageContext.request.contextPath}/system/getSystemMenu';
						});
					}
				});
				
				// 新增节点
				$('#addChild').click(function() {
					var url = '${pageContext.request.contextPath}/system/toAddBd?bdId=${param.bdId}';
					var treeNode = tree.getSelectedNode();
					if (treeNode) {
						url = url + '&parentId=' + treeNode.id + '&parentCode=' + treeNode.code;
					}
					$('iframe[name="main"]').attr('src',url);
				});
				
				//新增根目录
				$('#addNewRoot').click(function() {
			     	tree.cancelSelectedNode();
			     	var url = '${pageContext.request.contextPath}/system/toAddBd?bdId=${param.bdId}';
					$('iframe[name="main"]').attr('src',url);
			    });
				
				   
			});   
		</script>   
	</head>
	<body>
	<div class="content">
	   <h3 class="breadcrumb">
            <span class="current">${requestScope.bdId}您现在的位置：系统管理&gt;<a target="systemMainFrame" href="<%=request.getContextPath()%>/system/manageBaseData.action">数据字典管理</a>&gt;</span>
       </h3>
     	<table width="97%" border="0" style="margin:5px auto 0 auto" valign="top" cellpadding="0" cellspacing="0" >
			<tr>
				<td rowspan="2"  style="padding: 0px 5px 0px 0px;" valign="top" width="200">
					<div  align="left"  style="height:550px;OVERFLOW:auto; width:200px;" class="tree_area" >
						<table  width="100%" border="0"  valign="top" cellpadding="0" cellspacing="0" >
							<tr>
								<td>
									<input type="button"  class="wsj_td" id="doRemove" value="&nbsp;删&nbsp;除&nbsp;" />
								</td>
								<td>
									<input type="button"  class="wsj_td" id="addChild" value="新增子项" />
								</td>
								<td>
									<input type="button"  class="wsj_td" id="addNewRoot" value="新增根目录" />
								</td>
							</tr>
						</table>
					    <emag:tree builder="cn.emag.system.web.ajax.BaseDataSettingTreeBuilder"  callback="onSelect"/>
					</div>	
				</td>
		    	<td valign="top">
		    		<iframe name="main" width="100%" height="550" src="" frameborder="0" scrolling="no" marginwidth="0" valign="top" align="left"></iframe>
				</td>
		  	</tr>
		</table>
	</div>
	</body>
</html>
