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
    
    <script src="bootstrap/js/jquery-1.9.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/bootstrap-buttons.min.js"></script>
    
    <style type="text/css">
      /* Override some defaults */
      html, body {
        background-color: #eee;
      }
      body {
        padding-top: 240px; 
      }
      .container {
        width: 300px;
      }

      /* The white background content wrapper */
      .container > .content {
        background-color: #fff;
        padding: 20px;
        margin: 0 -20px; 
        -webkit-border-radius: 10px 10px 10px 10px;
           -moz-border-radius: 10px 10px 10px 10px;
                border-radius: 10px 10px 10px 10px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.15);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                box-shadow: 0 1px 2px rgba(0,0,0,.15);
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
    
  </head>
  
  <body>
  <div class="container">
    <div class="content">
      <div class="row">
        <div class="login-form">
          <h2>系统登录</h2>
          <form action="">
            <fieldset>
              <div class="clearfix">
                <input type="text" placeholder="登录帐号">
              </div>
              <div class="clearfix">
                <input type="password" placeholder="密码">
              </div>
              <button class="btn btn-primary" type="submit">登  录</button>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </div> <!-- /container -->
</body>
  
</html>