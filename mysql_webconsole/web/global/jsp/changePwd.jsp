<%@page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<title>密码重置</title>
<link href="<%=request.getContextPath()%>/global/css/style.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/global/css/content.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/jquery1.4.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/global/scripts/jquery.addmethod.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  $(":reset").click(function() {
	reg.resetForm();// 重置验证
  });	
});

	//对密码的验证
	function validatePwd(pwd) {
		if (!pwd) {
			return false;
		}
		if (pwd.length < 6) {
			return false;
		}
		var specialChar = /[\`\~\!\@\#\$\%\^\&\*\(\)\_\+\-\=]+/g;
		var digit = /[0-9]+/g;
		var letter = /[a-zA-Z]+/g;
		return (specialChar.test(pwd) && digit.test(pwd) && letter.test(pwd));
	}
		
	//对密码的前端认证
	function check() {		
		var pwdBefore = $('#pwdBefore').val();
		var pwdNew = $('#pwdNew').val();
		var pwdNew2 = $('#pwdNew2').val();
		if (!pwdBefore || pwdBefore=="") {
			alert('请输入原密码。');
			return false;
		}
		if (!pwdNew) {
			alert('请输入新密码。');
			return false;
		}
		if (pwdNew != pwdNew2) {
			alert('两次密码不一致，请重新输入。');
			return false;
		}			
		if (!validatePwd(pwdNew)) {
			alert('密码格式不满足要求，请重新输入。(密码必须包含数字、字母以及特殊符号，并且不少于六位)');
			return false;
		}
		return true;
	}
	
	//点击按钮“确定”		
	$(function() {
		$('#btnChangePwd').click(function() {		
			//前端验证
			if( !check() ){
				return ;
			}			
			//后台验证
			var userid = $('#userid').val();
			var pwdBefore = $('#pwdBefore').val();
			var pwdNew = $('#pwdNew').val();				
			
			var action = '<%=request.getContextPath()%>/system/sysVerify.do?method=checkPwd';
			var param = {'userid':userid, 'pwdBefore':pwdBefore};
			$.post(action, param, function(data, textStatus) {
				var json = eval('(' + data + ')');
				if (json.result == 1) {
					document.forms[0].submit();
				} else {
					alert(json.error);
				}
			});				
		});
	});
		
</script>
</head>

<body>
<div class="content"><!-- content start -->
  <h3 class="breadcrumb">
    <span class="current">您现在的位置：</span>
    <span class="a">密码重置</span>
  </h3>
     
  <form id="reg" name="form" action="<%=request.getContextPath()%>/changePwd.do" method="post" target="_parent">
  <table class="table_form">
    <tr>
      <th>原密码：</th>
      <td>
		<input name="pwdBefore" id="pwdBefore" type="password" />
	  </td>
      <td class="place"><p class="annotation">请输入原始密码</p></td>
    </tr>
    <tr>
      <th>新密码：</th>
      <td><input name="pwdNew" id="pwdNew" type="password" /></td>
      <td class="place"><p class="annotation">请输入新的密码</p></td>
    </tr>
    <tr>
      <th>确认密码：</th>
      <td><input name="pwdNew2" id="pwdNew2" type="password" /></td>
      <td class="place"><p class="annotation">请再次输入新的密码</p></td>
    </tr>
  </table>
    
  <p class="box_btn">
    <button type="button" id="btnChangePwd" class="enter"><span>确定</span></button>
    <button type="reset" class="reset"><span>重写</span></button>
    <button type="button" class="back" onclick="history.go(-1)"><span>返回</span></button>
  </p>
  </form>
</div><!-- content end -->
</body>
</html>
