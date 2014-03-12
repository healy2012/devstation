<%@ page language="java" import="java.util.*,cn.emag.datares.domain.Table" pageEncoding="utf-8"%>
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
  
    <title>资源表列表</title>
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
    
    //$(".table_list").addClass("table table-striped table-bordered table-condensed");
   // $("#search").addClass("form-search");
    
    $("#update").click(
     function(){
      var i = 0;
      var f_str = '';
     $("input[name='primaryKey']").each(function(){
       if($(this).prop("checked") == true)
       {
        i = i + 1;
        f_str += $(this).attr("value")+",";
       }
     });
    
    if(i != 1)
    {
      alert("请选择一条记录进行修改");
   
      return false;
    }
    else
    {
		$("#hiddenform")[0].tab_id.value=<%=request.getParameter("tab_id")%>;
		$("#hiddenform")[0].primaryKey.value=f_str;
		$("#hiddenform")[0].submit();
		return false;
     //$(this).attr("href","<%=basePath%>datares/dynamicTabForm.action?tab_id=<%=request.getParameter("tab_id")%>&primaryKey="+f_str);
    }
    
    }); 
    
    $("#delete").click(
    function(){
    var i = 0;
    var f_str = '';
    $("input[name='primaryKey']").each(function(){
       if($(this).prop("checked") == true)
       {
        i = i + 1;
        f_str += $(this).attr("value")+",";
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
      
      	$("#hiddenform")[0].tab_id.value=<%=request.getParameter("tab_id")%>;
		$("#hiddenform")[0].primaryKey.value=f_str;
		$("#hiddenform")[0].operation.value="delete";
		$("#hiddenform")[0].submit();
		return false;
        //$(this).attr("href","<%=basePath%>demo/delUsers.action?userIds="+f_str);
      }
      else
      {
        return false;
      }
    }
    
    }
   ); 
   
   $("input[name='checkAll']").click(function() { 
	    if ($(this).prop("checked") == true) { // 全选 
	    	$("input[name='primaryKey']").prop({
	    		checked: true
	    	}); 
	    } else { // 取消全选 
	     $("input[name='primaryKey']").prop({
	 		checked: false
	 	}); 
	   } 
   }); 

    
}); 

   </script>
  </head>
   <body>
    <div class="container"><!-- content start -->
    
    <ul class="breadcrumb">
  <li><i class="icon-home"></i><a href="datares/allTableConfig.action">数据表资源配置总览</a> <span class="divider">/</span></li>
  <li class="active">资源模型数据管理</li>
	</ul>
  
  <dynamicTable:tableList />
  
  <form id="hiddenform" method="post" action="datares/dynamicTabForm.action">
	  <input name="tab_id" id="tab_id" value="" type="hidden" /> 
	  <input name="primaryKey" id="primaryKey" value="" type="hidden" />
	  <input name="operation" id="operation" value="" type="hidden" />
  </form>
</div><!-- content end -->
</body>
  </body>
</html>
