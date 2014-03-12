<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/jquery-1.4.3.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/tree/jquery.ztree-2.6.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/tree/searchTree.js"></script>
		<link href="<%=request.getContextPath()%>/global/css/tree/zTreeStyle1.css"
				rel="stylesheet" type="text/css" />
		<style >
			.line span{display:inline;}
		</style>
			
		<script type="text/javascript">
			$(document).ready( function() {
				//初始化 只针对部分input
				initEmagList('${pageContext.request.contextPath}/system/getListByFlag');
			});
		</script>
  </head>
  
  <body>
     <input id="rao" name="rao" typeFlag="status_type"  emagList="searchTree" simple="true" type="text" def="264" value="" style="width:80px;"/>
  	 </br>
  </body>
</html>
