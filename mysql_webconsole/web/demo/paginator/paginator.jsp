<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="emag" uri="/tags/emag"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<title>Demo</title>
		<link href="<%=request.getContextPath()%>/global/css/style.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/global/css/content.css"
			rel="stylesheet" type="text/css" />
		<style type="text/css">
			body,table,input,textarea,select {
				font-family: Verdana, sans-serif, 宋体;
			}
		</style>
	</head>
	<body>
		<div>
			
		</div>
		<div>
			<emag:paginator />
		</div>
	</body>
</html>