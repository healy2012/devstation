<%@page import="com.rao.dun.model.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>新建<%=UserInfo.TABLE_ALIAS%></title>
    
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
    <script type="text/javascript" src="global/scripts/jquery/jquery.tableCss.js"></script>
        <script type="text/javascript" src="global/scripts/jquery/jquery.validate.js"></script>
    <script type="text/javascript" src="global/scripts/jquery/jquery.addmethod.js"></script>
    <script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function(){

  $(":reset").click(function() {
	reg.resetForm();// 重置验证
  });
  
	
  var domain = $("#domain").validate({
	onkeyup:false,
	errorPlacement: function(error, element) {
	  error.appendTo( element.parent("td").next("td") );//验证信息显示位置
	},
	rules: {
	    "username":{userName: true,byteRangeLength: [3,20],},
	   "password": {minlength: 6,maxlength: 20,passwordCH:true},
	  "birthDateString": {character: true,byteRangeLength: [4,16]},
	  "sex": {isMobile: true},
	  "age": {email: true}
	},
	messages: {
	    "username": {
		required: "请输入登录帐号",
		userName:"登陆帐号只能包括中文字、英文字母、数字和下划线",
		byteRangeLength:"登陆帐号在3-20个字符之间(一个汉字为两个字符)",
		remote:"该账号已存在"
	  },
	  "password": {
		required: "请输入登录密码",
		minlength: "您的登录密码必须至少为6个字符长",
		maxlength: "您的登录密码不能超过20个字符长",
		passwordCH: "只能包含数字、英文字母或者下划线"
	  },
	  "birthDateString": {
		required: "请填写您的真实姓名",
		character: "只能输入汉字",
		byteRangeLength:"至少两个汉字，不超过八个"
	  },
	  "sex": {
		required: "请填写您的真实手机号",
		isMobile: "请正确填写您的手机号码"
	  },
	  "age": {
		required: "请填写真实并且最常用的邮箱",
		email: "请输入一个有效的邮箱地址"
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
   <span class="current">您现在的位置：用户管理DEMO&gt;<a target="mainFrame" href="<%=basePath%>demo/portal/queryPortalUser.action">用户管理</a>&gt;<a target="mainFrame" href="<%=basePath%>demo/addUser.action">增加用户</a></span>
  </h3>
   
  <h4 class="warning">请填写以下信息完成注册。加“*”为必填项。</h4>
  
  <s:form id="domain" name="domain" action="pages/UserInfo/save.action" method="post">
  
			<s:hidden id="userId" name="userId" />
  
  <table class="table_form">
    <!-- ONGL access static field: @package.class@field or @vs@field -->
		
		
		<tr>	
			<th>
				<span class="required">*</span><%=UserInfo.ALIAS_USERNAME%>:
			</th>	
			<td>
			<input value="${model.username}"  id="username" name="username"  maxlength="50" class="required " required="true"/>
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		
		<tr>	
			<th>
				<%=UserInfo.ALIAS_PASSWORD%>:
			</th>	
			<td>
			<input value="${model.password}"  id="password" name="password"  maxlength="50" class="" required="false"/>
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<%=UserInfo.ALIAS_BIRTH_DATE%>:
			</th>	
			<td>
			<input value="${model.birthDateString}" onclick="WdatePicker({dateFmt:'<%=UserInfo.FORMAT_BIRTH_DATE%>'})" id="birthDateString" name="birthDateString"  maxlength="0" class="" />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		
		<tr>	
			<th>
				<%=UserInfo.ALIAS_SEX%>:
			</th>	
			<td>
			<input value="${model.sex}"  id="sex" name="sex"  maxlength="22" class="validate-integer " required="false"/>
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		
		<tr>	
			<th>
				<%=UserInfo.ALIAS_AGE%>:
			</th>	
			<td>
			<input value="${model.age}"  id="age" name="age"  maxlength="22" class="validate-integer " required="false"/>
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
