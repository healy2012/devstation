/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.emag.rao.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service
@Transactional
public class TcamsGroupManager extends BaseManager<TcamsGroup,java.lang.Long>{

	private TcamsGroupDao tcamsGroupDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setTcamsGroupDao(TcamsGroupDao dao) {
		this.tcamsGroupDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.tcamsGroupDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(TcamsGroupQuery query) {
		return tcamsGroupDao.findPage(query);
	}
	
}
