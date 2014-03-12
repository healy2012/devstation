<%@	page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Cache-Control" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<title>编辑菜单</title>
		<link href="<%=request.getContextPath()%>/global/css/style.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/global/css/content.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/jquery-1.4.3.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				var flag = '<s:property value="flag" />';
				if (flag == 'updateSuccess') {
					var tree = window.parent.tree ;
					var treeNode = tree.getSelectedNode();
					treeNode.name = '${menu.menuTitle}[${menu.menuSeq}]';
					tree.updateNode(treeNode);
				} else if (flag == 'addSuccess') {	
					var tree = window.parent.tree ;
					var parentNode = tree.getSelectedNode();
					var newNodes = [{id:'${menu.menuId}',name:'${menu.menuTitle}[${menu.menuSeq}]',code:'${menu.menuCode}',parentId:'${menu.menuParentId}'}];
					tree.addNodes(parentNode, newNodes);
					if (parentNode) {
						window.location = '${pageContext.request.contextPath}/system/getSystemMenu?menuId=' + parentNode.id;
					} else {
						var node = tree.getNodeByParam('id', '${menu.menuId}');
						tree.selectNode(node);
						window.location = '${pageContext.request.contextPath}/system/getSystemMenu?menuId=' + node.id;
					}
				}
				$('#doSubmit').click(function() {
					if (!$('#title').val()) {
						alert('请输入标题。');
						return;
					}
					var seq = $('#seq').val();
					if (!seq) {
						alert('请输入序号。');
						return;
					}
					if ((seq - 0) > 10000) {
						alert('序号不能大于10000。');
						return;
					}
					var url = '${pageContext.request.contextPath}/system/systemAjax?method=checkMenuSeq';
					var treeNode = window.parent.tree.getSelectedNode();
					var data = {navId:${menu.navId},parentId : treeNode.parentId,seq : (seq - 0),menuId : treeNode.id};
					$.post(url,data,function(data) {
						var json = window.eval('(' + data + ')');
						if (json.result) {
							alert('序号[' + seq + ']已经存在。');
						} else {
							document.forms[0].submit();
						}
					});
				});
				$('#addChild').click(function() {
					window.location = '${pageContext.request.contextPath}/system/toAdd?parentId=${menu.menuId}&navId=${menu.navId}&parentCode=${menu.menuCode}';
				});
				$('#seq').keypress(function(event) {
					var key = event.keyCode || event.which;
					if ((key<48) || (key>57 && key != 190)) { 
						return false ;
					}
				});
			});
		</script>
	</head>
	<body>
		<div class="content">
			<s:form action="updateMenu" method="post">
				<table class="table_form">
					<s:hidden id="menuId" name="menu.menuId" />
					<s:hidden id="navId" name="menu.navId" />
					<s:hidden id="menuCode" name="menu.menuCode" />
					<tr>
					  <th>菜单ID：</th>
                       <td><input name="menu.menuId" id="title" type="text" value="${menu.menuId}" disabled/></td>
                       <td class="place"><p class="annotation">菜单ID，可用于权限配置</p></td>
                    </tr>
                    <tr>
                    <th>标题：</th>
                       <td><input name="menu.menuTitle" id="title" type="text" value="${menu.menuTitle}" class="required" maxlength="10"/></td>
                       <td class="place"><p class="annotation">1-20个字符，只能包括中文字、英文字母、数字和下划线。一个中文为2个字符。</p></td>
                    </tr>
                    <tr>
                    <th>对应URL：</th>
                       <td><input name="menu.menuUrl" id="url" type="text" value="${menu.menuUrl}" class="required"/></td>
                       <td class="place"><p class="annotation">请填写正确的菜单链接地址。</p></td>
                    </tr>
                    <tr>
                       <th>序号：</th>
                       <td><input name="menu.menuSeq" id="seq" type="text" value="${menu.menuSeq}"/></td>
                       <td class="place"><p class="annotation">请输入新建菜单序号，只能为数字，菜单将按该序号从上到下排序</p></td>
                    </tr>
                
                    <tr>
                       <th>菜单状态：</th>
                        <s:if test="%{menu.menuStatus == 1}">
                           <td>
                                启用：<input type="radio" id="status" name="menu.menuStatus" value="1" checked/>
                                                        停用：<input type="radio" id="status" name="menu.menuStatus" value="0"/>
                          </td>
                        </s:if>
                       <s:if test="%{menu.menuStatus == 0}">
                       <td>
                           启用：<input type="radio" id="status" name="menu.menuStatus" value="1" />
                                               停用：<input type="radio" id="status" name="menu.menuStatus" value="0" checked/>
                         </td>
                    </s:if>
                   <td class="place"><p class="annotation">请选择菜单状态</p></td>
                    </tr>
                     
				</table>
				<p class="box_btn">
					<input type="button" class="wsj_button" id="doSubmit" value="保存" />
					<input type="button" class="wsj_button" id="addChild" value="增加子项" />
				</p>
			</s:form>
		</div>
	</body>
</html>
