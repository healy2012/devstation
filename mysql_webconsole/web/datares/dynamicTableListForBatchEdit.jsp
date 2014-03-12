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
  
    <title>表数据批量修改</title>
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
    
   $("#addNewRow").click(
	function(){
		var tmp = $("tr[id^='dataRow_']");
		//alert(tmp);
		var id = tmp.last().attr("id");
		id = id.substr("dataRow_".length,id.length);
		//alert(id);
		$("#dataTable").append(trTemplet.replace(/IDTOBEREPLACE/g,parseInt(id,10)+1));
	}	   
   );
   
    $("#deleteRow").click(
    function(){
    var i = 0;
    var deleteArray = new Array();
    $("input[name='primaryKey']").each(function(){
       if($(this).prop("checked") == true)
       {
        i = i + 1;
        deleteArray.push($(this).parent().parent().attr("id"));
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
    	  for(var j=0;j<deleteArray.length;j++){
    		  var id = deleteArray[j].substr("dataRow_".length,deleteArray[j].length);
    		  $("#tableData_"+id+"__userOperation__").val("deletedRow");
    		  $("#"+deleteArray[j]).attr({style:"display:none"});
    	  }
    	      	
		  return false;
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
  <li><a href="datares/dynamicTableList.action?tab_id=${tab_id}">资源模型数据管理</a> <span class="divider">/</span></li>
  <li class="active">批量编辑</li>
	</ul>
	
<s2:if test="successMsg!=null">
  <p class="text-success"><i class="icon-info-sign"></i>&nbsp;${successMsg}</p>
<br>
</s2:if>
  
  <dynamicTable:tableListForBatchEdit />
  
</div><!-- content end -->
</body>
  </body>
</html>
