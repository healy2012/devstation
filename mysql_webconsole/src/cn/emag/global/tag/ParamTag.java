package cn.emag.global.tag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ParamTag extends TagSupport {
	private String name="";
	private String value="";
	public void setValue(String value){
	    this.value = value;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	

	public int doEndTag() throws JspTagException {
	    Tag t = findAncestorWithClass(this, PaginateTag.class);
	    PaginateTag parent = (PaginateTag) getParent();
	    parent.addParam(name,value);

	    return EVAL_PAGE;
	}
	
}
