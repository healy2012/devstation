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
<title>数据表资源配置</title>
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
    
    <script type="text/javascript">
    function getColumnList(selectedObj) {

	    var colSelectId = $(selectedObj).attr("id").replace("sub_tab_id","sub_tab_col_sqlname");
	    //alert($("#"+colSelectId).attr("name"));
	    
	    var url = '${pageContext.request.contextPath}/datares/getColumnListById.action';
	    var data = {
			tab_id : $(selectedObj).val()
		};
		
		$.post(url, data, function(rs) {
			var json = window.eval('(' + rs + ')');
			//alert(' result:"'+json.length+'"');
			var temp_html;
			
			$.each(json, function (i, column) {
			
			temp_html+="<option value='"+column.col_sqlname+"'>" + column.col_sqlname + "</option>";

            });
            if(json.length>0){
            	$("#"+colSelectId).html(temp_html);
            }else{
            	$("#"+colSelectId).html("<option value=''></option>");
            }
                    
		});
	}
    
    function test(){
    	var selectList = $("select:disabled");
    	//alert(selectList.size());
    	for(var i=0;i<selectList.size();i++){
    		var o = selectList.get(i);
    		if(o.disabled)
    			o.disabled=false;
    	}
    }
    
    function test2(){
    	$("select:disabled").each( function(){
    		if(this.disabled)
    			this.disabled=false;
    	}
    	)
    }
    
    $("form").submit( function () {
    	$("select:disabled").each( function(){
    		if(this.disabled)
    			this.disabled=false;
    	}
    	)
    	return true;
    } );
    </script>

</head>

<body>    

<div class="container">

<ul class="breadcrumb">
  <li><i class="icon-home"></i><a href="datares/allTableConfig.action">数据表资源配置总览</a> <span class="divider">/</span></li>
  <li class="active">物理模型配置</li>
</ul>
<s2:if test="successMsg!=null">
  <p class="text-success"><i class="icon-info-sign"></i>&nbsp;${successMsg}</p>
<br>
</s2:if>

<form class="form-horizontal" method="post" action="datares/updateDbTableConfig.action">

<input name="table.tab_id" id="table_tab_id" type="hidden"
					value="${table.tab_id}" />
					
  <div class="control-group">
    <label class="control-label">表名称：</label>
    <div class="controls">
      <input type="text" name="table.tab_name" id="tab_name" class="span4"  value="${table.tab_name}">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label">物理表名：</label>
    <div class="controls">
      <input type="text" name="table.tab_sqlname" id="tab_sqlname" class="span4" value="${table.tab_sqlname}" readonly>
    </div>
  </div>
  
  <table class="table table-striped table-bordered table-condensed">
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
  
  <s2:iterator value="cols" status="stat">
	<tr>
		<td>
			<s2:textfield name="cols[%{#stat.index}].col_sqlname" cssClass="input-small"
				value="%{cols[#stat.index].col_sqlname }" readonly="true"/>
			&nbsp;
		</td>
		<td>
			<s2:textfield name="cols[%{#stat.index}].col_sqltype" cssClass="input-small"
				value="%{cols[#stat.index].col_sqltype }"  readonly="true"/>
			&nbsp;
		</td>
		<td>
			<s2:textfield name="cols[%{#stat.index}].col_size" cssClass="input-small"
				value="%{cols[#stat.index].col_size }"  readonly="true"/>
			&nbsp;
		</td>
		<td>
			<s2:textfield name="cols[%{#stat.index}].col_desc" cssClass="input-small"
				value="%{cols[#stat.index].col_desc }" />
			&nbsp;
		</td>
		<td>
			<s2:select name="cols[%{#stat.index}].isnullable" cssClass="input-mini"
				value="%{cols[#stat.index].isnullable }"
				list="#{'01':'是','02':'否'}" disabled="true"/>
			&nbsp;
		</td>
		<td>
			<s2:select name="cols[%{#stat.index}].ispk" cssClass="input-mini"
				value="%{cols[#stat.index].ispk }" list="#{'01':'是','02':'否'}" disabled="true"/>
			&nbsp;
		</td>
		<td>
			<s2:select name="cols[%{#stat.index}].datadict" cssClass="input-small"
				value="%{cols[#stat.index].datadict }" list="dataDictList"
				listKey="bdId" listValue="bdName" />
			&nbsp;
		</td>
		<td>
			<s2:select name="cols[%{#stat.index}].sub_tab_id" cssClass="input-small"
				value="%{cols[#stat.index].sub_tab_id }"
				onchange="getColumnList(this)" list="subTabList"
				listKey="tab_id" listValue="tab_name" />
			&nbsp;
		</td>							
		<td>
		<s2:if test="%{subTabColListMap==null}">
			<s2:select name="cols[%{#stat.index}].sub_tab_col_sqlname" cssClass="input-small"
					value=""
					list="#{'':''}"/>
		</s2:if>
		<s2:else>
			<s2:select name="cols[%{#stat.index}].sub_tab_col_sqlname" cssClass="input-small"
					value="cols[#stat.index].sub_tab_col_sqlname"
					list="subTabColListMap[cols[#stat.index].col_sqlname]" listKey="col_sqlname" listValue="col_sqlname"/>
		</s2:else>
		&nbsp;
		</td>
		<td>
			<s2:textfield name="cols[%{#stat.index}].validation_type" cssClass="input-small"
				value="%{cols[#stat.index].validation_type }" />
			&nbsp;
		</td>
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