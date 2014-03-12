<%@	page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Cache-Control" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<title>新增数据字典</title>
		<link href="<%=request.getContextPath()%>/global/css/style.css"
			rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/global/css/content.css"
			rel="stylesheet" type="text/css" />
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/global/scripts/jquery/jquery-1.4.3.min.js"></script>
		<script type="text/javascript">
			$(document).ready( function() {
				$('#seq').keypress(function(event) {
					var key = event.keyCode || event.which;
					if ((key<48) || (key>57 && key != 190)) { 
						return false ;
					}
				});
				$('#doSubmit').click( function() {
					if (!$('#bdName').val()) {
						alert('请输入标题。');
						return;
					}
					/**
					var seq = $('#seq').val();
					if (!seq) {
						alert('请输入序号。');
						return;
					}
					if ((seq - 0) > 10000) {
						alert('序号不能大于10000。');
						return;		
					}
					var url = '${pageContext.request.contextPath}/system/systemAjax?method=checkMenuSeq';
					var data = {navId:'${param.navId}',parentId : ('${param.parentId}' || 0),seq : (seq - 0),menuId : 0};
					$.post(url,data,function(data) {
						var json = window.eval('(' + data + ')');
						if (json.result) {
							alert('序号[' + seq + ']已经存在。');
						} else {
							document.forms[0].submit();
						}
					});
					**/
					document.forms[0].submit();
				});
			});
		</script>
	</head>
	<body>
		
		<div class="content">
			<h2 class="content" align="center"> 修改数据字典</h2>
			<s:form action="doEditBd.action" method="post">
				<table class="table_form">
					<s:hidden id="bdId" name="baseData.bdId" value="%{baseData.bdId}"/>
					<s:hidden id="code" name="baseData.bdCode" value="%{baseData.bdCode}"/>
				<tr>
			     <th>名字：</th>
			      <td><input name="baseData.bdName" id="bdName" type="text" value="${baseData.bdName }" class="required" maxlength="10"/></td>
			      <td class="place"><p class="annotation">1-20个字符，只能包括中文字、英文字母、数字和下划线。一个中文为2个字符。</p></td>
			    </tr>
			    
			    <tr>
			      <th>类英文标识：</th>
			      <td><input name="baseData.bdFlag" id="bdFlag" type="text" value="${baseData.bdFlag }" class="required"/></td>
			      <td class="place"><p class="annotation">请填写</p></td>
			    </tr>
			    
			    <tr>
			      <th>值：</th>
			      <td><input name="baseData.bdValue" id="bdValue" type="text" value="${baseData.bdValue }" class="required"/></td>
			      <td class="place"><p class="annotation">请填写</p></td>
			    </tr>
			    
			    <tr>
			      <th>备用值1：</th>
			      <td><input name="baseData.bdValue_1" id="bdValue_1" type="text" value="${baseData.bdValue_1 }" class="required"/></td>
			      <td class="place"><p class="annotation">请填写</p></td>
			    </tr>
			    
			    <tr>
			      <th>备用值2：</th>
			      <td><input name="baseData.bdValue_2" id="bdValue_2" type="text" value="${baseData.bdValue_2 }" class="required"/></td>
			      <td class="place"><p class="annotation">请填写</p></td>
			    </tr>
			    
			    <tr>
			      <th>父id：</th>
			      <td><input name="baseData.bdParentId" id="bdParentId" type="text" value="${baseData.bdParentId }" class="required"/></td>
			      <td class="place"><p class="annotation">请填写</p></td>
			    </tr>
    
				</table>
				<p class="box_btn">
					<input type="button" id="doSubmit" class="wsj_button" value="修改" />
				</p>
			</s:form>
		</div>
	</body>
</html>
