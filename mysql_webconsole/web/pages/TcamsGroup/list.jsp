<%@page import="com.emag.rao.model.*" %>
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
  
    <title><%=TcamsGroup.TABLE_ALIAS%>管理</title>
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
     $(this).attr("href","<%=basePath%>pages/TcamsGroup/edit.action?items="+f_str);
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
        $(this).attr("href","<%=basePath%>pages/TcamsGroup/delete.action?items="+f_str);
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
   <span class="current">您现在的位置：<%=TcamsGroup.TABLE_ALIAS%>管理&gt;<a target="mainFrame" href="pages/TcamsGroup/list.action"><%=TcamsGroup.TABLE_ALIAS%>管理</a></span>
  </h3>
   
 <form id="search" action="pages/TcamsGroup/list.action" method="post"/>
  <ul class="box_search">
	      				<li class="search">
						<span><%=TcamsGroup.ALIAS_GROUP_NAME%></span>		
						
							<input value="${query.groupName}" id="groupName" name="groupName" maxlength="255"  class=""/>
						
	      				</li>
	      				<li class="search">
						<span><%=TcamsGroup.ALIAS_GROUP_DESC%></span>		
						
							<input value="${query.groupDesc}" id="groupDesc" name="groupDesc" maxlength="255"  class=""/>
						
	      				</li>
	      				<li class="search">
						<span><%=TcamsGroup.ALIAS_PARENT_GROUP_ID%></span>		
						
							<input value="${query.parentGroupId}" id="parentGroupId" name="parentGroupId" maxlength="22"  class="validate-integer "/>
						
	      				</li>
	      				<li class="search">
						<span><%=TcamsGroup.ALIAS_LEVEL_ID%></span>		
						
							<input value="${query.levelId}" id="levelId" name="levelId" maxlength="22"  class="validate-integer "/>
						
	      				</li>
	      				<li class="search">
						<span><%=TcamsGroup.ALIAS_GROUP_TYPE%></span>		
						
							<input value="${query.groupType}" id="groupType" name="groupType" maxlength="22"  class="validate-integer "/>
						
	      				</li>
	      				<li class="search">
						<span><%=TcamsGroup.ALIAS_SYSTEM_ID%></span>		
						
							<input value="${query.systemId}" id="systemId" name="systemId" maxlength="22"  class="validate-integer "/>
						
	      				</li>
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
	  <th>id</th>
	  <th sortColumn="GROUP_NAME" ><%=TcamsGroup.ALIAS_GROUP_NAME%></th>
	  <th sortColumn="GROUP_DESC" ><%=TcamsGroup.ALIAS_GROUP_DESC%></th>
	  <th sortColumn="PARENT_GROUP_ID" ><%=TcamsGroup.ALIAS_PARENT_GROUP_ID%></th>
	  <th sortColumn="LEVEL_ID" ><%=TcamsGroup.ALIAS_LEVEL_ID%></th>
	  <th sortColumn="GROUP_TYPE" ><%=TcamsGroup.ALIAS_GROUP_TYPE%></th>
	  <th sortColumn="SYSTEM_ID" ><%=TcamsGroup.ALIAS_SYSTEM_ID%></th>

    </tr>
   
     <s:iterator value="#request.page.result" id="item">
     <tr>
      <td><input name="item" id="groupId=${item.groupId}&" type="checkbox" value="groupId=${item.groupId}&" /></td>

				<td>
				<a href="<%=basePath%>pages/TcamsGroup/show.action?groupId=${item.groupId}">${item.groupId}</a>
				</td>
				<td>${item.groupName}&nbsp;</td>
				<td>${item.groupDesc}&nbsp;</td>
				<td>${item.parentGroupId}&nbsp;</td>
				<td>${item.levelId}&nbsp;</td>
				<td>${item.groupType}&nbsp;</td>
				<td>${item.systemId}&nbsp;</td>

    </tr>
    </s:iterator>
  </table>

  <p class="pagination"><!-- pagination start -->
     <emag:paginate_new total="${totalRows}" action="pages/TcamsGroup/list.action" pageSize="${query.pageSize}" pageNumber="${query.pageNumber}" >
							<emag:paginate_param name="groupName" value="${query.groupName}"/>
							<emag:paginate_param name="groupDesc" value="${query.groupDesc}"/>
							<emag:paginate_param name="parentGroupId" value="${query.parentGroupId}"/>
							<emag:paginate_param name="levelId" value="${query.levelId}"/>
							<emag:paginate_param name="groupType" value="${query.groupType}"/>
							<emag:paginate_param name="systemId" value="${query.systemId}"/>
     </emag:paginate_new>
  </p><!-- pagination end -->
  
  <p class="box_tool"><!-- box_tool start -->
    <a href="pages/TcamsGroup/create.action" target="_self" class="add" title="新建"><span>新建</span></a>
    <a href="#" id="update" target="_self" class="edite" title="修改"><span>修改</span></a>
    <a href="#" id="delete" target="_self" class="delete" title="删除"><span>删除</span></a>
  </p><!-- box_tool end -->
</div><!-- content end -->
</body>
  </body>
</html>
