<%@page import="com.emag.rao.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
   <span class="current">您现在的位置：<%=TcamsGroup.TABLE_ALIAS%>管理&gt;<a target="_self" href="pages/TcamsGroup/list.action"><%=TcamsGroup.TABLE_ALIAS%>管理</a>&gt;<a target="_self" href="pages/TcamsGroup/show.action?	
groupId=${groupId}">详情<%=TcamsGroup.TABLE_ALIAS%></a></span>
  </h3>

	<s:form action="pages/TcamsGroup/list.do" method="get" theme="simple">
		
		
		<s:hidden name="groupId" id="groupId" value="%{model.groupId}"/>
	
		<table class="table_form">
			<tr>	
				<th class="tdLabel"><%=TcamsGroup.ALIAS_GROUP_NAME%></th>	
				<td><s:property value="%{model.groupName}" /></td>
			</tr>
			<tr>	
				<th class="tdLabel"><%=TcamsGroup.ALIAS_GROUP_DESC%></th>	
				<td><s:property value="%{model.groupDesc}" /></td>
			</tr>
			<tr>	
				<th class="tdLabel"><%=TcamsGroup.ALIAS_PARENT_GROUP_ID%></th>	
				<td><s:property value="%{model.parentGroupId}" /></td>
			</tr>
			<tr>	
				<th class="tdLabel"><%=TcamsGroup.ALIAS_LEVEL_ID%></th>	
				<td><s:property value="%{model.levelId}" /></td>
			</tr>
			<tr>	
				<th class="tdLabel"><%=TcamsGroup.ALIAS_GROUP_TYPE%></th>	
				<td><s:property value="%{model.groupType}" /></td>
			</tr>
			<tr>	
				<th class="tdLabel"><%=TcamsGroup.ALIAS_SYSTEM_ID%></th>	
				<td><s:property value="%{model.systemId}" /></td>
			</tr>
		</table>
		<p class="box_btn">
		<button type="button" onclick="window.location='${ctx}pages/TcamsGroup/list.do'">返回列表</button>
		<button type="button" onclick="history.back();">后退</button>
		</p>
	</s:form>
</div>
</body>
