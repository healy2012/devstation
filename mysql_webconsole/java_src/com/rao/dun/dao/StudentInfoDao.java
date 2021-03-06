/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.rao.dun.dao;

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


import org.springframework.stereotype.Repository;


@Repository
public class StudentInfoDao extends BaseIbatisDao<StudentInfo,Long>{
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "StudentInfo";
	}
	
	public void saveOrUpdate(StudentInfo entity) {
		if(entity.getStuId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(StudentInfoQuery query) {
		return pageQuery("StudentInfo.findPage",query);
	}
	

}
