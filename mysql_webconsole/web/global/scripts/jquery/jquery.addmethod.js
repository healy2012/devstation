// JavaScript Document
$(document).ready(function(){
  $("form .required").each(function(){
	var $required = $("<b class='high'>*</b>"); //创建元素
	$(this).parents("td").prev("th").prepend($required); //追加到页面中
  });

  //input等onfocus样式
  var elements = $(":text,:password,textarea,select");
  elements.focus(function() {
	 $(this).addClass("input_focus");
  });
  elements.blur(function() {
	$(this).removeClass("input_focus");
  });
  
  $("td:has(button)").addClass("input_sp");//选择SP公司input样式处理
  
  //提示信息js
  var $valid = $("input[id],textarea[id],select[id]"); //取页面中所有需手动填写内容（input/textarea）的id
  $valid.focus(function() {
	 $(this).parent("td").next(".place").find(".annotation").addClass("annotation1");
	 var $class = $(this).attr("class");
	 if ( $class=="required input error" || $class=="required error input" || 
	      $class=="required input valid" || $class=="required valid input" ||
		  $class=="input error" || $class=="error input" ||
		  $class=="input valid" || $class=="valid input" ) 
	    { $(this).parent("td").next(".place").find(".annotation").show();
	      $(this).parent("td").next(".place").find("label").hide(); };
  });
  $valid.blur(function() {
	 $(this).parent("td").next(".place").find(".annotation").removeClass("annotation1");
	 var $class = $(this).attr("class");
	 var $value = $(this).val();
	 if ( $class=="required error" || $class=="required valid" ||
	      $class=="error" && $value!="" || $class=="valid" && $value!="" ) 
	    { $(this).parent("td").next(".place").find(".annotation").hide();
		  $(this).parent("td").next(".place").find("label").show(); };
  });
  
  //重置、提交按钮操作时对提示信息js
  $(":reset").click(function() {
	$(".annotation").removeClass("annotation1").show();
//    window.location.reload();
  });
  $(":submit").click(function() {
    var $required = $("input[class*=required],textarea[class*=required],select,:radio,:checkbox"); //页面中必填项
	$required.parents("td").next(".place").find(".annotation").hide();
  });	

	
  // 汉字
  jQuery.validator.addMethod("character", function(value, element) {
   var tel = /^[\u4e00-\u9fa5]+$/;
   return this.optional(element) || (tel.test(value));
  }, "请输入汉字");
 	
  // 中文字两个字节 
  jQuery.validator.addMethod("byteRangeLength", function(value, element, param) { 
	var length = value.length; 
	for(var i = 0; i < value.length; i++){ 
	 if(value.charCodeAt(i) > 127){ 
	  length++; 
	 } 
	} 
	return this.optional(element) || ( length >= param[0] && length <= param[1] ); 
  }, "只能在3-15个字符之间(一个汉字为两个字符)"); 
  	
  // 字符验证 
  jQuery.validator.addMethod("userName", function(value, element) { 
	return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value); 
  }, "登录帐号只能包括中文字、英文字母、数字和下划线"); 
  
  // 密码字符验证 
  jQuery.validator.addMethod("passwordCH", function(value, element) { 
	 return this.optional(element) || /^(\w)+$/.test(value);	
	//var specialChar = /[\`\~\!\@\#\$\%\^\&\*\(\)\_\+\-\=]+/g;
	//var digit = /[0-9]+/g;
	//var letter = /[a-zA-Z]+/g;
	//return this.optional(element) || (specialChar.test(value) && digit.test(value) && letter.test(value)); 
  }, "密码必须包含数字、字母以及特殊符号"); 
  
  // 只能输入正整数 
  jQuery.validator.addMethod("integer", function(value, element) { 
	return this.optional(element) || /^[0-9]*[1-9][0-9]*$/.test(value); 
  }, "只能输入整数"); 
  
  // 手机号码验证 
  jQuery.validator.addMethod("isMobile", function(value, element) { 
	var length = value.length; 
	return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));
  }, "请正确填写您的手机号码"); 

  //对select的验证
  jQuery.validator.addMethod("selectNone", function(value, element) {    
   if (value == "none") { return false; }   
   else { return true; }    
   },"必须选择一项");

  // 中文和字母验证(不包括任何空白符)
  jQuery.validator.addMethod("zeCH", function(value, element) { 
	return this.optional(element) || /^[\u4e00-\u9fa5\A-Za-z]+$/.test(value); 
  }, "只能包括中文字、英文字母"); 

  //YYYYMM+两位数字、后缀为.zip，文件命名验证  
  jQuery.validator.addMethod("attachment", function(value, element) { 
	return this.optional(element) || /((19|20)\d{2})(0?[1-9]|(11|12))\d{2}.z/.test(value); 
  }, "文件命名格式YYYYMM+两位数字（如20100439）"); 

  //业务编号验证（格式为1位字母序号+5位序列号）  
  jQuery.validator.addMethod("numbers", function(value, element) { 
	return this.optional(element) || /^([A-Z]{1}\d{5})+$/.test(value); 
  }, "业务编号只能由1位字母序号+5位序列号组成（如A00001）");
  
  //手机游戏均分验证（格式为999.9）  
  jQuery.validator.addMethod("point", function(value, element) { 
	return this.optional(element) || /^(\d{1,3})(\.\d{1})?$/.test(value); 
  }, "游戏均分只保留一位小数");
  
  // 电话号码验证 
  jQuery.validator.addMethod("isPhone", function(value, element) { 
    var tel = /^(\d{3}-|\d{4}-)?(\d{8}|\d{7})?$/; 
    return this.optional(element) || (tel.test(value)); 
  }, "请正确填写您的电话号码"); 
  
  // 邮政编码验证 
  jQuery.validator.addMethod("isZipCode", function(value, element) { 
    var tel = /^[0-9]{6}$/; 
    return this.optional(element) || (tel.test(value)); 
  }, "请正确填写您的邮政编码"); 
  
    //导航名称验证 
  jQuery.validator.addMethod("navName", function(value, element) { 
	return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value); 
  }, "导航名称只能包括中文字、英文字母、数字和下划线"); 
});











