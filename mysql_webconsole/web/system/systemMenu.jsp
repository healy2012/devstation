<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="emag" uri="/tags/emag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>菜单</title>
		<link href="<%=request.getContextPath()%>/global/css/style.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/global/css/menu.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/global/css/tree/zTreeStyle.css" 
		    rel="stylesheet" type="text/css"/>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/jquery1.4.2.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/tree/jquery.ztree-2.6.min.js"></script>
	   
	   <script type="">
		$(document).ready(function(){
	       $(".tree").find("span").hover(
             function() {
               $(this).addClass("treeClass");
              },
            function() {
               $(this).removeClass("treeClass");
              })
              ;
	     })
        </script>
		
	</head>
	<body>
		<div class="box_menu">
			<emag:tree builder="cn.emag.system.web.ajax.MenuTreeBuilder" parameter="${param.navId}" />
		</div>
		<!-- box_menu end -->
	</body>
</html>
