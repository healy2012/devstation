/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.rao.dun.model;

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

import com.rao.dun.model.*;
import com.rao.dun.dao.*;
import com.rao.dun.service.*;
import com.rao.dun.vo.query.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class StudentInfo extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "StudentInfo";
	public static final String ALIAS_STU_ID = "stuId";
	public static final String ALIAS_STUNAME = "stuname";
	public static final String ALIAS_PASSWORD = "password";
	public static final String ALIAS_BIRTH_DATE = "birthDate";
	public static final String ALIAS_SEX = "sex";
	public static final String ALIAS_AGE = "age";
	
	//date formats
	public static final String FORMAT_BIRTH_DATE = DATE_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * stuId       db_column: STU_ID 
     */ 	
	
	private Long stuId;
    /**
     * stuname       db_column: STUNAME 
     */ 	
	@NotBlank @Length(max=50)
	private java.lang.String stuname;
    /**
     * password       db_column: PASSWORD 
     */ 	
	@Length(max=50)
	private java.lang.String password;
    /**
     * birthDate       db_column: BIRTH_DATE 
     */ 	
	
	private java.util.Date birthDate;
    /**
     * sex       db_column: SEX 
     */ 	
	
	private Long sex;
    /**
     * age       db_column: AGE 
     */ 	
	
	private Long age;
	//columns END

	public StudentInfo(){
	}

	public StudentInfo(
		Long stuId
	){
		this.stuId = stuId;
	}

	public void setStuId(Long value) {
		this.stuId = value;
	}
	
	public Long getStuId() {
		return this.stuId;
	}
	public void setStuname(java.lang.String value) {
		this.stuname = value;
	}
	
	public java.lang.String getStuname() {
		return this.stuname;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	public String getBirthDateString() {
		return DateConvertUtils.format(getBirthDate(), FORMAT_BIRTH_DATE);
	}
	public void setBirthDateString(String value) {
		setBirthDate(DateConvertUtils.parse(value, FORMAT_BIRTH_DATE,java.util.Date.class));
	}
	
	public void setBirthDate(java.util.Date value) {
		this.birthDate = value;
	}
	
	public java.util.Date getBirthDate() {
		return this.birthDate;
	}
	public void setSex(Long value) {
		this.sex = value;
	}
	
	public Long getSex() {
		return this.sex;
	}
	public void setAge(Long value) {
		this.age = value;
	}
	
	public Long getAge() {
		return this.age;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StuId",getStuId())
			.append("Stuname",getStuname())
			.append("Password",getPassword())
			.append("BirthDate",getBirthDate())
			.append("Sex",getSex())
			.append("Age",getAge())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStuId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StudentInfo == false) return false;
		if(this == obj) return true;
		StudentInfo other = (StudentInfo)obj;
		return new EqualsBuilder()
			.append(getStuId(),other.getStuId())
			.isEquals();
	}
}

