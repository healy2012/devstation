/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.emag.rao.action;

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

import com.emag.rao.model.*;
import com.emag.rao.dao.*;
import com.emag.rao.service.*;
import com.emag.rao.vo.query.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class TcamsGroupAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "to_list";
	
	private TcamsGroupManager tcamsGroupManager;
	
	private TcamsGroup tcamsGroup;
	java.lang.Long id = null;
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			tcamsGroup = new TcamsGroup();
		} else {
			tcamsGroup = (TcamsGroup)tcamsGroupManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void setTcamsGroupManager(TcamsGroupManager manager) {
		this.tcamsGroupManager = manager;
	}	
	
	public Object getModel() {
		return tcamsGroup;
	}
	
	public void setGroupId(java.lang.Long val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		TcamsGroupQuery query = newQuery(TcamsGroupQuery.class,DEFAULT_SORT_COLUMNS);
		
		Page page = tcamsGroupManager.findPage(query);
		savePage(page,query);
		return SUCCESS;
	}
	
	/** 查看对象*/
	public String show() {
		tcamsGroup = (TcamsGroup)tcamsGroupManager.getById(tcamsGroup.getGroupId());
		return SUCCESS;
	}
	
	/** 进入新增页面*/
	public String create() {
		return SUCCESS;
	}
	
	/** 保存新增对象 */
	public String save() {
		tcamsGroupManager.save(tcamsGroup);
		return LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		Hashtable params = HttpUtils.parseQueryString(items[0]);
		java.lang.Long id = new java.lang.Long((String)params.get("groupId"));
		tcamsGroup = (TcamsGroup)tcamsGroupManager.getById(id);
		return SUCCESS;
	}
	
	/**保存更新对象*/
	public String update() {
		tcamsGroupManager.update(this.tcamsGroup);
		return LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Long id = new java.lang.Long((String)params.get("groupId"));
			tcamsGroupManager.removeById(id);
		}
		return LIST_ACTION;
	}

}
