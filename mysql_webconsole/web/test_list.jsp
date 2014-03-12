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
  </head>
  <body>    

<div class="container">

<ul class="breadcrumb">
  <li><i class="icon-home"></i><a href="#">首页</a> <span class="divider">/</span></li>
  <li><a href="#">Library</a> <span class="divider">/</span></li>
  <li class="active">Data</li>
</ul>

<form class="form-horizontal">
  <div class="control-group">
    <label class="control-label">表名称：</label>
    <div class="controls">
      <input type="text" id="inputEmail" class="span4"  placeholder="表名称">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label">物理表名：</label>
    <div class="controls">
      <input type="text" id="inputPassword" class="span4"  placeholder="物理表名">
    </div>
  </div>
  
  <table class="table table-striped">
  <thead>
    <tr>
      <td>物理表字段名称</td>
      <td>物理表字段类型</td>
      <td>物理表字段长度</td>
      <td>字段描述</td>
      <td>能否为空</td>
      <td>物是否主键</td>
      <td>关联数据字典</td>
      <td>关联子表对象ID</td>
      <td>关联子表物理表字段名称</td>
      <td>字段验证类型</td>
    </tr>
  </thead>
  <tbody>
	<tr>
		<td><input type="text" class="input-small" name="cols[0].col_sqlname"
			value="email" readonly="readonly" id="cols_0__col_sqlname" />
			</td>
		<td><input type="text" class="input-small" name="cols[0].col_sqltype"
			value="varchar" readonly="readonly" id="cols_0__col_sqltype" />
			</td>
		<td><input type="text" class="input-small" name="cols[0].col_size" value="50"
			readonly="readonly" id="cols_0__col_size" /> </td>
		<td><input type="text" class="input-medium" name="cols[0].col_desc"
			value="&#30005;&#23376;&#37038;&#20214;" id="cols_0__col_desc" />
			</td>
		<td><select class="input-mini" name="cols[0].isnullable" id="cols_0__isnullable" disabled>
				<option value="01" selected="selected">是</option>
				<option value="02">否</option>


		</select> </td>
		<td><select class="input-mini" name="cols[0].ispk" id="cols_0__ispk" disabled>
				<option value="01">是</option>
				<option value="02" selected="selected">否</option>


		</select> </td>
		<td><select class="input-small" name="cols[0].datadict" id="cols_0__datadict">
				<option value="0" selected="selected"></option>
				<option value="181">下拉</option>
				<option value="263">状态类型</option>
				<option value="267">菜单状态</option>


		</select> </td>
		<td><select class="input-small" name="cols[0].sub_tab_id" id="cols_0__sub_tab_id"
			onchange="getColumnList(this)">
				<option value="0" selected="selected"></option>
				<option value="24">学生表</option>
				<option value="33">系统菜单</option>
				<option value="35">系统菜单表</option>
				<option value="36">菜单表关联导航表</option>
				<option value="37">系统菜单表</option>
				<option value="38">用户表</option>
				<option value="39">sys_navigator</option>
				<option value="43">菜单表（测试）</option>
				<option value="44">菜单测试20130115</option>
				<option value="45">菜单导航表</option>
				<option value="46">菜单表20130116</option>
				<option value="47">菜单表测试</option>
				<option value="49">菜单表（测试）1212</option>
				<option value="50">菜单表（测试）1212</option>


		</select> </td>
		<td><select class="input-small" name="cols[0].sub_tab_col_sqlname"
			id="cols_0__sub_tab_col_sqlname">


		</select> </td>
		<td><input class="input-small" type="text" name="cols[0].validation_type"
			value="" id="cols_0__validation_type" /> </td>
	</tr>			
	
	<tr>
		<td><input type="text" class="input-small" name="cols[0].col_sqlname"
			value="email" readonly="readonly" id="cols_0__col_sqlname" />
			</td>
		<td><input type="text" class="input-small" name="cols[0].col_sqltype"
			value="varchar" readonly="readonly" id="cols_0__col_sqltype" />
			</td>
		<td><input type="text" class="input-small" name="cols[0].col_size" value="50"
			readonly="readonly" id="cols_0__col_size" /> </td>
		<td><input type="text" class="input-medium" name="cols[0].col_desc"
			value="&#30005;&#23376;&#37038;&#20214;" id="cols_0__col_desc" />
			</td>
		<td><select class="input-mini" name="cols[0].isnullable" id="cols_0__isnullable" disabled>
				<option value="01" selected="selected">是</option>
				<option value="02">否</option>


		</select> </td>
		<td><select class="input-mini" name="cols[0].ispk" id="cols_0__ispk" disabled>
				<option value="01">是</option>
				<option value="02" selected="selected">否</option>


		</select> </td>
		<td><select class="input-small" name="cols[0].datadict" id="cols_0__datadict">
				<option value="0" selected="selected"></option>
				<option value="181">下拉</option>
				<option value="263">状态类型</option>
				<option value="267">菜单状态</option>


		</select> </td>
		<td><select class="input-small" name="cols[0].sub_tab_id" id="cols_0__sub_tab_id"
			onchange="getColumnList(this)">
				<option value="0" selected="selected"></option>
				<option value="24">学生表</option>
				<option value="33">系统菜单</option>
				<option value="35">系统菜单表</option>
				<option value="36">菜单表关联导航表</option>
				<option value="37">系统菜单表</option>
				<option value="38">用户表</option>
				<option value="39">sys_navigator</option>
				<option value="43">菜单表（测试）</option>
				<option value="44">菜单测试20130115</option>
				<option value="45">菜单导航表</option>
				<option value="46">菜单表20130116</option>
				<option value="47">菜单表测试</option>
				<option value="49">菜单表（测试）1212</option>
				<option value="50">菜单表（测试）1212</option>


		</select> </td>
		<td><select class="input-small" name="cols[0].sub_tab_col_sqlname"
			id="cols_0__sub_tab_col_sqlname">


		</select> </td>
		<td><input class="input-small" type="text" name="cols[0].validation_type"
			value="" id="cols_0__validation_type" /> </td>
	</tr>
	
	<tr>
		<td><input type="text" class="input-small" name="cols[0].col_sqlname"
			value="email" readonly="readonly" id="cols_0__col_sqlname" />
			</td>
		<td><input type="text" class="input-small" name="cols[0].col_sqltype"
			value="varchar" readonly="readonly" id="cols_0__col_sqltype" />
			</td>
		<td><input type="text" class="input-small" name="cols[0].col_size" value="50"
			readonly="readonly" id="cols_0__col_size" /> </td>
		<td><input type="text" class="input-medium" name="cols[0].col_desc"
			value="&#30005;&#23376;&#37038;&#20214;" id="cols_0__col_desc" />
			</td>
		<td><select class="input-mini" name="cols[0].isnullable" id="cols_0__isnullable" disabled>
				<option value="01" selected="selected">是</option>
				<option value="02">否</option>


		</select> </td>
		<td><select class="input-mini" name="cols[0].ispk" id="cols_0__ispk" disabled>
				<option value="01">是</option>
				<option value="02" selected="selected">否</option>


		</select> </td>
		<td><select class="input-small" name="cols[0].datadict" id="cols_0__datadict">
				<option value="0" selected="selected"></option>
				<option value="181">下拉</option>
				<option value="263">状态类型</option>
				<option value="267">菜单状态</option>


		</select> </td>
		<td><select class="input-small" name="cols[0].sub_tab_id" id="cols_0__sub_tab_id"
			onchange="getColumnList(this)">
				<option value="0" selected="selected"></option>
				<option value="24">学生表</option>
				<option value="33">系统菜单</option>
				<option value="35">系统菜单表</option>
				<option value="36">菜单表关联导航表</option>
				<option value="37">系统菜单表</option>
				<option value="38">用户表</option>
				<option value="39">sys_navigator</option>
				<option value="43">菜单表（测试）</option>
				<option value="44">菜单测试20130115</option>
				<option value="45">菜单导航表</option>
				<option value="46">菜单表20130116</option>
				<option value="47">菜单表测试</option>
				<option value="49">菜单表（测试）1212</option>
				<option value="50">菜单表（测试）1212</option>


		</select> </td>
		<td><select class="input-small" name="cols[0].sub_tab_col_sqlname"
			id="cols_0__sub_tab_col_sqlname">


		</select> </td>
		<td><input class="input-small" type="text" name="cols[0].validation_type"
			value="" id="cols_0__validation_type" /> </td>
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