<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<TITLE>出错了</TITLE>
		<link href="<%=request.getContextPath()%>/global/css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/jquery/jquery-1.4.3.min.js"></script>
		<script>
			$(document).ready(function() {
				var stack = $('#stack').html();
				if (stack && stack.indexOf('\n') != -1) {
					$('#stack').html(stack.replace(/\n/g,'<br />'));
				}
				$('div a').toggle(function() {
					$('#stack').show();
					$(this).html('隐藏堆栈信息');
				},function() {
					$('#stack').hide();
					$(this).html('显示堆栈信息');
				});
			});
		</script>
	</head>
	<body>
	<div class="body_bj">
	  <p style=" height:50px;font-size:20px;color:#F00; margin:20px 0px 20px 20px;">
        <img width="34" height="34" src="../../global/images/whju_03.jpg" style="float:left;"/>
        <span style="float:left;font-size:20px;margin:5px 0px 0px 10px;">系统出错，请联系管理员。</span>
      </p>

		<p>
			<div style="color:red;font-size:14px; margin-left: 25px;">
				<span>异常信息：<s:property value="exception.message" default="系统内部错误" /></span>
				<a href="#" onclick="return false;">显示堆栈信息</a>
			</div>
			<div id="stack" style="color:red;font-size:14px;display:none; margin-left: 25px;">
				<s:property value="exceptionStack"/>
			</div>
		</p>
	 </div>
	</body>
</html>