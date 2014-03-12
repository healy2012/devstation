package cn.emag.global.tag;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**作者：饶敦 blue_wait@163.com
 * 入参pageNumber pageSize total可能为""bug已修复
 *  pageSize如果为""自动改为1
 *  pageNumber->pageNumber
 *  pageSize->pageSize
 *  sortColumns排序列 */
public class PaginateTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5649855178067051902L;
	private String action;//
	private String pageNumber;
	private String pageSize;//页最大行数
	private String total;//结果集的总条数数
	private Map<String, String> otherParam = new HashMap<String, String>();//其他需要加在url后面的参数
	private StringBuffer paramString = new StringBuffer();


	
	public int doStartTag() throws JspTagException {
		
		return this.EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException {
		action =  action+"?";
		
		int  _pageNumber = (pageNumber==null||pageNumber=="")?0:Integer.parseInt(this.pageNumber);
		int _pageSize = Integer.parseInt("".equals(this.pageSize)?"1":this.pageSize);//格式化成数字
		int _total = Integer.parseInt("".equals(this.total)?"0":this.total);//格式化成数字
		try {
			
			//对参数的中午进行编码
			if(null!=otherParam){
				for(Entry<String, String> v :otherParam.entrySet()){
					paramString.append(v.getKey());
					paramString.append("=");
					paramString.append(URLEncoder.encode(URLEncoder.encode(v.getValue(),"utf-8"), "UTF-8"));
					paramString.append("&");
				}
			}
			
		} catch (UnsupportedEncodingException e1) {
			System.out.println("分页标签.页面编码错误");
			e1.printStackTrace();
		}
		//最大页
		int num = _total % _pageSize ==0?_total / _pageSize:(_total / _pageSize)+1;
		

		String tempstring = "";
		String casestring = "<div id='paginateDiv'><a style='display:none' id='forPaginate' href="+action + "pageNumber=0&pageSize=" +_pageSize+  "&"+ paramString +"   > "+  "临时" +"</a>";
		
		
		tempstring = (_pageNumber > 1)? (casestring+"<span> <a id='forPaginate' href="+action + "pageNumber=" +(_pageNumber-1)+  "&pageSize=" +_pageSize+  "&"+ paramString +"   > "+  "上一页" +"</a> </span>") : (casestring+"<a><span>上一页</span></a> ");
		
		
		for(int i=(_pageNumber-10)<0?1:(_pageNumber-10);i<=(_pageNumber+10)&&i<=num;i++){
			
			//限制最大链接数
		
			   if(_pageNumber ==i ){//当前页
				casestring = String.valueOf(_pageNumber);
			   }else{
				casestring = "<span> <a name='forPaginate' id='forPaginate' onclick='return linkClick(this)' href="+action + "pageNumber=" +(i)+  "&pageSize=" +_pageSize+  "&"+ paramString +"   > "+  (i) +"</a> </span>";
			   }
			   
			   tempstring = tempstring+casestring;
			
		}
		double f = Math.ceil((double)_total/_pageSize) - _pageNumber;
		casestring = ( f>0 )? "<span> <a id='forPaginate' onclick='return linkClick(this)' href="+action + "pageNumber=" +(_pageNumber+1)+  "&pageSize=" +_pageSize+  "&"+ paramString +"   > "+  " 下一页 " +"</a> </span>":"<a> 下一页 </a>";
		
		tempstring = tempstring+casestring;
		
		
		
		//手动输入跳转
		tempstring = tempstring +" <span><input type='text' id='page_num' name='page_num' size='5' maxlength='5' value='"+_pageNumber+"'  /> /" +num + "</span> <INPUT type='hidden' id=pageSize value="+_pageSize+" name=pageSize>  <span><input type='button' value='GO' onclick='addPageUrl(this)'/></span>";
		
		
	JspWriter out = pageContext.getOut();//获得一个输出对象
	try {
//		this.pageContext.getResponse().setCharacterEncoding("UTF-8");
		tempstring = tempstring +"<script>function addPageUrl(p){var pnum=p.parentNode.parentNode.getElementsByTagName('input')[0].value;if(pnum>"+num+"){alert('页数过大');p.parentNode.parentNode.getElementsByTagName('input')[0].value="+num+";return false;}  this.location = p.parentNode.parentNode.childNodes[0].href.replace('pageNumber=0','pageNumber='+((p.parentNode.parentNode.getElementsByTagName('input')[0].value)));} </script></div>";
	  out.print(tempstring);//在jsp页面显示
	  
	} catch (IOException e) {
	  e.printStackTrace();
	}finally{
		otherParam.clear();
		paramString.delete(0, paramString.length());
	}

	return super.doEndTag();
	}





	public String getAction() {
		return action;
	}





	public void setAction(String action) {
		this.action = action;
	}





	public String getPageNumber() {
		return pageNumber;
	}





	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}





	public String getPageSize() {
		return pageSize;
	}





	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}





	public String getTotal() {
		return total;
	}





	public void setTotal(String total) {
		this.total = total;
	}







	public void addParam(String name,String value) {
		this.otherParam.put(name, value);
	}






	
	
}
