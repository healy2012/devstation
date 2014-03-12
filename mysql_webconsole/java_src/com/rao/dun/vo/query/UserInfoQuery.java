/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 */

package com.rao.dun.vo.query;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.rao.dun.model.*;
import com.rao.dun.dao.*;
import com.rao.dun.service.*;
import com.rao.dun.vo.query.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class UserInfoQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** userId */
	private Long userId;
	/** username */
	private java.lang.String username;
	/** password */
	private java.lang.String password;
	/** birthDate */
	private java.util.Date birthDateBegin;
	private java.util.Date birthDateEnd;
	/** sex */
	private Long sex;
	/** age */
	private Long age;

	public Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(Long value) {
		this.userId = value;
	}
	
	public java.lang.String getUsername() {
		return this.username;
	}
	
	public void setUsername(java.lang.String value) {
		this.username = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.util.Date getBirthDateBegin() {
		return this.birthDateBegin;
	}
	
	public void setBirthDateBegin(java.util.Date value) {
		this.birthDateBegin = value;
	}	
	
	public java.util.Date getBirthDateEnd() {
		return this.birthDateEnd;
	}
	
	public void setBirthDateEnd(java.util.Date value) {
		this.birthDateEnd = value;
	}
	
	public Long getSex() {
		return this.sex;
	}
	
	public void setSex(Long value) {
		this.sex = value;
	}
	
	public Long getAge() {
		return this.age;
	}
	
	public void setAge(Long value) {
		this.age = value;
	}
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

