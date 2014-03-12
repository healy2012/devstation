<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>数据表展示配置</title>
<base href="<%=basePath%>">
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
    
    <style type="text/css">
		.input-minimini {
		  width: 30px;
		}
		.input-moremini {
		  width: 50px;
		}
    </style>

</head>

<body>    

<div class="container">

<ul class="breadcrumb">
  <li><i class="icon-home"></i><a href="datares/allTableConfig.action">数据表资源配置总览</a> <span class="divider">/</span></li>
  <li class="active">数据表展示配置</li>
</ul>

<s2:if test="successMsg!=null">
  <p class="text-success"><i class="icon-info-sign"></i>&nbsp;${successMsg}</p>
<br>
</s2:if>

<form class="form-horizontal" method="post" action="datares/updateTableDispConfig.action">

	<input name="tableDisp.tab_disp_id" id="tab_disp_id" type="hidden" value="${tableDisp.tab_disp_id}" />
    <input name="tableDisp.tab_id" id="tab_id" type="hidden" value="${tableDisp.tab_id}" />
	
	<table class="table table-condensed ">
		<tbody>
		<tr>
			<td>表名称：</td>
			<td colspan="3"><input name="table.tab_name" id="tab_name" type="text"
				value="${table.tab_name}" class="span4" maxlength="30"
				readonly /></td>
			
		</tr>
		<tr>
			<td>物理表名：</td>
			<td colspan="3"><input name="table.tab_sqlname" id="tab_sqlname"
				type="text" value="${table.tab_sqlname}" class="span4" maxlength="30"
				readonly /></td>
			
		</tr>
		<tr>
			<td>列表展示每页数量：</td>
			<td><input name="tableDisp.page_count" id="page_count"
				type="text" value="${tableDisp.page_count}" class="span4" maxlength="30" /></td>
			<td>是否支持条件查询：</td>
			<td><s2:select name="tableDisp.support_query" value="%{tableDisp.support_query}"  list="#{'01':'是','02':'否'}" cssClass="span4"  /></td>
			
		</tr>
		<tr>
			<td>是否支持新建操作：</td>
			<td><s2:select name="tableDisp.support_new" value="%{tableDisp.support_new}"  list="#{'01':'是','02':'否'}" cssClass="span4"  /></td>
			<td>是否支持删除操作：</td>
			<td><s2:select name="tableDisp.support_del" value="%{tableDisp.support_del}"  list="#{'01':'是','02':'否'}" cssClass="span4"  /></td>
			
		</tr>
		<tr>
			<td>是否支持更新操作：</td>
			<td><s2:select name="tableDisp.support_update" value="%{tableDisp.support_update}"  list="#{'01':'是','02':'否'}" cssClass="span4"  /></td>
			<td>是否支持字段排序：</td>
			<td><s2:select name="tableDisp.support_sort" value="%{tableDisp.support_sort}"  list="#{'01':'是','02':'否'}" cssClass="span4"  /></td>
			
		</tr>
		<tr>
			<td>是否支持数据导出：</td>
			<td><s2:select name="tableDisp.support_export" value="%{tableDisp.support_export}"  list="#{'01':'是','02':'否'}" cssClass="span4"  /></td>
			<td>表单布局类型：</td>
			<td><s2:select name="tableDisp.layout_type" value="%{tableDisp.layout_type}"  list="#{'01':'单列','02':'双列'}" cssClass="span4"  /></td>
			
		</tr>
		</tbody>
	</table>


<table class="table table-striped table-bordered table-condensed">
  <thead>
    <tr>
      <td>物理表字段名称</td>
      <td>是否显示在列表</td>
      <td>显示的列名称</td>
      <td>是否支持列排序</td>
      <td>是否支持查询</td>
      <td>列表中显示顺序</td>
      <td>表单是否展示</td>
      <td>表单中显示名称</td>
      <td>是否支持编辑</td>
      <td>表单中展示方式</td>
      <td>关联子表字段展示</td>
      <td>表单中显示顺序</td>
    </tr>
  </thead>
		<tbody>
		
		<s2:iterator value="colsDisp" status="stat">
     <tr>
      <td><s2:textfield name="colsDisp[%{#stat.index}].full_col_sqlname" value="%{colsDisp[#stat.index].full_col_sqlname }" readonly="true" cssClass="input-small" /></td>
      <td><s2:select name="colsDisp[%{#stat.index}].is_in_list" value="%{colsDisp[#stat.index].is_in_list }"  list="#{'01':'是','02':'否'}" cssClass="input-moremini" /></td>
      <td><s2:textfield name="colsDisp[%{#stat.index}].list_disp_name" value="%{colsDisp[#stat.index].list_disp_name }" cssClass="input-small"/></td>
      <td><s2:select name="colsDisp[%{#stat.index}].support_sort" value="%{colsDisp[#stat.index].support_sort }"  list="#{'01':'是','02':'否'}" cssClass="input-moremini"/></td>
      <td><s2:select name="colsDisp[%{#stat.index}].support_query" value="%{colsDisp[#stat.index].support_query }"  list="#{'01':'是','02':'否'}" cssClass="input-moremini"/></td>
      <td><s2:textfield name="colsDisp[%{#stat.index}].list_disp_order" value="%{colsDisp[#stat.index].list_disp_order }" cssClass="input-minimini"/></td>
      <td><s2:select name="colsDisp[%{#stat.index}].is_in_form" value="%{colsDisp[#stat.index].is_in_form }"  list="#{'01':'是','02':'否'}" cssClass="input-moremini"/></td>
      <td><s2:textfield name="colsDisp[%{#stat.index}].form_disp_name" value="%{colsDisp[#stat.index].form_disp_name }" cssClass="input-small"/></td>
      <td><s2:select name="colsDisp[%{#stat.index}].support_update" value="%{colsDisp[#stat.index].support_update }"  list="#{'01':'是','02':'否'}" cssClass="input-moremini"/></td>
      <td><s2:select name="colsDisp[%{#stat.index}].form_disp_type" value="%{colsDisp[#stat.index].form_disp_type }"  list="#{'01':'文本框','02':'文本区域','03':'时间选择','04':'日期选择','05':'数据字典下拉框','06':'数据字典多选','07':'关联子表下拉框','08':'关联子表多选','09':'关联子表选择列表单选','10':'关联子表选择列表多选'}" cssClass="input-small"/></td>
      <td><s2:select name="colsDisp[%{#stat.index}].sub_tab_disp_cols"
			value="colsDisp[#stat.index].sub_tab_disp_cols.split(', ')" multiple="true"
			list="subTabColListMap[colsDisp[#stat.index].full_col_sqlname]" listKey="col_sqlname" listValue="col_sqlname" cssClass="input-small"/>
	  </td>
      <td><s2:textfield name="colsDisp[%{#stat.index}].form_disp_order" value="%{colsDisp[#stat.index].form_disp_order }" cssClass="input-minimini"/></td>           
    </tr>
    </s2:iterator>
			
			
		</tbody>
	</table>

  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn">提交</button>
      <button type="reset" class="btn">重置</button>
      <a href="datares/allTableConfig.action" class="btn">返回</a>
    </div>
  </div>
  
</form>

</div>
</body>

</html>