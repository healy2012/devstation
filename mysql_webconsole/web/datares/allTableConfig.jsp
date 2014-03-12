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
<title>数据表资源配置总览</title>
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

    </script>

</head>
<body>    

<div class="container">

<ul class="breadcrumb">
  <li><i class="icon-home"></i>数据表资源配置总览</li>
</ul>

<ul class="thumbnails">
<s2:iterator value="tabList" id="tab">
  <li class="span3">
    <div class="thumbnail">
      <p><i class="icon-list-alt"></i><a href="datares/dynamicTableList.action?tab_id=${tab.tab_id}" target="systemMainFrame">${tab.tab_name}：${tab.tab_sqlname}</a></p>   
		<div class="btn-group">
		  <a href="datares/dbTableConfig.action?tab_id=${tab.tab_id}" target="systemMainFrame" class="btn btn-info">编辑资源模型</a>
		  <a href="datares/tableDispConfig.action?tab_id=${tab.tab_id}" target="systemMainFrame" class="btn btn-info">编辑展现模型</a>
		</div>
    </div>
  </li>
 </s2:iterator>
    
</ul>

</div>
  </body>
</html>