<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<%@ taglib prefix="dynamicTable" uri="/tags/dynamicTable"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑资源表数据</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    
    <script src="bootstrap/js/jquery-1.9.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){

  $(":reset").click(function() {
	reg.resetForm();// 重置验证
  });
  
  $("#returnPrePage").click(
		function(){     
			window.location="<%=basePath%>datares/dynamicTableList.action?tab_id=<%=request.getParameter("tab_id")%>";
	     	//$(this).attr("href","<%=basePath%>datares/dynamicTableList.action?tab_id=<%=request.getParameter("tab_id")%>");
	    }
   );
  
	
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
<div class="container"><!-- content start -->
  <!-- 位置导航 -->
  <ul class="breadcrumb">
	  <li><i class="icon-home"></i><a href="datares/allTableConfig.action">数据表资源配置总览</a> <span class="divider">/</span></li>
	  <li><a href="datares/dynamicTableList.action?tab_id=${tab_id}">资源模型数据管理</a> <span class="divider">/</span></li>
	  <li class="active">数据表单编辑</li>
  </ul>
   <div class="alert">
	  <button type="button" class="close" data-dismiss="alert">&times;</button>
	  <h4 class="warning">请填写以下信息，加“*”为必填项。</h4>
  </div>
  <br/>
  <s2:if test="errorMsg!=null">
	  <div class="alert alert-error">
	  <h4 class="warning">${errorMsg}</h4>
	  </div>
  </s2:if>
  
  
  <form id="dynamicTabForm" class="form-horizontal" method="post" action="datares/dynamicTabForm.action">
  
    <dynamicTable:tableForm />
    
    <br/>
    <br/>
<div class="control-group">
	<div class="controls">
    <button type="submit" class="btn btn-large">提交</button>
    <button type="reset" class="btn btn-large">重写</button>
    <button id="returnPrePage" type="button" class="btn btn-large">返回</button>
	</div>
</div>
  </form>
</div><!-- content end -->
</body>
</html>
