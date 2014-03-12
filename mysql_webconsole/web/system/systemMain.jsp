<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" content="text/html; charset=utf-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<title>系统管理</title>
		<link href="<%=request.getContextPath()%>/global/css/style.css"
			rel="stylesheet" type="text/css" media="screen" />
	</head>
	<frameset rows="*" cols="210,15,*" id="left" framespacing="0"" frameborder="no" border="0">
		<frame src="<%=request.getContextPath()%>/system/systemMenu.jsp?navId=${param.navId}"
			name="menuFrame" scrolling="no" noresize="noresize" />
		<frame src="<%=request.getContextPath()%>/global/jsp/left.jsp"
			name="leftFrame" scrolling="no" noresize="noresize"/>
		<frame src="<%=request.getContextPath()%>/global/jsp/content.jsp"
			name="systemMainFrame" noresize="noresize" />
	</frameset>
	<noframes>
		<body>
			很抱歉，阁下使用的浏览器不支援框架功能，请转用新的浏览器。
		</body>
	</noframes>
</html>
