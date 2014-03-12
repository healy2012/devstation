<%@page import="${basepackage}.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign actionExtension = "do"> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title><%=TcamsGroup.TABLE_ALIAS%>详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="global/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="global/css/content.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="content"><!-- content start -->
   <h3 class="breadcrumb">
   <span class="current">您现在的位置：<%=TcamsGroup.TABLE_ALIAS%>管理&gt;<a target="_self" href="pages/TcamsGroup/list.action"><%=TcamsGroup.TABLE_ALIAS%>管理</a>&gt;<a target="_self" href="pages/TcamsGroup/show.action?<@generateIdForGetBy/>">详情<%=TcamsGroup.TABLE_ALIAS%></a></span>
  </h3>

	<s:form action="${actionBasePath}/list.${actionExtension}" method="get" theme="simple">
		
		
	<#list table.columns as column>
	<#if column.pk>
		<s:hidden name="${column.columnNameLower}" id="${column.columnNameLower}" value="%{model.${column.columnNameLower}}"/>
	</#if>
	</#list>
	
		<table class="table_form">
		<#list table.columns as column>
		<#if !column.htmlHidden>
			<tr>	
				<th class="tdLabel"><%=${className}.ALIAS_${column.constantName}%></th>	
				<td><#rt>
				<#compress>
				<#if column.isDateTimeColumn>
				<s:property value="%{model.${column.columnNameLower}String}" />
				<#else>
				<s:property value="%{model.${column.columnNameLower}}" />
				</#if>
				</#compress>
				<#lt></td>
			</tr>
		</#if>
		</#list>
		</table>
		<p class="box_btn">
		<button type="button" onclick="window.location='<@jspEl 'ctx'/>${actionBasePath}/list.${actionExtension}'">返回列表</button>
		<button type="button" onclick="history.back();">后退</button>
		</p>
	</s:form>
</div>
</body>
<#macro generateIdForGetBy>
	
<#compress>
		<#list table.compositeIdColumns as column>
			<#t>${column.columnNameLower}=<@jspEl   column.columnNameLower/>
		</#list>				
</#compress>
</#macro>