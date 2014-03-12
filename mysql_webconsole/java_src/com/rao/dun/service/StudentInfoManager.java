/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.rao.dun.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service
@Transactional
public class StudentInfoManager extends BaseManager<StudentInfo,Long>{

	private StudentInfoDao studentInfoDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setStudentInfoDao(StudentInfoDao dao) {
		this.studentInfoDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.studentInfoDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(StudentInfoQuery query) {
		return studentInfoDao.findPage(query);
	}
	
}
