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
  
    <title>导航管理</title>
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
     $("input[name='navCheckBox']").each(function(){
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
     $(this).attr("href","<%=basePath%>system/updateNavigator.action?navIds="+f_str);
    }
    
    }); 
    
    $("#delete").click(
    function(){
    var i = 0;
    var f_str = '';
    $("input[name='navCheckBox']").each(function(){
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
        $(this).attr("href","<%=basePath%>system/delNavgators.action?navIds="+f_str);

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
    $("input[name='navCheckBox']").each(function() { 
    $(this).attr("checked", true); 
    }); 
    i=$("input[name='navCheckBox']").length;
    } else { // 取消全选 
     $("input[name='navCheckBox']").each(function() { 
     $(this).attr("checked", false); 
    });
    i=0;
   } 
   }); 

   $("input[name='navCheckBox']").click(function() {   
      if($(this).attr("checked") == null){
          $("#checkAll").attr("checked",false);
          i=i-1;
      }
      
      if($(this).attr("checked") == true){
          i=i+1;
      }
      
      if(i==$("input[name='navCheckBox']").length)
      {
       $("#checkAll").attr("checked",true);
      }
   });
    
}); 

   </script>
  </head>
   <body>
    <div class="content"><!-- content start -->
   <h3 class="breadcrumb">
   <span class="current">您现在的位置：系统管理&gt;<a target="systemMainFrame" href="<%=basePath%>system/queryNavigatorList.action">导航管理</a></span>
  </h3>
   <table class="table_list">
    <tr>
      <th><input name="checkAll" type="checkbox" value="全选/取消全选" /></th>
      <th>导航名称</th>
      <th>导航链接</th>
      <th>导航序号</th>
      <th>备注</th>
      <th>导航状态</th>
    </tr>
   
     <s2:iterator value="list" id="nav">
     <tr>
      <td><input name="navCheckBox" id="${nav.navId}" type="checkbox" value="${nav.navId}" /></td>
      <td><a href="<s2:url action="manageSystemMenu"/>?navId=${nav.navId}" title="点击设置功能节点">${nav.navName}&nbsp;</a></td>
      <td>${nav.navUrl}&nbsp;</td>
      <td>${nav.navSeq}&nbsp;</td>
      <td>${nav.navNote}&nbsp;</td>
      
      <s2:if test="%{navStatus == 1}">
      <td>启用</td>
      </s2:if>
      <s2:if test="%{navStatus == 0}">
       <td>停用</td>
      </s2:if>
    </tr>
    </s2:iterator>
  </table>

  <p class="box_tool"><!-- box_tool start -->
    <a href="system/addNavigator.action" target="systemMainFrame" class="add" title="新建"><span>新建</span></a>
    <a href="#" id="update" target="systemMainFrame" class="edite" title="修改"><span>修改</span></a>
    <a href="#" id="delete" target="systemMainFrame" class="delete" title="删除"><span>删除</span></a>
  </p><!-- box_tool end -->
  
</div><!-- content end -->
</body>
  </body>
</html>
