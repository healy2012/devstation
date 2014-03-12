<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-thumbnails.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-buttons.css" rel="stylesheet" />

<script src="bootstrap/js/jquery-1.9.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrap-buttons.min.js"></script>

<style type="text/css">
/* Override some defaults */
html,body {
	background-color: #eee;
}

body {
	padding-top: 240px;
}

.container {
	width: 300px;
}

/* The white background content wrapper */
.container>.content {
	background-color: #fff;
	padding: 20px;
	margin: 0 -20px;
	-webkit-border-radius: 10px 10px 10px 10px;
	-moz-border-radius: 10px 10px 10px 10px;
	border-radius: 10px 10px 10px 10px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
}

.login-form {
	margin-left: 65px;
}

legend {
	margin-right: -50px;
	font-weight: bold;
	color: #404040;
}
</style>

<script type="text/javascript">
	document.onkeypress = function(event) {
		event = window.event || event;
		if (event.keyCode == 13) {
			$('#lbt').click();
		}
	}
	if (window.top != self) {
		window.top.location.href = window.location;
	}
	$(document).ready(function() {
		var errorMessage = '${param.errorMessage}';
		if (errorMessage) {
			alert(errorMessage.split(',').join('\n'));
		}
		$('#username').focus();

		var validateForm = function() {
			var username = $('#username');
			var password = $('#password');

			if (!username.val()) {
				alert('请输入用户名。');
				username.focus();
				return false;
			}
			if (!password.val()) {
				alert('请输入密码。');
				password.focus();
				return false;
			}

			return true;
		};

		$('#lbt').click(validateForm);

		$('#resetbtn').click(function() {
			$("#login")[0].reset();
		});

	});
</script>
</head>
<body>
	<div class="container">
		<div class="content">
			<div class="row">
				<div class="login-form">
					<h2>系统登录</h2>
					<form id="login" name="loginForm"
						action="<%=request.getContextPath()%>/login.action" method="post">
						<fieldset>
							<div class="clearfix">
								<input id="username" type="text" name="username"
									placeholder="登录帐号" />
							</div>
							<div class="clearfix">
								<input id="password" type="password" name="password"
									placeholder="密码" />
							</div>
							<button class="btn btn-primary" id="lbt" type="submit">登
								录</button>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
</body>
</html>
