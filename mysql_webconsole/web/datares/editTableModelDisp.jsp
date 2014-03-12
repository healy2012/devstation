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
  
    <title>数据资源模型管理</title>
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
   <span class="current">您现在的位置：<a target="systemMainFrame" href="<%=basePath%>datares/tablePageList.action">数据资源模型管理</a>&gt;编辑资源模型</span>
  </h3>
   
 <!--<form id="search" action="demo/queryPortalUser.action"> 
  <ul class="box_search">
    <li class="search"><span>用户账号：</span><input name="userInfo.userName" id="username" type="text" value="${userInfo.userName}" maxlength="20"/></li>
      <li class="btn">
      <button type="submit" class="wsj_but">搜 索</button>
      <button type="reset"  class="wsj_but">重 置</button>
    </li>
  </ul>
  </form>
  
  -->
  <form method="post" action="datares/saveTabModelDisp.action">
  
  <table class="table_form">
    <input name="tableDisp.tab_disp_id" id="tab_disp_id" type="hidden" value="${tableDisp.tab_disp_id}" />
    <input name="tableDisp.tab_id" id="tab_id" type="hidden" value="${tableDisp.tab_id}" />
    <tr>
      <th>表名称：</th>
      <td><input name="table.tab_name" id="tab_name" type="text" value="${table.tab_name}" class="required" maxlength="30" readonly="true"/></td>
      <td class="place"><p class="annotation">不超过30个字符</p></td>
    </tr>
    <tr>
      <th>物理表名：</th>
      <td><input name="table.tab_sqlname" id="tab_sqlname" type="text" value="${table.tab_sqlname}" class="required" maxlength="30" readonly="true"/></td>
      <td class="place"><p class="annotation">不超过30个字符</p></td>
    </tr>
    <tr>
      <th>列表展示每页数量：</th>
      <td><input name="tableDisp.page_count" id="page_count" type="text" value="${tableDisp.page_count}" class="required" maxlength="30"/></td>
      <td class="place"><p class="annotation">必须填写数字</p></td>
    </tr>
    <tr>
      <th>是否支持条件查询：</th>
      <td><s2:select name="tableDisp.support_query" value="%{tableDisp.support_query}"  list="#{'01':'是','02':'否'}" cssClass="required"  />
      </td>
      <td class="place"><p class="annotation"></p></td>
    </tr>
    <tr>
      <th>是否支持新建操作：</th>
      <td><s2:select name="tableDisp.support_new" value="%{tableDisp.support_new}"  list="#{'01':'是','02':'否'}" cssClass="required"  />
      </td>
      <td class="place"><p class="annotation"></p></td>
    </tr>
    <tr>
      <th>是否支持删除操作：</th>
      <td><s2:select name="tableDisp.support_del" value="%{tableDisp.support_del}"  list="#{'01':'是','02':'否'}" cssClass="required"  />
      </td>
      <td class="place"><p class="annotation"></p></td>
    </tr>
    <tr>
      <th>是否支持更新操作：</th>
      <td><s2:select name="tableDisp.support_update" value="%{tableDisp.support_update}"  list="#{'01':'是','02':'否'}" cssClass="required"  />
      </td>
      <td class="place"><p class="annotation"></p></td>
    </tr>
    <tr>
      <th>是否支持字段排序：</th>
      <td><s2:select name="tableDisp.support_sort" value="%{tableDisp.support_sort}"  list="#{'01':'是','02':'否'}" cssClass="required"  />
      </td>
      <td class="place"><p class="annotation"></p></td>
    </tr>
    <tr>
      <th>是否支持数据导出：</th>
      <td><s2:select name="tableDisp.support_export" value="%{tableDisp.support_export}"  list="#{'01':'是','02':'否'}" cssClass="required"  />
      </td>
      <td class="place"><p class="annotation"></p></td>
    </tr>
    <tr>
      <th>表单布局类型：</th>
      <td><s2:select name="tableDisp.layout_type" value="%{tableDisp.layout_type}"  list="#{'01':'单列','02':'双列'}" cssClass="required"  />
      </td>
      <td class="place"><p class="annotation"></p></td>
    </tr>
  </table>
  
  <table class="table_list">
    <tr>
      <%--<th><input name="checkAll" type="checkbox" value="全选/取消全选" /></th>--%>
      <th>物理表字段名称</th>
      <th>是否显示在列表</th>
      <th>显示的列名称</th>
      <th>是否支持列排序</th>
      <th>是否支持查询</th>
      <th>列表中显示顺序</th>
      <th>表单是否展示</th>
      <th>表单中显示名称</th>
      <th>是否支持编辑</th>
      <th>表单中展示方式</th>
      <th>关联子表字段展示</th>
      <th>表单中显示顺序</th>
    </tr>
   
     <s2:iterator value="colsDisp" status="stat">
     <tr>
      <%-- <td><input name="userCheckBox" id="${stat.index}" type="checkbox" value="${stat.index}" /></td> --%>   
      <td><s2:textfield name="colsDisp[%{#stat.index}].full_col_sqlname" value="%{colsDisp[#stat.index].full_col_sqlname }" readonly="true" />&nbsp;</td>
      <td><s2:select name="colsDisp[%{#stat.index}].is_in_list" value="%{colsDisp[#stat.index].is_in_list }"  list="#{'01':'是','02':'否'}" />&nbsp;</td>
      <td><s2:textfield name="colsDisp[%{#stat.index}].list_disp_name" value="%{colsDisp[#stat.index].list_disp_name }" />&nbsp;</td>
      <td><s2:select name="colsDisp[%{#stat.index}].support_sort" value="%{colsDisp[#stat.index].support_sort }"  list="#{'01':'是','02':'否'}" />&nbsp;</td>
      <td><s2:select name="colsDisp[%{#stat.index}].support_query" value="%{colsDisp[#stat.index].support_query }"  list="#{'01':'是','02':'否'}" />&nbsp;</td>
      <td><s2:textfield name="colsDisp[%{#stat.index}].list_disp_order" value="%{colsDisp[#stat.index].list_disp_order }" />&nbsp;</td>
      <td><s2:select name="colsDisp[%{#stat.index}].is_in_form" value="%{colsDisp[#stat.index].is_in_form }"  list="#{'01':'是','02':'否'}" />&nbsp;</td>
      <td><s2:textfield name="colsDisp[%{#stat.index}].form_disp_name" value="%{colsDisp[#stat.index].form_disp_name }" />&nbsp;</td>
      <td><s2:select name="colsDisp[%{#stat.index}].support_update" value="%{colsDisp[#stat.index].support_update }"  list="#{'01':'是','02':'否'}" />&nbsp;</td>
      <td><s2:select name="colsDisp[%{#stat.index}].form_disp_type" value="%{colsDisp[#stat.index].form_disp_type }"  list="#{'01':'文本框','02':'文本区域','03':'时间选择','04':'日期选择','05':'数据字典下拉框','06':'数据字典多选','07':'关联子表下拉框','08':'关联子表多选','09':'关联子表选择列表单选','10':'关联子表选择列表多选'}" />&nbsp;</td>
      <td><s2:select name="colsDisp[%{#stat.index}].sub_tab_disp_cols"
			value="colsDisp[#stat.index].sub_tab_disp_cols.split(', ')" multiple="true"
			list="subTabColListMap[colsDisp[#stat.index].full_col_sqlname]" listKey="col_sqlname" listValue="col_sqlname"/>&nbsp;
	  </td>
      <td><s2:textfield name="colsDisp[%{#stat.index}].form_disp_order" value="%{colsDisp[#stat.index].form_disp_order }" />&nbsp;</td>
            
    </tr>
    </s2:iterator>
  </table>
  
  <p class="box_btn">
    <button type="submit">提交</button>
    <button type="reset">重写</button>
    <button type="button" onclick="history.go(-1)">返回</button>
  </p>
  </form>
  
</div><!-- content end -->
</body>
  </body>
</html>
