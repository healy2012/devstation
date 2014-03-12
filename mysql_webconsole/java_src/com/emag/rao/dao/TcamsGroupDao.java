/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2012
 * template author :raodun
 */

package com.emag.rao.dao;

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


import org.springframework.stereotype.Repository;


@Repository
public class TcamsGroupDao extends BaseIbatisDao<TcamsGroup,java.lang.Long>{
	
	@Override
	public String getIbatisSqlMapNamespace() {
		return "TcamsGroup";
	}
	
	public void saveOrUpdate(TcamsGroup entity) {
		if(entity.getGroupId() == null) 
			save(entity);
		else 
			update(entity);
	}
	
	public Page findPage(TcamsGroupQuery query) {
		return pageQuery("TcamsGroup.findPage",query);
	}
	

}
