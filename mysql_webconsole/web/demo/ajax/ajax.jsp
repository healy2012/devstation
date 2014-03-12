<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="emag" uri="/tags/emag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang='zh-CN' xml:lang='zh-CN' xmlns='http://www.w3.org/1999/xhtml'>
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<title>Demo</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/jquery/jquery-1.4.3.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/common.js"></script>
		<script>
			$(document).ready( function() {
				$('#hello').click(function() {
					ajax_json('<%=request.getContextPath()%>/demo/test?method=test',function(data) {
						alert(data.message);
					});
				});
			});
		</script>
		<style type="text/css">
			body,table,input,textarea,select {
				font-family: Verdana, sans-serif, 宋体;
			}
		</style>
	</head>
	<body>
		<div>
			<input type="button" id="hello" value="点 击">
		</div>
	</body>
</html>