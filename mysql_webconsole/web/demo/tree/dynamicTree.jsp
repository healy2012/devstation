<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="emag" uri="/tags/emag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang='zh-CN' xml:lang='zh-CN' xmlns='http://www.w3.org/1999/xhtml'>
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<title>Dynamic Tree Demo</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/global/css/tree/zTreeStyle.css" type="text/css">
		<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/jquery/jquery-1.4.3.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/tree/jquery.ztree-2.6.min.js"></script>
		<script>
			function onSelect(event, treeId, treeNode) {
				alert(treeNode.name);
			}
		</script>
	</head>
	<body>
		<div>
			<emag:tree builder="cn.emag.demo.web.ajax.DemoDynamicTreeBuilder"
				callback="onSelect" dynamic="true" />
		</div>
	</body>
</html>