<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "action"> 
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
    
    <title><%=${className}.TABLE_ALIAS%>修改</title>
    
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
		<#list table.columns as column>
			<#if !column.htmlHidden>
				<#if column.isDateTimeColumn>
					"${column.columnNameLower}String":{
						required:${(!column.nullable)?string},
						byteRangeLength:[0,18]
					},
					<#elseif column.javaType == 'java.lang.String'>
					"${column.columnNameLower}":{
						required:${(!column.nullable)?string},
						byteRangeLength:[0,${column.size}]
					},
					<#else>
					"${column.columnNameLower}":{
						required:${(!column.nullable)?string},
						minlength:0,
						maxlength:${column.size},
						number:true
					},
				</#if>
			</#if>
		</#list>
					"test___":{
						required:false,
						minlength:0,
						maxlength:100
					}
	},
	messages: {
		<#list table.columns as column>
			<#if !column.htmlHidden>
				<#if column.isDateTimeColumn>
					"${column.columnNameLower}String":{
						required:'请输入${column.columnNameLower}',
						byteRangeLength:"在0-18个字符之间"
					},
					<#elseif column.javaType == 'java.lang.String'>
					"${column.columnNameLower}":{
						required:'请输入${column.columnNameLower}',
						byteRangeLength:"在0-${column.size}个字符之间(一个汉字为两个字符)"
					},
					<#else>
					"${column.columnNameLower}":{
						required:'请输入${column.columnNameLower}',
						minlength:'输入的${column.columnNameLower} 字符数应该大于0',
						maxlength:'输入的${column.columnNameLower} 字符数应该大于${column.size}',
						number:'请输入数字'
					},
				</#if>
			</#if>
		</#list>
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
   <span class="current">您现在的位置：<%=${className}.TABLE_ALIAS%>管理&gt;<a target="_self" href="${actionBasePath}/list.${actionExtension}"><%=${className}.TABLE_ALIAS%>管理</a>&gt;<a target="_self" href="${actionBasePath}/edit.${actionExtension}?<@generateIdQueryString/>">修改<%=${className}.TABLE_ALIAS%></a></span>
  </h3>
   
  <h4 class="warning">请填写以下信息完成注册。加“*”为必填项。</h4>
  
  <s:form id="domain" action="${actionBasePath}/update.${actionExtension}">
  <#list table.columns as column>
	  <#if column.htmlHidden>
		<input type="hidden"" id="${column.columnNameLower}" name="${column.columnNameLower}" value="<@jspEl 'model.'+column.columnNameLower/>"/>
	  </#if>
  </#list>
  <table class="table_form">
    
	<!-- ONGL access static field: @package.class@field or @vs@field -->
	<#list table.columns as column>
		<#if !column.htmlHidden>
		
		<tr>	
		<#if column.isDateTimeColumn>
			<th >
				<#if !column.nullable><span class="required">*</span></#if><%=${className}.ALIAS_${column.constantName}%>:
			</th>	
			<td>
			<input value="<@jspEl 'model.'+column.columnNameLower+'String'/>" onclick="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>'})" id="${column.columnNameLower}String" name="${column.columnNameLower}String"  maxlength="0" class="${column.validateString}" />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		<#else>
			<th >
				<#if !column.nullable><span class="required">*</span></#if><%=${className}.ALIAS_${column.constantName}%>:
			</th>	
			<td>
			<input value="<@jspEl 'model.'+column.columnNameLower/>"  id="${column.columnNameLower}" name="${column.columnNameLower}"  maxlength="${column.size}" class="${column.validateString}" />
			</td>
			<td class="place"><p class="annotation">提示信息</p></td>
		</#if>
		</tr>
		
		</#if>
	</#list>   
   
   
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
<#macro generateIdQueryString>
	<#if table.compositeId>
		<#assign itemPrefix = 'model.id.'>
	<#else>
		<#assign itemPrefix = 'model.'>
	</#if>
<#compress>
		<#list table.compositeIdColumns as column>
			<#t>${column.columnNameLower}=<@jspEl itemPrefix + column.columnNameLower/>&
		</#list>				
</#compress>
</#macro>