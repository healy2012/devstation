<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<%@ taglib prefix="emag" uri="/tags/emag"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
  
    <title>用户管理</title>
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
    <script type="text/javascript">
    $(document).ready(function(){
    
    $(".table_list").tableCss(); //此处为表格动态样式
    
    $("#update").click(
     function(){
      var i = 0;
      var f_str = '';
     $("input[name='userCheckBox']").each(function(){
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
     $(this).attr("href","<%=basePath%>demo/updateUser.action?userIds="+f_str);
    }
    
    }); 
    
    $("#delete").click(
    function(){
    var i = 0;
    var f_str = '';
    $("input[name='userCheckBox']").each(function(){
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
        $(this).attr("href","<%=basePath%>demo/delUsers.action?userIds="+f_str);
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
    $("input[name='userCheckBox']").each(function() { 
    $(this).attr("checked", true); 
    }); 
    i=$("input[name='userCheckBox']").length;
    } else { // 取消全选 
     $("input[name='userCheckBox']").each(function() { 
     $(this).attr("checked", false); 
    });
    i=0;
   } 
   }); 

   $("input[name='userCheckBox']").click(function() {   
      if($(this).attr("checked") == null){
          $("#checkAll").attr("checked",false);
          i=i-1;
      }
      
      if($(this).attr("checked") == true){
          i=i+1;
      }
      
      if(i==$("input[name='userCheckBox']").length)
      {
       $("#checkAll").attr("checked",true);
      }
   });
    
}); 
    
    
 //   function obtainIds()
 //  { 
 //    var f_str = '';
 //    $("input[@name='userCheckBox']").each(function(){
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
   <span class="current">您现在的位置：用户管理DEMO&gt;<a target="mainFrame" href="<%=basePath%>demo/queryPortalUser.action">用户管理</a></span>
  </h3>
   
 <form id="search" action="demo/queryPortalUser.action"> 
  <ul class="box_search">
    <li class="search"><span>用户账号：</span><input name="userInfo.userName" id="username" type="text" value="${userInfo.userName}" maxlength="20"/></li>
      <li class="btn">
      <button type="submit" class="wsj_but">搜 索</button>
      <button type="reset"  class="wsj_but">重 置</button>
    </li>
  </ul>
  </form>
  
  <table class="table_list">
    <tr>
      <th><input name="checkAll" type="checkbox" value="全选/取消全选" /></th>
      <th>用户名称</th>
      <th>真实姓名</th>
      <th>E-mail</th>
      <th>移动电话</th>
    </tr>
   
     <s2:iterator value="userInfoList" id="users">
     <tr>
      <td><input name="userCheckBox" id="${users.userId}" type="checkbox" value="${users.userId}" /></td>
      <td>${users.userName}&nbsp;</td>
      <td>${users.name}&nbsp;</td>
      <td>${users.email}&nbsp;</td>
      <td>${users.tel}&nbsp;</td>
    </tr>
    </s2:iterator>
  </table>

  <p class="pagination"><!-- pagination start -->
      <emag:paginator />
  </p><!-- pagination end -->
  
  <p class="box_tool"><!-- box_tool start -->
    <a href="demo/addUser.action" target="systemMainFrame" class="add" title="新建"><span>新建</span></a>
    <a href="#" id="update" target="systemMainFrame" class="edite" title="修改"><span>修改</span></a>
    <a href="#" id="delete" target="systemMainFrame" class="delete" title="删除"><span>删除</span></a>
  </p><!-- box_tool end -->
</div><!-- content end -->
</body>
  </body>
</html>
