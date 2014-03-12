<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<%@ taglib uri="/taglib/emag" prefix="emagtag"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" " http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns=" http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>修改导航</title>
    
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
        <script type="text/javascript" src="<%=path%>/global/scripts/jquery/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=path%>/global/scripts/jquery/jquery.addmethod.js"></script>

<script type="text/javascript">
$(document).ready(function(){

  $(":reset").click(function() {
	reg.resetForm();// 重置验证
  });
  
  $("#back").click(function() {
	window.location="queryNavigatorList.action";
  });
  
   var reg = $("#reg").validate({
	  onkeyup:false,
	  errorPlacement: function(error, element) {
	  error.appendTo( element.parent("td").next("td") );//验证信息显示位置
	},
	rules: {
	   "navigator.navName":{
		navName: true,
		byteRangeLength: [1,20]
	  },
	   "navigator.navUrl": {
	    
	  },	
	  "navigator.navSeq":{
	    digits:true,
	    remote:{
		          url:"<%=request.getContextPath()%>/system/remoteValidateSeq.action?navIds=${navigator.navId}",
		          type:"post",
		          datatype:"json",
		          data:{
		                  'navigator.navSeq':navigator.navSeq
		                  
		                   
		                  
		               }
		        }
	  },
	  "navigator.navNote": {
		character: true,
		byteRangeLength: [4,100]
	  }
	},
	messages: {
	    "navigator.navName": 
	  {
		required: "请输入导航名称",
		userName:"导航名称只能包括中文字、英文字母、数字和下划线",
		byteRangeLength:"导航名称在1-20个字符之间(一个汉字为两个字符)"
	  },
	  "navigator.navUrl": {
		required: "请输入导航链接地址"
	  },
	  "navigator.navSeq": {
		digits:"请输入数字",
		remote:"您输入的序号和已有导航序号重复，请重新输入"
	  },
	  "navigator.navNote": {
		character: "只能输入汉字",
		byteRangeLength:"至少两个汉字，不超过50个"
	  }
	},
	success: function(label) {
	  label.text("填写正确").addClass("success");
	}
  });
});
   
   


</script>
    
  </head>
  
  <body>
<div class="content"><!-- content start -->
   <h3 class="breadcrumb">
   <span class="current">您现在的位置：系统管理&gt;<a target="systemMainFrame" href="<%=basePath%>system/queryNavigatorList.action">导航管理</a>&gt;<a target="systemMainFrame" href="<%=basePath%>system/updateNavigator.action?navIds=${navigator.navId}">修改导航</a></span>
  </h3>
   
  <h4 class="warning">请填写以下信息完成新建。加“*”为必填项。</h4>
  
  <s2:form id="reg" action="updateSaveNavigator">
  <table class="table_form">
    <tr>
      <th>导航名称：</th>
      <td><input name="navigator.navName" id="navName" type="text" value="${navigator.navName}" class="required" maxlength="20"/></td>
      <td class="place"><p class="annotation">1-20个字符，只能包括中文字、英文字母、数字和下划线。一个中文为2个字符。</p></td>
    </tr>
    <tr>
      <th>导航链接：</th>
      <td><input name="navigator.navUrl" id="navigator.navUrl" type="text" value="${navigator.navUrl}" class="required"/></td>
      <td class="place"><p class="annotation">请填写正确的导航链接地址</p></td>
    </tr>
    <tr>
      <th>导航排序：</th>
      <td><input name="navigator.navSeq" id="navigator.navSeq" type="text" value="${navigator.navSeq }"/></td>
      <td class="place"><p class="annotation">请输入新建导航序号，只能为数字，导航显示将按照该排序值的大小从左到右排序</p></td>
    </tr>
    <tr>
      <th>备注：</th>
      <td><input name="navigator.navNote" id="navigator.navNote" type="text" value="${navigator.navNote }"/></td>
      <td class="place"><p class="annotation">请填写备注</p></td>
    </tr>
    <tr>
      <th>导航状态：</th>
      <s2:if test="%{navigator.navStatus == 1}">
      <td>
           启用：<input type="radio" id="navigator.navStatus" name="navigator.navStatus" value="1" checked/>
           停用：<input type="radio" id="navigator.navStatus" name="navigator.navStatus" value="0"/>
      </td>
      </s2:if>
       <s2:if test="%{navigator.navStatus == 0}">
      <td>
           启用：<input type="radio" id="navigator.navStatus" name="navigator.navStatus" value="1" />
           停用：<input type="radio" id="navigator.navStatus" name="navigator.navStatus" value="0" checked/>
      </td>
      </s2:if>
      <td class="place"><p class="annotation">请选择导航状态</p></td>
    </tr>
      <input type="hidden" name="navigator.navId" id="navigator.navId" value="${navigator.navId}"/>
      <s2:div>
         <s2:fielderror/>
      
      </s2:div>
  </table>
    
     <p class="box_btn">
    <button type="submit" class="enter">确定</button>
    <button type="reset" class="reset">重写</button>
    <button type="button" class="back" id="back">返回</button>
  </p>
  </s2:form>
</div><!-- content end -->
</body>
</html>
