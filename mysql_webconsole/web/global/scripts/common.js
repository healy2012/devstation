/**
 * 使用ajax提交数据
 * @param url 请求的url
 * @param data 参数
 * @param succ_callback 请求成功后执行函数
 * @param err_callback 请求失败后执行函数 
 */
function ajax_post(url,data,succ_callback,err_callback) {
	if ( $.isFunction( data ) ) {
		succ_callback = data;
		data = {};
	}
	$.ajax({
		type : 'POST',
 		cache : false,
 		url : url,
 		data : data,
 		success : function(data) {
 			var json = window.eval('(' + data + ')');
 			if (json.error) {
 				alert(json.error);
 				if ($.isFunction(err_callback)) {
 					err_callback(data);
 				}
 				return;
 			}
			succ_callback(data);	
 		},
 		error : function(html){
 			alert("提交数据失败，代码:" +html.status+ "，请稍候再试 。");
 		}
 	});
}

/**
 * 使用ajax获取json格式数据
 * @param url 请求的url
 * @param data 参数
 * @param succ_callback 请求成功后执行函数
 * @param err_callback 请求失败后执行函数 
 */
function ajax_json(url,data,succ_callback,err_callback) {
	if ( $.isFunction( data ) ) {
		succ_callback = data;
		data = null;
	}
	$.ajax({
		type : 'GET',
 		cache : false,
 		url : url,
 		data : data,
 		success : function(data) {
 			var json = window.eval('(' + data + ')');
 			if (json.error) {
 				alert(json.error);
 				if ($.isFunction(err_callback)) {
 					err_callback(json);
 				}
 				return;
 			}
			succ_callback(json);	
 		},
 		error : function(html){
 			alert("提交数据失败，代码:" +html.status+ "，请稍候再试。");
 		}
 	});
}
function openwindow(url,name,iWidth,iHeight) {                       
   var iTop = (window.screen.availHeight-30-iHeight)/2; 
   var iLeft = (window.screen.availWidth-10-iWidth)/2; 
   window.open(url,name,'height='+iHeight+',innerHeight='+iHeight+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',dialog=yes,modal=yes,toolbar=no,menubar=no,scrollbars=auto,resizable=no,location=no,status=no'); 
}