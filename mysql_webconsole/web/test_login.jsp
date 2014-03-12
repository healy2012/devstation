<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>系统登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-thumbnails.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-buttons.css" rel="stylesheet">
    
    <!-- <link href="http://jumpstartuidemo.com/themes/base/css/font-awesome.min.css" rel="stylesheet"> -->
    
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
    
    <!-- <link href="bootstrap/login/css/base-admin-2.css" rel="stylesheet"> -->
    
    <link href="bootstrap/login/css/signin.css" rel="stylesheet">
    <!-- <link href="http://jumpstartuidemo.com/themes/base/css/base-admin-2-responsive.css" rel="stylesheet"> -->
    
    <script src="bootstrap/js/jquery-1.9.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/bootstrap-buttons.min.js"></script>
    
    <script src="http://jumpstartuidemo.com/themes/base/js/Application.js"></script>
    
    
    
    
  </head>
  <body>    

<div class="account-container stacked">
	
	<div class="content clearfix">
		
		<form action="./index.html" method="post">
		
			<h1>系统登录</h1>		
			
			<div class="login-fields">
				
				<p>请填写帐号和密码:</p>
				
				<div class="field">
					<label for="username">帐号:</label>
					<input type="text" id="username" name="username" value="" placeholder="Username" class="username-field" />
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">密码:</label>
					<input type="password" id="password" name="password" value="" placeholder="Password" class="password-field"/>
				</div> <!-- /password -->
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				
				<span class="login-checkbox">
					<input id="Field" name="Field" type="checkbox" value="First Choice" tabindex="4" />
					<label class="choice" for="Field">保存密码</label>
				</span>
									
				<button class="button btn btn-warning btn-large">登 录</button>
				
			</div> <!-- .actions -->
			
			<!--<div class="login-social">
				<p>Sign in using social network:</p>
				
				<div class="twitter">
					<a href="#" class="btn_1">Login with Twitter</a>				
				</div>
				
				<div class="fb">
					<a href="#" class="btn_2">Login with Facebook</a>				
				</div>
			</div>-->
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


  </body>
</html>