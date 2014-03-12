<%@ page language="java" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<title>File Upload</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/jquery/jquery-1.4.3.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/common.js"></script>
		<style type="text/css">
			body {
				font-size:12px;
			}
			a:link,a:visited{
				color:#0072ff;
				text-decoration:underline;
			}
			a:hover{
				text-decoration:none;
				background:blue;
				color:#ffffff;
			}
		</style>
		<script>
			$(document).ready(function() {
				upload = new Upload('access');
				upload.init();
			});
		</script>
	</head>
	<body>
		<form name="formadd" method="post" enctype="multipart/form-data"
			action="<%=request.getContextPath()%>/multiUploadServlet">
			<input type="file" name="accessFile" id="access" />
		</form>
		<div style="margin-top:20px;">
			<input type="button" value="提 交" style="width:80px;"
				onclick="document.forms[0].submit();" />
			<input type="button" value="取 消" style="width:80px;"
				onclick="upload.resetValue();" />
		</div>
	</body>
</html>
