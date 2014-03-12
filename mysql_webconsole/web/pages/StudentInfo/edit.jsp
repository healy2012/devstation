<%@page import="com.rao.dun.model.*" %>
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
    
    <title><%=StudentInfo.TABLE_ALIAS%>修改</title>
    
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
			"stuname":{
				required:true,
				minlength:0,
				maxlength:50
			},
			"password":{
				required:false,
				minlength:0,
				maxlength:50
			},
			"birthDate":{
				required:false,
				minlength:0,
				maxlength:7
			},
			"sex":{
				required:false,
				minlength:0,
				maxlength:22
			},
			"age":{
				required:false,
				minlength:0,
				maxlength:22
			},
		"test___":{
			required:false,
			minlength:0,
			maxlength:100
		}
	},
	messages: {
			"stuname":{
				required:'请输入stuname',
				minlength:'输入的stuname 字符数应该大于0',
				maxlength:'输入的stuname 字符数应该大于50'
			},
			"password":{
				required:'请输入password',
				minlength:'输入的password 字符数应该大于0',
				maxlength:'输入的password 字符数应该大于50'
			},
			"birthDate":{
				required:'请输入birthDate',
				minlength:'输入的birthDate 字符数应该大于0',
				maxlength:'输入的birthDate 字符数应该大于7'
			},
			"sex":{
				required:'请输入sex',
				minlength:'输入的sex 字符数应该大于0',
				maxlength:'输入的sex 字符数应该大于22'
			},
			"age":{
				required:'请输入age',
				minlength:'输入的age 字符数应该大于0',
				maxlength:'输入的age 字符数应该大于22'
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
   <span class="current">您现在的位置：<%=StudentInfo.TABLE_ALIAS%>管理&gt;<a target="_self" href="pages/StudentInfo/list.action"><%=StudentInfo.TABLE_ALIAS%>管理</a>&gt;<a target="_self" href="pages/StudentInfo/edit.action?stuId=${model.stuId}&">修改<%=StudentInfo.TABLE_ALIAS%></a></span>
  </h3>
   
  <h4 class="warning">请填写以下信息完成注册。加“*”为必填项。</h4>
  
  <s:form id="domain" action="pages/StudentInfo/update.action">
		<input type="hidden"" id="stuId" name="stuId" value="${model.stuId}"/>
  <table class="table_form">
    
	<!-- ONGL access static field: @package.class@field or @vs@field -->
		
		<tr>	
			<th >
				<span class="required">*</span><%=StudentInfo.ALIAS_STUNAME%>:
			</th>	
			<td>
			<input value="${model.stuname}"  id="stuname" name="stuname"  maxlength="50" class="required " />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<%=StudentInfo.ALIAS_PASSWORD%>:
			</th>	
			<td>
			<input value="${model.password}"  id="password" name="password"  maxlength="50" class="" />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<%=StudentInfo.ALIAS_BIRTH_DATE%>:
			</th>	
			<td>
			<input value="${model.birthDateString}" onclick="WdatePicker({dateFmt:'<%=StudentInfo.FORMAT_BIRTH_DATE%>'})" id="birthDateString" name="birthDateString"  maxlength="0" class="" />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<%=StudentInfo.ALIAS_SEX%>:
			</th>	
			<td>
			<input value="${model.sex}"  id="sex" name="sex"  maxlength="22" class="validate-integer " />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</tr>
		
		
		<tr>	
			<th >
				<%=StudentInfo.ALIAS_AGE%>:
			</th>	
			<td>
			<input value="${model.age}"  id="age" name="age"  maxlength="22" class="validate-integer " />
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
