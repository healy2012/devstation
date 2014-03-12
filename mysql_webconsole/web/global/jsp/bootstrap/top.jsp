<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap 101 Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="../../../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../../bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="../../../bootstrap/css/bootstrap-thumbnails.css" rel="stylesheet">
<link href="../../../bootstrap/css/bootstrap-buttons.css" rel="stylesheet">

<script src="../../../bootstrap/js/jquery-1.9.1.min.js"></script>
<script src="../../../bootstrap/js/bootstrap.min.js"></script>
<script src="../../../bootstrap/js/bootstrap-buttons.min.js"></script>
</head>

<body>	
<header>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a data-target=".nav-collapse" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a href="#" class="brand">Project name</a>
				<div class="nav-collapse">
					<ul class="nav">
						<li ><a href="#">主页</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li><a href="#">Link</a></li>
						<li class="active dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#">Dropdown <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li class="active dropdown-submenu"><a href="#">More options</a>
									<ul class="dropdown-menu">
										<li><a href="#">Second level link</a></li>
										<li><a href="#">Second level link</a></li>
										<li class="active"><a href="#">Second level link</a></li>
										<li><a href="#">Second level link</a></li>
										<li><a href="#">Second level link</a></li>
									</ul></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="nav-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<form action="" class="navbar-search pull-left">
						<input type="text" placeholder="Search" class="search-query span2">
					</form>
					<ul class="nav pull-right">
						<li><a href="#">Link</a></li>
						<li class="divider-vertical"></li>
						<li class="dropdown"><a class="#" href="#">Menu</a></li>
					</ul>
				</div>
				<!-- /.nav-collapse -->
			</div>
		</div>
	</div>
</header>
</body>

<frameset rows="700,20" cols="*">
			<frame src="<%=request.getContextPath()%>/datares/allTableConfig.action"
				name="mainFrame" noresize="noresize" id="mainFrame"
				title="mainFrame" />
			<frame src="<%=request.getContextPath()%>/global/jsp/footer.jsp"
				name="footFrame" noresize="noresize" id="footFrame"
				title="footFrame" />
</frameset>
</html>
