<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-thumbnails.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-buttons.css" rel="stylesheet">
    
    <script src="bootstrap/js/jquery-1.9.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/bootstrap-buttons.min.js"></script>
    
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
  <li><i class="icon-home"></i><a href="#">首页</a> <span class="divider">/</span></li>
  <li><a href="#">Library</a> <span class="divider">/</span></li>
  <li class="active">Data</li>
</ul>

<form class="form-horizontal">

	<input name="tableDisp.tab_disp_id" id="tab_disp_id" type="hidden"
			value="19" >
	<input name="tableDisp.tab_id" id="tab_id" type="hidden" value="46" >
	
	<table class="table table-condensed">
		<tbody>
		<tr>
			<td>表名称：</td>
			<td colspan="3"><input name="table.tab_name" id="tab_name" type="text"
				value="菜单表20130116" class="span4" maxlength="30"
				readonly /></td>
			
		</tr>
		<tr>
			<td>物理表名：</td>
			<td colspan="3"><input name="table.tab_sqlname" id="tab_sqlname"
				type="text" value="sys_menu" class="span4" maxlength="30"
				readonly /></td>
			
		</tr>
		<tr>
			<td>列表展示每页数量：</td>
			<td><input name="tableDisp.page_count" id="page_count"
				type="text" value="10" class="span4" maxlength="30" /></td>
			<td>是否支持条件查询：</td>
			<td><select name="tableDisp.support_query"
				id="tableDisp_support_query" class="span4">
					<option value="01" selected="selected">是</option>
					<option value="02">否</option>


			</select></td>
			
		</tr>
		<tr>
			<td>是否支持新建操作：</td>
			<td><select name="tableDisp.support_new"
				id="tableDisp_support_new" class="span4">
					<option value="01" selected="selected">是</option>
					<option value="02">否</option>


			</select></td>
			<td>是否支持删除操作：</td>
			<td><select name="tableDisp.support_del"
				id="tableDisp_support_del" class="span4">
					<option value="01" selected="selected">是</option>
					<option value="02">否</option>


			</select></td>
			
		</tr>
		<tr>
			<td>是否支持更新操作：</td>
			<td><select name="tableDisp.support_update"
				id="tableDisp_support_update" class="span4">
					<option value="01" selected="selected">是</option>
					<option value="02">否</option>


			</select></td>
			<td>是否支持字段排序：</td>
			<td><select name="tableDisp.support_sort"
				id="tableDisp_support_sort" class="span4">
					<option value="01" selected="selected">是</option>
					<option value="02">否</option>


			</select></td>
			
		</tr>
		<tr>
			<td>是否支持数据导出：</td>
			<td><select name="tableDisp.support_export"
				id="tableDisp_support_export" class="span4">
					<option value="01" selected="selected">是</option>
					<option value="02">否</option>


			</select></td>
			<td>表单布局类型：</td>
			<td><select name="tableDisp.layout_type"
				id="tableDisp_layout_type" class="span4">
					<option value="01" selected="selected">单列</option>
					<option value="02">双列</option>


			</select></td>
			
		</tr>
		</tbody>
	</table>


<table class="table table-condensed">
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
			<tr>

				<td><input type="text" class="input-small"
					name="colsDisp[0].full_col_sqlname" value="MENU_CODE"
					readonly="readonly" id="colsDisp_0__full_col_sqlname" /></td>
				<td><select class="input-moremini" name="colsDisp[0].is_in_list"
					id="colsDisp_0__is_in_list">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><input type="text" class="input-small"
					name="colsDisp[0].list_disp_name" value="&#33756;&#21333;CODE"
					id="colsDisp_0__list_disp_name" /></td>
				<td><select class="input-moremini"
					name="colsDisp[0].support_sort" id="colsDisp_0__support_sort">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><select class="input-moremini"
					name="colsDisp[0].support_query" id="colsDisp_0__support_query">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><input type="text" class="input-minimini" width="30px"
					name="colsDisp[0].list_disp_order" value="0"
					id="colsDisp_0__list_disp_order" /></td>
				<td><select class="input-moremini" name="colsDisp[0].is_in_form"
					id="colsDisp_0__is_in_form">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><input type="text" class="input-small"
					name="colsDisp[0].form_disp_name" value="&#33756;&#21333;CODE"
					id="colsDisp_0__form_disp_name" /></td>
				<td><select class="input-moremini"
					name="colsDisp[0].support_update" id="colsDisp_0__support_update">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><select class="input-small"
					name="colsDisp[0].form_disp_type" id="colsDisp_0__form_disp_type">
						<option value="01" selected="selected">文本框</option>
						<option value="02">文本区域</option>
						<option value="03">时间选择</option>
						<option value="04">日期选择</option>
						<option value="05">数据字典下拉框</option>
						<option value="06">数据字典多选</option>
						<option value="07">关联子表下拉框</option>
						<option value="08">关联子表多选</option>
						<option value="09">关联子表选择列表单选</option>
						<option value="10">关联子表选择列表多选</option>


				</select></td>
				<td><select class="input-small"
					name="colsDisp[0].sub_tab_disp_cols"
					id="colsDisp_0__sub_tab_disp_cols" multiple="multiple">
						<option value="NAV_ID" selected="selected">NAV_ID</option>
						<option value="NAV_NAME" selected="selected">NAV_NAME</option>
						<option value="NAV_NOTE">NAV_NOTE</option>
						<option value="NAV_SEQ">NAV_SEQ</option>
						<option value="NAV_STATUS">NAV_STATUS</option>
						<option value="NAV_URL">NAV_URL</option>


				</select> <input type="hidden"
					id="__multiselect_colsDisp_0__sub_tab_disp_cols"
					name="__multiselect_colsDisp[0].sub_tab_disp_cols" value="" /></td>
				<td><input type="text" class="input-minimini"
					name="colsDisp[0].form_disp_order" value="0"
					id="colsDisp_0__form_disp_order" /></td>

			</tr>

			<tr>

				<td><input type="text" class="input-small"
					name="colsDisp[0].full_col_sqlname" value="MENU_CODE"
					readonly="readonly" id="colsDisp_0__full_col_sqlname" /></td>
				<td><select class="input-moremini" name="colsDisp[0].is_in_list"
					id="colsDisp_0__is_in_list">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><input type="text" class="input-small"
					name="colsDisp[0].list_disp_name" value="&#33756;&#21333;CODE"
					id="colsDisp_0__list_disp_name" /></td>
				<td><select class="input-moremini"
					name="colsDisp[0].support_sort" id="colsDisp_0__support_sort">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><select class="input-moremini"
					name="colsDisp[0].support_query" id="colsDisp_0__support_query">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><input type="text" class="input-minimini" width="30px"
					name="colsDisp[0].list_disp_order" value="0"
					id="colsDisp_0__list_disp_order" /></td>
				<td><select class="input-moremini" name="colsDisp[0].is_in_form"
					id="colsDisp_0__is_in_form">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><input type="text" class="input-small"
					name="colsDisp[0].form_disp_name" value="&#33756;&#21333;CODE"
					id="colsDisp_0__form_disp_name" /></td>
				<td><select class="input-moremini"
					name="colsDisp[0].support_update" id="colsDisp_0__support_update">
						<option value="01" selected="selected">是</option>
						<option value="02">否</option>


				</select></td>
				<td><select class="input-small"
					name="colsDisp[0].form_disp_type" id="colsDisp_0__form_disp_type">
						<option value="01" selected="selected">文本框</option>
						<option value="02">文本区域</option>
						<option value="03">时间选择</option>
						<option value="04">日期选择</option>
						<option value="05">数据字典下拉框</option>
						<option value="06">数据字典多选</option>
						<option value="07">关联子表下拉框</option>
						<option value="08">关联子表多选</option>
						<option value="09">关联子表选择列表单选</option>
						<option value="10">关联子表选择列表多选</option>


				</select></td>
				<td><select class="input-small"
					name="colsDisp[0].sub_tab_disp_cols"
					id="colsDisp_0__sub_tab_disp_cols" multiple="multiple">
						<option value="NAV_ID" selected="selected">NAV_ID</option>
						<option value="NAV_NAME" selected="selected">NAV_NAME</option>
						<option value="NAV_NOTE">NAV_NOTE</option>
						<option value="NAV_SEQ">NAV_SEQ</option>
						<option value="NAV_STATUS">NAV_STATUS</option>
						<option value="NAV_URL">NAV_URL</option>


				</select> <input type="hidden"
					id="__multiselect_colsDisp_0__sub_tab_disp_cols"
					name="__multiselect_colsDisp[0].sub_tab_disp_cols" value="" /></td>
				<td><input type="text" class="input-minimini"
					name="colsDisp[0].form_disp_order" value="0"
					id="colsDisp_0__form_disp_order" /></td>

			</tr>
			
			
		</tbody>
	</table>

  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn">提交</button>
      <button type="reset" class="btn">重置</button>
      <button type="button" class="btn">返回</button>
    </div>
  </div>
  
</form>



</div>
  </body>
</html>