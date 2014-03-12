function clone(jsonObj, newName) {
    var buf;
    if (jsonObj instanceof Array) {
        buf = [];
        var i = jsonObj.length;
        while (i--) {
            buf[i] = clone(jsonObj[i], newName);
        }
        return buf;
    }else if (typeof jsonObj == "function"){
        return jsonObj;
    }else if (jsonObj instanceof Object){
        buf = {};
        for (var k in jsonObj) {
	        if (k!="parentNode") {
	            buf[k] = clone(jsonObj[k], newName);
	            if (newName && k=="name") buf[k] += newName;
	        }
        }
        return buf;
    }else{
        return jsonObj;
    }
}

//----raodun 2011-12-27
	//var zTree1;
	var url ;
	var inited = false;
	//只对searchTree
	function initEmagList(u){
		if(inited){return;}
		url = u;
		$.each($("input[emagList][simple][typeFlag]"),function(index,ipt){
						doWidth(ipt,url);
					
		});
	}
	//针对一个input开始布局
	function doWidth(input,url){
		//环境 setting
		var emagList = $(input).attr('emagList');//searchTree(树状) | list(纯下拉状)
		var simple = $(input).attr('simple');//true false 单选 复选
		var flag   = $(input).attr('typeFlag');//查询flag
		var def    = $(input).attr('def');//默认值
		if(def && def.indexOf(',') == -1){//保持以，结尾特性
			def += ',';
		}
		var setting = {
		checkable: !eval(simple),//复选框
		checked: true,
		isSimpleData: (emagList=='searchTree'),//list | tree
		treeNodeKey: "bdId",
		treeNodeParentKey: "bdParentId",
		nameCol:"bdName",
		expandSpeed : "fast",
		fontCss: setFont,
		checkType:{'Y':'', 'N':''},
		callback: {
			//beforeExpand: function(){return false;},
			//beforeCollapse: function(){return false;},
			beforeClick: zTreeOnBeforeClick,
			click: eval(simple)?zTreeOnClick:'',
			change:	zTreeOnChange
			}
		};
		//---定义 选择id名、下拉图层id名、下拉树id名
		var INPUTNAME = $(input).attr('name');//from传值框
		var INPUTSEARCHNAME = $(input).attr('name')+'_SEARCH';//用于查询的
		var SELIDNAME = $(input).attr('name')+'_SELIDNAME';//选择按钮
		var LISTDIVIDNAME = $(input).attr('name')+'_LISTDIVIDNAME';//显示树图层
		var SHOWIDNAME    = $(input).attr('name')+'_SHOWIDNAME';//显示被选内容
		var LISTTREEIDNAME = $(input).attr('name')+'_LISTTREEIDNAME';//显示树
		//--临时变量
		var listData;
		listData = $("body").data(INPUTNAME+'NodeData');
		
		//隐藏输入框 加入查询框
		//if($('#'+INPUTSEARCHNAME))//如果已经有了 直接终止
		//{alert($('#'+INPUTSEARCHNAME));
			
		//}
		$(input).after("<input id='"+ INPUTSEARCHNAME+"' name='"+INPUTSEARCHNAME+"' type=text value='' />");
		
		$(input).hide();
		//--焦点点中树显示，焦点移除树隐藏
		$("#"+INPUTSEARCHNAME).bind("focusin",function(){
			showMenu(INPUTSEARCHNAME,LISTDIVIDNAME);
			return false;
		});
		$("body").bind("mousedown", function(event){
				var tp = (event.target.id);
				var fg = (tp!=null && tp.indexOf(INPUTNAME)==-1 && 
					tp.indexOf(INPUTSEARCHNAME)==-1 &&tp.indexOf(SELIDNAME)==-1 &&
					tp.indexOf(LISTDIVIDNAME)==-1 && tp.indexOf(LISTTREEIDNAME)==-1);
				if ( fg ) {
					//log('事件id:'+fg);
					//文本框显示选择的
					$('#'+INPUTSEARCHNAME).val($('#'+SHOWIDNAME).html());
					hideMenu(LISTDIVIDNAME);
					//alert($("#"+INPUTNAME).attr('value'));
				}
		});
		//--加入 下拉图层 
		 $("body").append("<div id='"+LISTDIVIDNAME+"' style='display:none;position:absolute; height:200px; min-width:250px; background-color:white;border:1px solid;overflow-y:auto;overflow-x:auto;' > </div>");
		//--加入显示区层
		$('#'+LISTDIVIDNAME).append("<div id='"+SHOWIDNAME+"'></div>");
		//--加入 下拉树
		$('#'+LISTDIVIDNAME).append("<ul id='"+LISTTREEIDNAME+"' class='tree'></ul>");
		var listTree     = $('#'+LISTTREEIDNAME);
		//--查询input绑定事件
		var bindFun = function(event){
				//对列表数据进行过滤
				var input_v = $("#"+INPUTSEARCHNAME).val();
				//listData = filter($("body").data(INPUTNAME+'NodeData'),input_v);
				reloadTree(def,LISTTREEIDNAME,setting,url,'flag='+flag+'&name='+input_v);
			};
		$("#"+INPUTSEARCHNAME).bind("propertychange",bindFun).bind("input",bindFun);
		//--
		reloadTree(def,LISTTREEIDNAME,setting,url,'flag='+flag);
		def = '';
		$(input).attr('def',def);
	}
	

	
	function setFont(treeId, treeNode) {
		if (treeNode && treeNode.isParent) {
			return {color: "blue"};
		} else {
			return null;
		}
	}

	function showMenu(INPUTSEARCHNAME,LISTDivIDNAME) {
		var vi = $('#'+LISTDivIDNAME).css("display");
		var cityObj = $("#"+INPUTSEARCHNAME);
		var cityOffset = $("#"+INPUTSEARCHNAME).offset();
		$("#"+LISTDivIDNAME).css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
		//log('显示层...');
		//log($("#"+LISTDivIDNAME).css('display'));
	}
	
	function hideMenu(LISTDivIDNAME) {
		$("#"+LISTDivIDNAME).fadeOut("fast");
	}

	function zTreeOnBeforeClick(treeId, treeNode) {
		var check = (treeNode && !treeNode.isParent);
		//if (!check) alert("只能选择子项...");
		return true;
	}
	
	function zTreeOnClick(event, treeId, treeNode) {
		var input_pre =  treeId.substring(0, treeId.indexOf("_"));
		var key_value    =  input_pre;
		var key_show     =  input_pre+"_SEARCH";
		var LISTDIVIDNAME = input_pre+"_LISTDIVIDNAME";
		var showckName     =  input_pre+"_SHOWIDNAME";
		if (treeNode) {
			var showObj = $("#"+key_show);
			var valueObj = $("#"+key_value);
			var showDiv  = $('#'+showckName);
			valueObj.attr("value", treeNode.bdId);
			showObj.attr("value", treeNode.bdName);
			showDiv.html(treeNode.bdName);
			hideMenu(LISTDIVIDNAME);
		}
	}
	/**如果是新id就加入 如果是旧id就移除*/
	function zTreeOnChange(event, treeId, treeNode) {
		var input_pre =  treeId.substring(0, treeId.indexOf("_"));
		var valueIdName    =  input_pre;
		var showIdName     =  input_pre+"_SHOWIDNAME";
		var INPUTSEARCHNAME = input_pre+'_SEARCH';
		var valueObj = $("#"+valueIdName);
		var showObj  = $("#"+showIdName);
		var nowIds = valueObj.attr("value");
		var nowNames = showObj.html();
		var id = treeNode.bdId;
		var name = treeNode.bdName;
		//不存在id 则为勾选情况
		if(nowIds.indexOf(id)==-1){
			nowIds = nowIds + id +","
			nowNames = nowNames + name +","
		}else{
			nowIds = nowIds.replace(id+",","");
			nowNames = nowNames.replace(name+",","");
		}
		valueObj.attr("value",nowIds) ;
		showObj.html(nowNames);
		//$('#'+INPUTSEARCHNAME).val(showObj.html());
	}
	/** //同步式
	function zTreeOnChange(event, treeId, treeNode) {
		showO(event);
		var input_pre =  treeId.substring(0, treeId.indexOf("_"));
		var key_value    =  input_pre;
		var key_show     =  input_pre+"_SEARCH";
		var checkedArr = zTree1.getCheckedNodes();
		var ids = '';
		var names = '';
		for(var i in checkedArr){
			ids = ids + (checkedArr[i].id+",");
			names = names + (checkedArr[i].name+",");
		}
		if (treeNode) {
			var showObj = $("#"+key_show);
			var valueObj = $("#"+key_value);
			valueObj.attr("value", ids);
			//showObj.attr("value", names);
			//hideMenu();
		}
	}*/
	

	function reloadTree(def,LISTTREEIDNAME,setting,url,params) {
		var rao_sd=0;
		var input_pre =  LISTTREEIDNAME.substring(0, LISTTREEIDNAME.indexOf("_"));
		var treeId    =  input_pre+'_LISTTREEIDNAME';
		var value = $('#'+input_pre).val();
		//url = url+"?"+params;
		
		$.post(url,params,function(data){
			var a= "var returnObj =" + data.toString()+";";
			eval(a);
			var rs = returnObj.result;
			if(!rs){alert('ajax无法获取数据，服务器可能关闭或异常！');return;}
			
			//var nodes = myZTree.getNodes();
			for(var index in rs){
				//showO(rs[index]);
				//log('包含:'+value.indexOf(rs[index].bdId));
				//刷新默认勾选情况
				if(  value.indexOf(rs[index].bdId+',')!=-1 ){
					rs[index].checked = true;
				}
				//初次显示，默认勾选情况
				if(def && def.indexOf(rs[index].bdId+',')!=-1){
					rs[index].checked = true;
					zTreeOnChange(null, treeId, rs[index]);
				}
			}
			var myZTree = $("#"+LISTTREEIDNAME).zTree(setting, (rs));
			
		});
	}
	function showO(obj){
		var dt = "";
		for(var i in obj){
			dt = dt + (i +"->"+obj[i]+"</br>\r\n");
		}
		//$("body").append(dt);
		alert(dt);
	}
	function log(ct){
		$("body").append(ct+"</br>");
	}
//--raodun 2011-12-27 end