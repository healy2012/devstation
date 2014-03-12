/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
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
public class UserInfoDao extends BaseIbatisDao<UserInfo,Long>{
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "UserInfo";
	}
	
	public void saveOrUpdate(UserInfo entity) {
		if(entity.getUserId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(UserInfoQuery query) {
		return pageQuery("UserInfo.findPage",query);
	}
	

}
