;(function($) {
	$.fn.extend({
		"tableCss":function(options) {
		    options=$.extend({
			  odd:"odd", //偶数行样式
			  even:"even",  //奇数行样式
			  hover:"hover", //鼠标移入时的样式
			  selected:"selected"  //选中行样式
			},options);
			$("tr:has(th)",this).removeClass(options.odd);
			$("tr:odd",this).addClass(options.odd);
			$("tr:even",this).addClass(options.even);
			$("tr:has(td)",this).mousemove(function() {
			    $(this).addClass(options.hover);
			});
			$("tr",this).mouseout(function() {
			    $(this).removeClass(options.hover);
			});
			$("tr:gt(0):has(:checkbox)",this).click(function() {
				//判断行当前是否选中
		        var hasSelected=$(this).hasClass(options.selected);
				//如果复选框选中，则移出selected类，否则就加上selected类
				$(this)[hasSelected?"removeClass":"addClass"](options.selected)
				.find(":checkbox").attr("checked",!hasSelected); //查找内部的checkbox，设置对应的属性
				
				//全选状态下，任一复选框取消选中，控制全选的复选框则也取消选中；所有复选框同时选中时，控制全选的复选框则也被选中（联动）
				var $tmp = $("td>input[type='checkbox']"); //定义临时变量（避免重复使用选择器）
				$("th>input[type='checkbox']").attr("checked", $tmp.length == $tmp.filter(":checked").length);
				//使用filter()方法筛选出选中的复选框，和全部复选框的对象比较 length，
				//然后将返回的布尔值直接赋给#checkedAll
			});
			
			$("th>input[type='checkbox']",this).click(function() {
				if ($(this).attr("checked")==true) { //全选
					$("tr:has(:checkbox)").addClass(options.selected)
					       .find(":checkbox").attr("checked",true);
				} 
				else {
					$("tr:has(:checkbox)").removeClass(options.selected) //取消全选
					       .find(":checkbox").attr("checked",false);
				}
			});
		
			$("tr:has(:radio)",this).click(function() {
				$(":radio").attr("checked",false);//查找内部的radio（only ie）
				
				//如果单选框选中，则移出selected类，否则就加上selected类
				$(this).addClass(options.selected).siblings().removeClass(options.selected).end();
				$(this).find(":radio").attr("checked",true);//查找内部的radio，设置对应的属性
			});
			
			//如果单选框默认情况下是选择的，则高色
			$("tr:has(:checked)",this).addClass(options.selected);
			return this; //返回this，使方法可链
		}
	});
})(jQuery);

//处理列表th、td border样式js（根据实际表格样式而定）
$(document).ready(function(){
  $(".table_list tr").find("th:last").css({"border-right":"0"});
  $(".table_list").find("tr:has(td):not(:first)>td").css({"border-top":"0"});
});




















