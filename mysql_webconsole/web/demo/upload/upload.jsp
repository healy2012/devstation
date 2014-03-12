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
				$('#access').bind('keydown paste',function() {
					return false ;
				}).change(function() {
					addTempFile($(this)[0])
				});
			});
			var counter = 0 ;
			function addTempFile(obj) {
				counter++;
				var fileName = obj.value.substring(obj.value.lastIndexOf('\\')+1);
				var div = '<div name="tempFileName" style="margin-top:5px;" />';
				var span = '<span style="color:#000;">' + fileName + ' <a href="#" style="margin-left:5px;" onclick="removeTempFile(this,\''+(obj.id + counter)+'\');return false;">删除</a></span>';
				div = $(div).html(span);
				var input = '<input type="file" id="'+obj.id+'" name="'+obj.name+'">';
				$(input).bind('keydown paste',function() {
					return false ;
				}).change(function () {
					addTempFile($(this)[0]);
				}).insertBefore(obj.parentNode.firstChild);

				//hidden old file
				obj.name += counter ;
				obj.id += counter ;
				obj.style.display = 'none';
				obj.parentNode.appendChild($(div)[0]);
			}
			
			function removeTempFile(obj,id) {
				$(obj).parent().parent().remove();
				$('#' + id).remove();
			}
			
			function resetValue() {
				$('input[type="file"]:hidden').remove();
				$('div[name="tempFileName"]').remove();
			}
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
				onclick="resetValue();" />
		</div>
	</body>
</html>
