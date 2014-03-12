<%@page import="com.rao.dun.model.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<rapid:override name="head">
	<title><%=StudentInfo.TABLE_ALIAS%>信息</title>
</rapid:override>

<rapid:override name="content">
	<s:form action="pages/StudentInfo/list.do" method="get" theme="simple">
		<input type="button" value="返回列表" onclick="window.location='${ctx}pages/StudentInfo/list.do'"/>
		<input type="button" value="后退" onclick="history.back();"/>
		
		<s:hidden name="stuId" id="stuId" value="%{model.stuId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=StudentInfo.ALIAS_STUNAME%></td>	
				<td><s:property value="%{model.stuname}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StudentInfo.ALIAS_PASSWORD%></td>	
				<td><s:property value="%{model.password}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StudentInfo.ALIAS_BIRTH_DATE%></td>	
				<td><s:property value="%{model.birthDateString}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StudentInfo.ALIAS_SEX%></td>	
				<td><s:property value="%{model.sex}" /></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=StudentInfo.ALIAS_AGE%></td>	
				<td><s:property value="%{model.age}" /></td>
			</tr>
		</table>
	</s:form>
</rapid:override>

