<%@page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache" />
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache" />
		<META HTTP-EQUIV="Expires" CONTENT="0" />
		<title>用户登陆信息</title>
		<link href="<%=request.getContextPath()%>/global/css/style.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/global/css/header.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/judy.js"
			language="javascript"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/jquery-1.4.3.min.js"
			language="javascript"></script>
		<script type="text/javascript">
	$(document).ready( function() {
		var top = $('#top', parent.document);
		$("#slide_top").toggle( function() {
			top.attr("rows", "0,49,642*");
			$(this).attr("class", "fold").find("span").text("展开");
			$(this).attr("title", "点击展开");
		}, function() {
			top.attr("rows", "99,49,642*");
			$(this).attr("class", "unfold").find("span").text("展开");
			$(this).attr("title", "点击收起")
		});
	});
</script>
		<style type="text/css">
a span {
	display: none;
}

a.fold,a.fold:hover,a.unfold,a.unfold:hover {
	background: url(images/btn_group.gif) no-repeat 0 -130px;
	width: 45px;
	height: 49px; 
	display: inline-block;
	position: absolute;
	z-index: 10;
	top: 1px;
	right: 5px;
}

a.fold:hover {
	background-position: -45px -130px;
}

a.unfold {
	background-position: -90px -130px;
}

a.unfold:hover {
	background-position: -135px -130px;
}
.header_nav ul{
    list-style-type:none;
}
.header_nav li{
	float:left; 
	text-align:left;
	padding:0px 6px 0px 6px; height:49px; line-height:37px;
}
.header_nav a {float:left;display: block;    padding: 5px 10px 5px 35px; font-size:14px; font-weight:normal; color:#FFF; font-size:14px; font-weight:normal; color:#FFF;
	margin: 0px; 	
	text-decoration: none; 
	background:left no-repeat url(../images/tgop_03.jpg);
}
.header_nav a:hover, .header_nav a.selected { color:#F00;padding-left:35px;padding-right:5px;background:left no-repeat url(../images/tgop_05.jpg);}
</style>
	</head>
	<body>
		<a href="#" class="unfold" id="slide_top" title="点击收起"><span>收起</span></a>
		<div class="header_nav">
			<ul>
		
			     <s2:iterator value="%{#session.CLIENT_SESSION.attributes.displayNavigator}" id="navigator">
			        
                     <li>
						<a href="<%=request.getContextPath()%>${navigator.navUrl}?navId=${navigator.navId}" target="mainFrame">${navigator.navName}</a>
					</li>
			     
			     </s2:iterator>
			     
				 
		 </ul>
		   <!-- header_nav start -->
			您好，
			<span>${CLIENT_SESSION.userName}</span> 现在是：
	        <script type="text/javascript">
	          document.write(NowDateText);
            </script>
		</div>
		<!-- header_nav end -->
	</body>
</html>
