<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>新建用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="<%=path%>/global/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="<%=path%>/global/css/content.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=path%>/global/scripts/jquery/jquery1.4.2.js"></script>
    <script type="text/javascript" src="<%=path%>/global/scripts/jquery/jquery.tableCss.js"></script>
        <script type="text/javascript" src="<%=path%>/global/scripts/jquery/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=path%>/global/scripts/jquery/jquery.addmethod.js"></script>

<script type="text/javascript">
$(document).ready(function(){

  $(":reset").click(function() {
	reg.resetForm();// 重置验证
  });
  
	
  var reg = $("#reg").validate({
	onkeyup:false,
	errorPlacement: function(error, element) {
	  error.appendTo( element.parent("td").next("td") );//验证信息显示位置
	},
	rules: {
	    "userInfo.userName":{
		userName: true,
		byteRangeLength: [3,20],
		remote: {
		          url:"<%=request.getContextPath()%>/demo/validateUser.action?method=validateUser",
		          type:"post",
		          datatype:"json",
		          data:{
		                   
		               }
		        }
	  },
	   "userInfo.password": {
		minlength: 6,
		maxlength: 20,
		passwordCH:true
	  },
	  confirm_password: {
		minlength: 5,
		maxlength: 20,
		equalTo: "#password"
	  },
	  "userInfo.name": {
		character: true,
		byteRangeLength: [4,16]
	  },
	  "userInfo.tel": {
		isMobile: true
	  },
	  "userInfo.email": {
		email: true
	  }
	},
	messages: {
	    "userInfo.userName": {
		required: "请输入登录帐号",
		userName:"登陆帐号只能包括中文字、英文字母、数字和下划线",
		byteRangeLength:"登陆帐号在3-20个字符之间(一个汉字为两个字符)",
		remote:"该账号已存在"
	  },
	  "userInfo.password": {
		required: "请输入登录密码",
		minlength: "您的登录密码必须至少为6个字符长",
		maxlength: "您的登录密码不能超过20个字符长",
		passwordCH: "只能包含数字、英文字母或者下划线"
	  },
	  confirm_password: {
		required: "请输入登录密码",
		minlength: "您的登录密码必须至少为6个字符长",
		maxlength: "您的登录密码不能超过20个字符长",
		equalTo: "请输入与上面相同的密码"
	  },
	  "userInfo.name": {
		required: "请填写您的真实姓名",
		character: "只能输入汉字",
		byteRangeLength:"至少两个汉字，不超过八个"
	  },
	  "userInfo.tel": {
		required: "请填写您的真实手机号",
		isMobile: "请正确填写您的手机号码"
	  },
	  "userInfo.email": {
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
  
  <s2:form id="reg" action="demo/createUser.action">
  <table class="table_form">
    <tr>
      <th>登录帐号：</th>
      <td><input name="userInfo.userName" id="username" type="text" value="" class="required" maxlength="20"/></td>
      <td class="place"><p class="annotation">3-20个字符，只能包括中文字、英文字母、数字和下划线</p></td>
    </tr>
    <tr>
      <th>登录密码：</th>
      <td><input name="userInfo.password" id="password" type="password" value="" class="required"/></td>
      <td class="place"><p class="annotation">由6-20个英文字母、数字或符号组成</p></td>
    </tr>
    <tr>
      <th>确认登陆密码：</th>
      <td><input name="confirm_password" id="confirm_password" type="password" value="" class="required"/></td>
      <td class="place"><p class="annotation">请再输入一遍您上面填写的密码</p></td>
    </tr>
    <tr>
      <th>真实姓名：</th>
      <td><input name="userInfo.name" id="realname" type="text" class="required" value=""/></td>
      <td class="place"><p class="annotation">请填写您的真实姓名。只能使用汉字，且至少两个汉字</p></td>
    </tr>
    <tr>
      <th>E-mail：</th>
      <td><input name="userInfo.email" id="email" type="text" value="" class="required"/></td>
      <td class="place"><p class="annotation">请填写真实并且最常用的邮箱</p></td>
    </tr>
    <tr>
      <th>手机号码：</th>
      <td><input name="userInfo.tel" id="mobile" type="text" value="" class="required"/></td>
      <td class="place"><p class="annotation">请填写您的真实手机号</p></td>
    </tr>
  </table>
    
  <p class="box_btn">
    <button type="submit" class="enter"><span>确定</span></button>
    <button type="reset" class="reset"><span>重写</span></button>
    <button type="button" class="back" onclick="history.go(-1)"><span>返回</span></button>
  </p>
  </s2:form>
</div><!-- content end -->
</body>
</html>
