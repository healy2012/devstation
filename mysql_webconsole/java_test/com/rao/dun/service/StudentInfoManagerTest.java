/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.rao.dun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import cn.org.rapid_framework.test.context.TestMethodContext;
import static junit.framework.Assert.*;

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


public class StudentInfoManagerTest extends BaseManagerTestCase{

	private StudentInfoManager manager;
	
	@Autowired
	public void setStudentInfoManager(StudentInfoManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/StudentInfo.xml",
                            "classpath:testdata/StudentInfo_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		StudentInfo obj = newStudentInfo();
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getStuId());
		
		manager.removeById(obj.getStuId());
		manager.getEntityDao().flush();
	
	}
	
	public static StudentInfo newStudentInfo() {
		StudentInfo obj = new StudentInfo();
		
	  	obj.setStuname(new java.lang.String("1"));
	  	obj.setPassword(new java.lang.String("1"));
	  	obj.setBirthDate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setSex(new Long("1"));
	  	obj.setAge(new Long("1"));
		return obj;
	}
}
