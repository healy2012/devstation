/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.rao.dun.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.org.rapid_framework.beanutils.BeanUtils;
import cn.org.rapid_framework.web.scope.Flash;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

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


public class StudentInfoAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "to_list";
	
	private StudentInfoManager studentInfoManager;
	
	private StudentInfo studentInfo;
	Long id = null;
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			studentInfo = new StudentInfo();
		} else {
			studentInfo = (StudentInfo)studentInfoManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void setStudentInfoManager(StudentInfoManager manager) {
		this.studentInfoManager = manager;
	}	
	
	public Object getModel() {
		return studentInfo;
	}
	
	public void setStuId(Long val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		StudentInfoQuery query = newQuery(StudentInfoQuery.class,DEFAULT_SORT_COLUMNS);
		
		Page page = studentInfoManager.findPage(query);
		savePage(page,query);
		return SUCCESS;
	}
	
	/** 查看对象*/
	public String show() {
		return SUCCESS;
	}
	
	/** 进入新增页面*/
	public String create() {
		return SUCCESS;
	}
	
	/** 保存新增对象 */
	public String save() {
		studentInfoManager.save(studentInfo);
		return LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		Hashtable params = HttpUtils.parseQueryString(items[0]);
		Long id = new Long((String)params.get("stuId"));
		studentInfo = (StudentInfo)studentInfoManager.getById(id);
		return SUCCESS;
	}
	
	/**保存更新对象*/
	public String update() {
		studentInfoManager.update(this.studentInfo);
		return LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			Long id = new Long((String)params.get("stuId"));
			studentInfoManager.removeById(id);
		}
		return LIST_ACTION;
	}

}
