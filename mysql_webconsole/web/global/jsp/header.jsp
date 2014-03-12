<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<title>头部</title>
		<link href="<%=request.getContextPath()%>/global/css/style.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/global/css/header.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/judy.js"></script>
		<script>
			function logout() {
				if (window.confirm('确定要退出系统吗?')) {
					window.location = '<%=request.getContextPath()%>/logout.action';
				}
			}
		</script>
	</head>
	<body>
		<div class="header_left"></div>
		<!-- 业务配置系统V1.0 勿删 -->
		<div class="header_right">
			<!-- header_right start -->
			<ul>
			    <li  id="wsj_tuichu">
					<a href="#" onclick="logout();return false;" class="quit"
						title="退出系统"></a>
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/toChangePwd.action"
						target="mainFrame" class="password" title="修改密码"></a>
				</li>
				<li>
					<a href="<%=request.getContextPath()%>/login.action" class="home"
						target="_parent" title="系统首页"></a>
				</li>
				
			</ul>
		</div>
		<!-- header_right end -->
	</body>
</html>
