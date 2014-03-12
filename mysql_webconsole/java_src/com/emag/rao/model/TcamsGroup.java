/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.emag.rao.model;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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


public class TcamsGroup extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "用户组信息";
	public static final String ALIAS_GROUP_ID = "用户组ID";
	public static final String ALIAS_GROUP_NAME = "用户组名称";
	public static final String ALIAS_GROUP_DESC = "用户组描述";
	public static final String ALIAS_PARENT_GROUP_ID = "用户组父ID（-1表示无父节点）";
	public static final String ALIAS_LEVEL_ID = "层级（1表示顶级，2表示第二级）";
	public static final String ALIAS_GROUP_TYPE = "用户组类型（1——功能类型；2——资源类型）";
	public static final String ALIAS_SYSTEM_ID = "系统ID";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 用户组ID       db_column: GROUP_ID 
     */ 	
	
	private java.lang.Long groupId;
    /**
     * 用户组名称       db_column: GROUP_NAME 
     */ 	
	@NotBlank @Length(max=255)
	private java.lang.String groupName;
    /**
     * 用户组描述       db_column: GROUP_DESC 
     */ 	
	@Length(max=255)
	private java.lang.String groupDesc;
    /**
     * 用户组父ID（-1表示无父节点）       db_column: PARENT_GROUP_ID 
     */ 	
	@NotNull 
	private Long parentGroupId;
    /**
     * 层级（1表示顶级，2表示第二级）       db_column: LEVEL_ID 
     */ 	
	@NotNull 
	private Long levelId;
    /**
     * 用户组类型（1——功能类型；2——资源类型）       db_column: GROUP_TYPE 
     */ 	
	@NotNull 
	private Long groupType;
    /**
     * 系统ID       db_column: SYSTEM_ID 
     */ 	
	@NotNull 
	private Long systemId;
	//columns END

	public TcamsGroup(){
	}

	public TcamsGroup(
		java.lang.Long groupId
	){
		this.groupId = groupId;
	}

	public void setGroupId(java.lang.Long value) {
		this.groupId = value;
	}
	
	public java.lang.Long getGroupId() {
		return this.groupId;
	}
	public void setGroupName(java.lang.String value) {
		this.groupName = value;
	}
	
	public java.lang.String getGroupName() {
		return this.groupName;
	}
	public void setGroupDesc(java.lang.String value) {
		this.groupDesc = value;
	}
	
	public java.lang.String getGroupDesc() {
		return this.groupDesc;
	}
	public void setParentGroupId(Long value) {
		this.parentGroupId = value;
	}
	
	public Long getParentGroupId() {
		return this.parentGroupId;
	}
	public void setLevelId(Long value) {
		this.levelId = value;
	}
	
	public Long getLevelId() {
		return this.levelId;
	}
	public void setGroupType(Long value) {
		this.groupType = value;
	}
	
	public Long getGroupType() {
		return this.groupType;
	}
	public void setSystemId(Long value) {
		this.systemId = value;
	}
	
	public Long getSystemId() {
		return this.systemId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("GroupId",getGroupId())
			.append("GroupName",getGroupName())
			.append("GroupDesc",getGroupDesc())
			.append("ParentGroupId",getParentGroupId())
			.append("LevelId",getLevelId())
			.append("GroupType",getGroupType())
			.append("SystemId",getSystemId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getGroupId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TcamsGroup == false) return false;
		if(this == obj) return true;
		TcamsGroup other = (TcamsGroup)obj;
		return new EqualsBuilder()
			.append(getGroupId(),other.getGroupId())
			.isEquals();
	}
}

