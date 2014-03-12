<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<%@ taglib prefix="emag" uri="/tags/emag"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
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
		<link href="<%=path%>/global/css/style.css" rel="stylesheet"
			type="text/css" />
		<link href="<%=path%>/global/css/content.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript"
			src="<%=path%>/global/scripts/jquery/jquery1.4.2.js"></script>
		<script type="text/javascript"
			src="<%=path%>/global/scripts/jquery/jquery.tableCss.js"></script>
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

   </script>
	</head>
	<body>
		<div class="content">
			<!-- content start -->
			<h3 class="breadcrumb">
				<span class="current">您现在的位置：<a target="systemMainFrame" href="<%=basePath%>datares/tablePageList.action">数据资源模型管理</a>&gt;编辑资源模型
				</span>
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
			<form method="post" action="datares/saveTabModel.action">

				<input name="table.tab_id" id="table_tab_id" type="hidden"
					value="${table.tab_id}" />

				<table class="table_form">
					<tr>
						<th>
							表名称：
						</th>
						<td>
							<input name="table.tab_name" id="tab_name" type="text"
								value="${table.tab_name}" class="required" maxlength="30" />
						</td>
						<td class="place">
							<p class="annotation">
								不超过30个字符
							</p>
						</td>
					</tr>
					<tr>
						<th>
							物理表名：
						</th>
						<td>
							<input name="table.tab_sqlname" id="tab_sqlname" type="text"
								value="${table.tab_sqlname}" class="required" maxlength="30"
								readonly="true" />
						</td>
						<td class="place">
							<p class="annotation">
								不超过30个字符
							</p>
						</td>
					</tr>
				</table>

				<table class="table_list">
					<tr>
						<%-- <th><input name="checkAll" type="checkbox" value="全选/取消全选" /></th>--%>
						<th>
							物理表字段名称
						</th>
						<th>
							物理表字段类型
						</th>
						<th>
							物理表字段长度
						</th>
						<th>
							字段描述
						</th>
						<th>
							能否为空
						</th>
						<th>
							是否主键
						</th>
						<th>
							关联数据字典
						</th>
						<th>
							关联子表对象ID
						</th>
						<th>
							关联子表物理表字段名称
						</th>
						<th>
							字段验证类型
						</th>
					</tr>

					<s2:iterator value="cols" status="stat">
						<tr>
							<%-- <td><input name="userCheckBox" id="${stat.index}" type="checkbox" value="${stat.index}" /></td>--%>
							<td>
								<s2:textfield name="cols[%{#stat.index}].col_sqlname"
									value="%{cols[#stat.index].col_sqlname }" readonly="true"/>
								&nbsp;
							</td>
							<td>
								<s2:textfield name="cols[%{#stat.index}].col_sqltype"
									value="%{cols[#stat.index].col_sqltype }"  readonly="true"/>
								&nbsp;
							</td>
							<td>
								<s2:textfield name="cols[%{#stat.index}].col_size"
									value="%{cols[#stat.index].col_size }"  readonly="true"/>
								&nbsp;
							</td>
							<td>
								<s2:textfield name="cols[%{#stat.index}].col_desc"
									value="%{cols[#stat.index].col_desc }" />
								&nbsp;
							</td>
							<td>
								<s2:select name="cols[%{#stat.index}].isnullable"
									value="%{cols[#stat.index].isnullable }"
									list="#{'01':'是','02':'否'}" />
								&nbsp;
							</td>
							<td>
								<s2:select name="cols[%{#stat.index}].ispk"
									value="%{cols[#stat.index].ispk }" list="#{'01':'是','02':'否'}" />
								&nbsp;
							</td>
							<td>
								<s2:select name="cols[%{#stat.index}].datadict"
									value="%{cols[#stat.index].datadict }" list="dataDictList"
									listKey="bdId" listValue="bdName" />
								&nbsp;
							</td>
							<td>
								<s2:select name="cols[%{#stat.index}].sub_tab_id"
									value="%{cols[#stat.index].sub_tab_id }"
									onchange="getColumnList(this)" list="subTabList"
									listKey="tab_id" listValue="tab_name" />
								&nbsp;
							</td>							
							<td>
							<s2:if test="%{subTabColListMap==null}">
								<s2:select name="cols[%{#stat.index}].sub_tab_col_sqlname"
										value=""
										list="#{'':''}"/>
							</s2:if>
							<s2:else>
								<s2:select name="cols[%{#stat.index}].sub_tab_col_sqlname"
										value="cols[#stat.index].sub_tab_col_sqlname"
										list="subTabColListMap[cols[#stat.index].col_sqlname]" listKey="col_sqlname" listValue="col_sqlname"/>
							</s2:else>
							&nbsp;
							</td>
							<td>
								<s2:textfield name="cols[%{#stat.index}].validation_type"
									value="%{cols[#stat.index].validation_type }" />
								&nbsp;
							</td>
						</tr>
					</s2:iterator>
				</table>

				<p class="box_btn">
					<button type="submit">
						提交
					</button>
					<button type="reset">
						重写
					</button>
					<button type="button" onclick=
	history.go(-1);
>
						返回
					</button>
				</p>

			</form>

		</div>
		<!-- content end -->
	</body>
	</body>
</html>
