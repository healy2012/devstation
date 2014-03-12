<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>登陆页</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/global/css/style_login.css"/>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/gradient.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/jquery1.4.2.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/jquery.blockUI.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/common.js"></script>
		<script type="text/javascript">
			document.onkeypress  = function(event) {
				event = window.event || event;
				if (event.keyCode == 13) {
					$('#lbt').click();
				}
			}
			if (window.top != self) {
				window.top.location.href = window.location;
			}
			$(document).ready(function() {
				var errorMessage = '${param.errorMessage}' ;
				if (errorMessage) {
					alert(errorMessage.split(',').join('\n'));
				}
				$('#username').focus();

				var getSmsCode = function() {
					var username = $('#username');
					var password = $('#password');
					if (!username.val()) {
						alert('请输入用户名。');
						username.focus();
						return ;
					}
					if (!password.val()) {
						alert('请输入密码。'); 
						password.focus();
						return ;
					}
					var action = '<%=request.getContextPath()%>/preLogin.action?method=sendValidateCode';
					var param = { username : username.val() , password : password.val()};
					ajax_post(action, param, function(data) {
						var json = window.eval('(' + data + ')') ;
						if (json.result.indexOf('success') != -1) {
						    var smsRandomCode = json.result.split(':')[1];
							$('#smsRandomCode').val(smsRandomCode);
							$.blockUI({message:$('#smscode')});
						} else {
							$.unblockUI(); 
							alert(json.result);
						}
					},function(data) {
						$.unblockUI(); 
					});
					$.blockUI({message:'发送手机验证码中...'});
				} ;
				 
				$('#lbt').click(getSmsCode);
				
				$('#getValiCodeAgain').click(getSmsCode); 
				
				$('#resetbtn').click(function()
	            {
				   $("#login")[0].reset();   
				});

				$('#smsmenu').click(function(){
					$.unblockUI(); 
				});

				$('#smsa').click(getSmsCode);
				
				$('#smssubmit').click(function(){
					if(!$('#smsRandomCode').val()){		
						alert("请输入短信验证码!");
						$('#smsRandomCode').focus();	
						return ;		
					}
				var username = $('#username').val();
				var password = $('#password').val();
				var validateCode = $('#smsRandomCode').val();
				var action = '<%=request.getContextPath()%>/preLogin.action?method=validateUser';
				var param = {'username':username,'password':password,'smsRandomCode':validateCode};
	        	ajax_json(action,param,function(data) {
					document.forms[0].submit();
					$('#smssubmit').attr('disabled',false);
				},function(data) {
					$('#smssubmit').attr('disabled',false);
				});
				});
			});	
		</script>
	</head>
	<body class="Body">
	   <div class="LoginPop" id="smscode" style="center;display: none; cursor: default;">   
              <h4>短信验证</h4>
              <h5>为保障您的信息安全，请输入收到的短信验证码</h5>
               <div class="confirm"><input class="shuru" type="text"  name="smsRandomCode" id="smsRandomCode" maxlength="20" size="16" tabindex=1/><input type="button" name="smssubmit" id="smssubmit" class="queren"/></div>
               <h6>验证码在5分钟内有效。</h6>
               <h6>如果您在5分钟内没有收到短信验证码,请<a id="getValiCodeAgain">重新获取验证码。</a></h6>
               <h6>如果您连续3次重试都没有成功收到，建议您稍后再试。</h6>
         </div>
		<div class="landBox">   
		  <div class="centerMatter">
		   <div class="logo"></div>
              <div class="title"></div>
                <div class="LoginBox">
                  <div class="CenterBack">          
			   <form id="login" name="loginForm"
				action="<%=request.getContextPath()%>/login.action"
				method="post">
					<!-- box_login start -->
					 <div class="importA">
					    <label>账户名：</label>
                         <input id="username" type="text" name="username"/>
                     </div>
					 <div class="importB">
                                   <label>密&nbsp;&nbsp;&nbsp;码：</label>
                                   <input id="password" type="password" name="password" />
                      </div>
                      <div class="importC">
                                  <h4><span>系统提示：</span>为了您的帐号安全，请经常修改密码！</h4>
                                  <h4>如果您忘记了密码，请及时和系统管理员联系！</h4>
                      </div>
					  <div class="importD">
                            <input class="as" name="" id="lbt" type="button" /><input class="cd" name="" id="resetbtn" type="button" />
                      </div>
			    </div>
			 </div>
			</form>
			 <div class="footBox"><span>Power&nbsp;&nbsp;by&nbsp;&nbsp;&nbsp;&nbsp;Copyright&nbsp;&nbsp;©&nbsp;&nbsp;2011-2012</span></div>
		</div>
	</div>
	</body>
</html>
