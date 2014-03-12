/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.emag.rao.vo.query;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.emag.rao.model.*;
import com.emag.rao.dao.*;
import com.emag.rao.service.*;
import com.emag.rao.vo.query.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

/**edit by raodun 2012-7-10
字符串都进行解码 防止分页的乱码问题*/
public class TcamsGroupQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 用户组ID */
	private java.lang.Long groupId;
	/** 用户组名称 */
	private java.lang.String groupName;
	/** 用户组描述 */
	private java.lang.String groupDesc;
	/** 用户组父ID（-1表示无父节点） */
	private Long parentGroupId;
	/** 层级（1表示顶级，2表示第二级） */
	private Long levelId;
	/** 用户组类型（1——功能类型；2——资源类型） */
	private Long groupType;
	/** 系统ID */
	private Long systemId;

	public java.lang.Long getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(java.lang.Long value) {
		this.groupId = value;
	}
	
	public java.lang.String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(java.lang.String value){
		try {
			this.groupName = null==value?null:URLDecoder.decode(value,"UTF-8");
		} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
	}
	
	public java.lang.String getGroupDesc() {
		return this.groupDesc;
	}
	
	public void setGroupDesc(java.lang.String value){
		try {
			this.groupDesc = null==value?null:URLDecoder.decode(value,"UTF-8");
		} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
	}
	
	public Long getParentGroupId() {
		return this.parentGroupId;
	}
	
	public void setParentGroupId(Long value) {
		this.parentGroupId = value;
	}
	
	public Long getLevelId() {
		return this.levelId;
	}
	
	public void setLevelId(Long value) {
		this.levelId = value;
	}
	
	public Long getGroupType() {
		return this.groupType;
	}
	
	public void setGroupType(Long value) {
		this.groupType = value;
	}
	
	public Long getSystemId() {
		return this.systemId;
	}
	
	public void setSystemId(Long value) {
		this.systemId = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

