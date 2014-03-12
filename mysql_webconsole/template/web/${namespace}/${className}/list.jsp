<%@page import="${basepackage}.model.*" %>
<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="emag" uri="/tags/emag"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
  
    <title><%=${className}.TABLE_ALIAS%>管理</title>
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
    <script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script type="text/javascript">
    $(document).ready(function(){
    
    $(".table_list").tableCss(); //此处为表格动态样式
    
    $("#update").click(
     function(){
      var i = 0;
      var f_str = '';
     $("input[name='item']").each(function(){
       if($(this).attr("checked") == true)
       {
        i = i + 1;
        f_str += $(this).attr("id")+",";
       }
     });
    
    if(i != 1)
    {
      alert("请选择一条用户信息进行修改");
   
      return false;
    }
    else
    {
     $(this).attr("href","<%=basePath%>${actionBasePath}/edit.action?items="+f_str);
    }
    
    }); 
    
    $("#delete").click(
    function(){
    var i = 0;
    var f_str = '';
    $("input[name='item']").each(function(){
       if($(this).attr("checked") == true)
       {
        i = i + 1;
        f_str += $(this).attr("id")+",";
       }
    });
    
    if(i == 0)
    {
      alert("请选择一条或多条数据进行删除");
   
      return false; 
    }
    else
    {
      var flag = confirm("您是否确定删除这些数据?");
      
      if(flag)
      {
        $(this).attr("href","<%=basePath%>${actionBasePath}/delete.action?items="+f_str);
      }
      else
      {
        return false;
      }
    }
    
    }
   ); 
   
    var i = 0;
   $("input[name='checkAll']").click(function() { 
    if ($(this).attr("checked") == true) { // 全选 
    $("input[name='item']").each(function() { 
    $(this).attr("checked", true); 
    }); 
    i=$("input[name='item']").length;
    } else { // 取消全选 
     $("input[name='item']").each(function() { 
     $(this).attr("checked", false); 
    });
    i=0;
   } 
   }); 

   $("input[name='item']").click(function() {   
      if($(this).attr("checked") == null){
          $("#checkAll").attr("checked",false);
          i=i-1;
      }
      
      if($(this).attr("checked") == true){
          i=i+1;
      }
      
      if(i==$("input[name='item']").length)
      {
       $("#checkAll").attr("checked",true);
      }
   });
    
}); 
    
    
 //   function obtainIds()
 //  { 
 //    var f_str = '';
 //    $("input[@name='item']").each(function(){
 //    if($(this).attr("checked")==true){
 //    f_str += $(this).attr("id")+",";
     
 //    return f_str;
     
 //   }
 //   })
 //   $("#delete").attr("href","<%=basePath%>demo/portal/delUsers.action?userIds="+f_str);
    
 //   $("#update").attr("href","<%=basePath%>demo/portal/updateUser.action?userIds="+f_str);
 //   }

   </script>
  </head>
   <body>
    <div class="content"><!-- content start -->
   <h3 class="breadcrumb">
   <span class="current">您现在的位置：<%=${className}.TABLE_ALIAS%>管理&gt;<a target="mainFrame" href="${actionBasePath}/list.action"><%=${className}.TABLE_ALIAS%>管理</a></span>
  </h3>
   
 <form id="search" action="${actionBasePath}/list.action" method="post"/>
  <ul class="box_search">
       			<#list table.notPkColumns?chunk(2) as row>
					<#list row as column>
					<#if !column.htmlHidden>	
	      				<li class="<#if column.isDateTimeColumn>search_date<#else>search</#if>">
						<span><%=${className}.ALIAS_${column.constantName}%></span>		
						
							<#if column.isDateTimeColumn>
							<input value="<fmt:formatDate value='<@jspEl "query."+column.columnNameLower+'Begin'/>' pattern='<%=${className}.FORMAT_${column.constantName}%>'/>" onclick="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>'})" id="${column.columnNameLower}Begin" name="${column.columnNameLower}Begin"   />
							<input value="<fmt:formatDate value='<@jspEl "query."+column.columnNameLower+'End'/>' pattern='<%=${className}.FORMAT_${column.constantName}%>'/>" onclick="WdatePicker({dateFmt:'<%=${className}.FORMAT_${column.constantName}%>'})" id="${column.columnNameLower}End" name="${column.columnNameLower}End"   />
							<#else>
							<input value="<@jspEl "query."+column.columnNameLower/>" id="${column.columnNameLower}" name="${column.columnNameLower}" maxlength="${column.size}"  class="${column.noRequiredValidateString}"/>
							</#if>
						
	      				</li>
					</#if>
					</#list>
				</#list>	
      <li class="btn">
       <button type="submit" class="wsj_but">搜 索</button>
       <button type="reset"  class="wsj_but">重 置</button>
      </li>
  </ul>
  </form>
  
  <table class="table_list">
    <tr>
      <th><input name="checkAll" type="checkbox" value="全选/取消全选" /></th>
      
	  <!-- 排序时为th增加sortColumn即可,new SimpleTable('sortColumns')会为tableHeader自动增加排序功能; -->
	  <#list table.columns as column>
	  <#if !column.htmlHidden>
	  <th sortColumn="${column.sqlName}" ><%=${className}.ALIAS_${column.constantName}%></th>
	  <#else>
	  <th>id</th>
	  </#if>
	  </#list>

    </tr>
   
     <s:iterator value="#request.page.result" id="item">
     <tr>
      <td><input name="item" id="<@generateIdQueryString/>" type="checkbox" value="<@generateIdQueryString/>" /></td>

	  		<#list table.columns as column>
				<#if !column.htmlHidden>
				<td><#rt>
					<#compress>
					<#if column.isDateTimeColumn>
					<@jspEl "item."+column.columnNameLower+"String"/>&nbsp;
					<#else>
					<@jspEl "item."+column.columnNameLower/>&nbsp;
					</#if>
					</#compress>
				<#lt></td>
				<#else>
				<td>
				<a href="<%=basePath%>${actionBasePath}/show.action?<@generateIdForGetBy/>"><@jspEl "item."+column.columnNameLower/></a>
				</td>
				</#if>
			</#list>

    </tr>
    </s:iterator>
  </table>

  <p class="pagination"><!-- pagination start -->
     <emag:paginate_new total="<@jspEl 'totalRows' />" action="${actionBasePath}/list.action" pageSize="<@jspEl 'query.pageSize' />" pageNumber="<@jspEl 'query.pageNumber'/>" >
     	<#list table.notPkColumns?chunk(2) as row>
					<#list row as column>
					<#if !column.htmlHidden>	
							<#if column.isDateTimeColumn>
							<emag:paginate_param name="${column.columnNameLower}Begin" value="<@jspEl "query."+column.columnNameLower+'Begin'/>" />
							<emag:paginate_param name="${column.columnNameLower}End" value="<@jspEl "query."+column.columnNameLower+'End'/>" />
							<#else>
							<emag:paginate_param name="${column.columnNameLower}" value="<@jspEl "query."+column.columnNameLower/>"/>
							</#if>
					</#if>
					</#list>
				</#list>	
     </emag:paginate_new>
  </p><!-- pagination end -->
  
  <p class="box_tool"><!-- box_tool start -->
    <a href="${actionBasePath}/create.action" target="_self" class="add" title="新建"><span>新建</span></a>
    <a href="#" id="update" target="_self" class="edite" title="修改"><span>修改</span></a>
    <a href="#" id="delete" target="_self" class="delete" title="删除"><span>删除</span></a>
  </p><!-- box_tool end -->
</div><!-- content end -->
</body>
  </body>
</html>
<#macro generateIdQueryString>
	<#if table.compositeId>
		<#assign itemPrefix = 'item.id.'>
	<#else>
		<#assign itemPrefix = 'item.'>
	</#if>
<#compress>
		<#list table.compositeIdColumns as column>
			<#t>${column.columnNameLower}=<@jspEl itemPrefix + column.columnNameLower/>&
		</#list>				
</#compress>
</#macro>
<#macro generateIdForGetBy>
<#compress>
		<#list table.compositeIdColumns as column>
			<#t>${column.columnNameLower}=<@jspEl  'item.'+ column.columnNameLower/>
		</#list>				
</#compress>
</#macro>