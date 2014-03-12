<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" content="text/html; charset=utf-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<title>统一框架</title>
		<link href="<%=request.getContextPath()%>/global/css/style.css"
			rel="stylesheet" type="text/css" media="screen" />
	</head>
	<frameset rows="99,49,642*" cols="*" id="top" framespacing="0"
		frameborder="no" border="0"> 
		<frame src="<%=request.getContextPath()%>/global/jsp/header.jsp"
			name="topFrame" scrolling="no" noresize="noresize" id="topFrame"
			title="topFrame" />
		<frame src="<%=request.getContextPath()%>/global/jsp/top.jsp" name="top"
			scrolling="no" noresize="noresize" id="top" title="top" />
		<frameset rows="11*,25" cols="*">
			<frame src="<%=request.getContextPath()%>/global/jsp/content.jsp"
				name="mainFrame" noresize="noresize" id="mainFrame"
				title="mainFrame" />
			<frame src="<%=request.getContextPath()%>/global/jsp/footer.jsp"
				name="footFrame" noresize="noresize" id="footFrame"
				title="footFrame" />
		</frameset>
	</frameset>
	<noframes>
		<body>
			很抱歉，阁下使用的浏览器不支援框架功能，请转用新的浏览器。
		</body>
	</noframes>
</html>
