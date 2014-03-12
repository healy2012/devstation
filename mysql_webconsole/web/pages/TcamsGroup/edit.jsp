<%@page import="com.emag.rao.model.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title><%=TcamsGroup.TABLE_ALIAS%>修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="global/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="global/css/content.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="global/scripts/jquery/jquery1.4.2.js"></script>
    <script type="text/javascript" src="global/scripts/jquery/jquery.validate.js"></script>
    <script type="text/javascript" src="global/scripts/jquery/jquery.addmethod.js"></script>
    <script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){

  $(":reset").click(function() {
	reg.resetForm();// 重置验证
  });
  
  var reg = $("#domain").validate({
	onkeyup:false,
	errorPlacement: function(error, element) {
	  error.appendTo( element.parent("td").next("td") );//验证信息显示位置
	},
	rules: {
					"groupName":{
						required:true,
						byteRangeLength:[0,255]
					},
					"groupDesc":{
						required:false,
						byteRangeLength:[0,255]
					},
					"parentGroupId":{
						required:true,
						minlength:0,
						maxlength:22,
						number:true
					},
					"levelId":{
						required:true,
						minlength:0,
						maxlength:22,
						number:true
					},
					"groupType":{
						required:true,
						minlength:0,
						maxlength:22,
						number:true
					},
					"systemId":{
						required:true,
						minlength:0,
						maxlength:22,
						number:true
					},
					"test___":{
						required:false,
						minlength:0,
						maxlength:100
					}
	},
	messages: {
					"groupName":{
						required:'请输入groupName',
						byteRangeLength:"在0-255个字符之间(一个汉字为两个字符)"
					},
					"groupDesc":{
						required:'请输入groupDesc',
						byteRangeLength:"在0-255个字符之间(一个汉字为两个字符)"
					},
					"parentGroupId":{
						required:'请输入parentGroupId',
						minlength:'输入的parentGroupId 字符数应该大于0',
						maxlength:'输入的parentGroupId 字符数应该大于22',
						number:'请输入数字'
					},
					"levelId":{
						required:'请输入levelId',
						minlength:'输入的levelId 字符数应该大于0',
						maxlength:'输入的levelId 字符数应该大于22',
						number:'请输入数字'
					},
					"groupType":{
						required:'请输入groupType',
						minlength:'输入的groupType 字符数应该大于0',
						maxlength:'输入的groupType 字符数应该大于22',
						number:'请输入数字'
					},
					"systemId":{
						required:'请输入systemId',
						minlength:'输入的systemId 字符数应该大于0',
						maxlength:'输入的systemId 字符数应该大于22',
						number:'请输入数字'
					},
				    "test___": {
					required: "请输入登录帐号",
					userName:"登陆帐号只能包括中文字、英文字母、数字和下划线",
					byteRangeLength:"登陆帐号在3-20个字符之间(一个汉字为两个字符)",
					remote:"该账号已存在"
	  				}
				},
	success: function(label) {
	  label.text("填写正确").addClass("success");
	}
  });
});
</script>
    
    
  </head>
  
  <body>
<div class="content"><!-- content start -->
   <h3 class="breadcrumb">
   <span class="current">您现在的位置：<%=TcamsGroup.TABLE_ALIAS%>管理&gt;<a target="_self" href="pages/TcamsGroup/list.action"><%=TcamsGroup.TABLE_ALIAS%>管理</a>&gt;<a target="_self" href="pages/TcamsGroup/edit.action?groupId=${model.groupId}&">修改<%=TcamsGroup.TABLE_ALIAS%></a></span>
  </h3>
   
  <h4 class="warning">请填写以下信息完成注册。加“*”为必填项。</h4>
  
  <s:form id="domain" action="pages/TcamsGroup/update.action">
		<input type="hidden"" id="groupId" name="groupId" value="${model.groupId}"/>
  <table class="table_form">
    
	<!-- ONGL access static field: @package.class@field or @vs@field -->
		
		<tr>	
			<th >
				<span class="required">*</span><%=TcamsGroup.ALIAS_GROUP_NAME%>:
			</th>	
			<td>
			<input value="${model.groupName}"  id="groupName" name="groupName"  maxlength="255" class="required " />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<%=TcamsGroup.ALIAS_GROUP_DESC%>:
			</th>	
			<td>
			<input value="${model.groupDesc}"  id="groupDesc" name="groupDesc"  maxlength="255" class="" />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<span class="required">*</span><%=TcamsGroup.ALIAS_PARENT_GROUP_ID%>:
			</th>	
			<td>
			<input value="${model.parentGroupId}"  id="parentGroupId" name="parentGroupId"  maxlength="22" class="required validate-integer " />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<span class="required">*</span><%=TcamsGroup.ALIAS_LEVEL_ID%>:
			</th>	
			<td>
			<input value="${model.levelId}"  id="levelId" name="levelId"  maxlength="22" class="required validate-integer " />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<span class="required">*</span><%=TcamsGroup.ALIAS_GROUP_TYPE%>:
			</th>	
			<td>
			<input value="${model.groupType}"  id="groupType" name="groupType"  maxlength="22" class="required validate-integer " />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<span class="required">*</span><%=TcamsGroup.ALIAS_SYSTEM_ID%>:
			</th>	
			<td>
			<input value="${model.systemId}"  id="systemId" name="systemId"  maxlength="22" class="required validate-integer " />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
   
   
  </table>
    
  <p class="box_btn">
    <button type="submit" class="enter">确定</button>
    <button type="reset" class="reset">重写</button>
    <button type="button" class="back" onclick="history.go(-1)">返回</button>
  </p>
  </s:form>
</div><!-- content end -->
</body>
</html>
