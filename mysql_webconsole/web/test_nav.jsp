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
.bs-docs-sidenav.affix {
	top: 40px;
}

/*  >表示第一个子元素  */
.bs-docs-sidenav>li:first-child>a {
	-webkit-border-radius: 6px 6px 0 0;
	-moz-border-radius: 6px 6px 0 0;
	border-radius: 6px 6px 0 0;
}

.bs-docs-sidenav>li>a {
	display: block;
	width: 190px \9;
	margin: 0 0 -1px;
	padding: 8px 14px;
	border: 1px solid #e5e5e5;
}

.bs-docs-sidenav {
	width: 228px;
	margin: 30px 0 0;
	padding: 0;
	background-color: #fff;
	-webkit-border-radius: 6px;
	-moz-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, .065);
	-moz-box-shadow: 0 1px 4px rgba(0, 0, 0, .065);
	box-shadow: 0 1px 4px rgba(0, 0, 0, .065);
}

.bs-docs-sidenav .icon-chevron-right {
	float: right;
	margin-top: 2px;
	margin-right: -6px;
	opacity: .25;
}
</style>

</head>


<body>

	<ul class="nav nav-list bs-docs-sidenav affix-top">
		<li class="active"><a href="#overview"><i
				class="icon-chevron-right"></i> 概览</a></li>
		<li class=""><a href="#transitions"><i
				class="icon-chevron-right"></i> 过渡效果</a></li>
		<li class=""><a href="#modals"><i class="icon-chevron-right"></i>
				模态对话框</a></li>
		<li class=""><a href="#dropdowns"><i
				class="icon-chevron-right"></i> 下拉菜单</a></li>
		<li><a href="#scrollspy"><i class="icon-chevron-right"></i>
				滚动监听</a></li>
		<li class=""><a href="#tabs"><i class="icon-chevron-right"></i>
				标签页</a></li>
		<li class=""><a href="#tooltips"><i
				class="icon-chevron-right"></i> 工具提示</a></li>
		<li class=""><a href="#popovers"><i
				class="icon-chevron-right"></i> 弹出提示</a></li>
		<li class=""><a href="#alerts"><i class="icon-chevron-right"></i>
				警告框</a></li>
		<li class=""><a href="#buttons"><i class="icon-chevron-right"></i>
				按钮</a></li>
		<li class=""><a href="#collapse"><i
				class="icon-chevron-right"></i> Collapse</a></li>
		<li class=""><a href="#carousel"><i
				class="icon-chevron-right"></i> 轮播</a></li>
		<li class=""><a href="#typeahead"><i
				class="icon-chevron-right"></i> 输入提示</a></li>
		<li class=""><a href="#affix"><i class="icon-chevron-right"></i>
				附加导航</a></li>
	</ul>

	<script type="text/javascript">
		$(function() {
			$('.nav li').click(function(e) {
				$('.nav li').removeClass('active');
				//$(e.target).addClass('active');
				$(this).addClass('active');
			});
		});
	</script>

</body>
</html>