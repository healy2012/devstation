package cn.emag.system.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.emag.demo.domain.UserInfo;
import cn.emag.system.dao.SystemIbatisDao;
import cn.emag.system.domain.SystemPO;
import cn.emag.system.service.SystemService;

@Service("systemService")
public class SystemServiceImpl implements SystemService {
	@Autowired
	private SystemIbatisDao systemIbatisDao;

	/*
	 *  查询系统信息数目。可根据systemPO携带的参数进行条件查询
	 * @see cn.emag.system.service.SystemService#getSystemCount(cn.emag.system.domain.SystemPO)
	 */
	public int getSystemCount(SystemPO systemPO) {
		if (null == systemPO) {
			systemPO = new SystemPO();
		}

		// 页面条件查询时，若文本框不输入内容，则点击查询按钮将查出所有系统信息数
		if ((null != systemPO.getSystemName())
				&& ("".equals(systemPO.getSystemName().trim()))) {
			systemPO.setSystemName(null);
		}
		return systemIbatisDao.getSystemCount(systemPO);
	}

	/*
	 * 获得所有系统分页数 (non-Javadoc)
	 * 
	 * @see cn.emag.system.service.SystemService#querySystemListByPage(cn.emag.system.domain.SystemPO,
	 *      int, int)
	 */
	public List<SystemPO> querySystemListByPage(SystemPO systemPO,
			int pageNumber, int pageSize) {
		Map params = organizeParams(systemPO);
		return systemIbatisDao.querySystemListByPage(pageNumber, pageSize,
				"SYSTEM_ID", false, params);
	}

	public int deleteSystems(String systemIds) {
		int i = 0;
		// 批量删除
		for (String systemId : systemIds.split(",")) {
			i++;
			systemIbatisDao.deleteSystems(systemId);
		}
		return i;
	}
	/*
	 * 查找系统
	 * @see cn.emag.system.service.SystemService#querySystemBySystemId(cn.emag.system.domain.SystemPO)
	 */
	public List<SystemPO> querySystemBySystemId(SystemPO systemForQuery,String sortByColumn,boolean sortAsc) {
		  // 将systemForQuery组装成map，便于参数扩展
        Map params = organizeParams(systemForQuery);
        // 查看sortByColumn是否为"",即是否要按列排序
        if (StringUtils.isNotBlank(sortByColumn))
        {
            StringBuffer orderByColumnSql = new StringBuffer();
            orderByColumnSql.append(sortByColumn).append(" ");
            if (sortAsc)
            {
                orderByColumnSql.append("ASC");
            }
            else
            {
                orderByColumnSql.append("DESC");
            }
            // orderByColumnSql的值形如："USERID ASC"或"USERID DESC"
            params.put("orderByColumnSql", orderByColumnSql.toString());
        }
        else
        {
            params.put("orderByColumnSql", null);
        }
        return systemIbatisDao.querySystemBySystemId(params);
	}

	@SuppressWarnings("unchecked")
	private Map organizeParams(SystemPO systemPO) {
		if (null == systemPO) {
			systemPO = new SystemPO();
		}

		// 页面条件查询时，若文本框不输入内容，则点击查询按钮将查出所有用户信息数
		if (null != systemPO.getSystemName()
				&& ("".equals(systemPO.getSystemName().trim()))) {
			systemPO.setSystemName(null);
		}

		// 用于存放参数值的容器，用于Ibatis条件查询是取值
		Map params = new HashMap();
		System.out.println(systemPO.getSystemName());
		params.put("systemId", systemPO.getSystemId());
		params.put("systemDesc", systemPO.getSystemDesc());
		params.put("valid", systemPO.getValid());
		params.put("loginUrl", systemPO.getLoginUrl());
		params.put("lastUpdate", systemPO.getLastUpdate());
		if (systemPO.getSystemName() != null) {
			try {
				params.put("systemName", new String(systemPO.getSystemName()
						.getBytes("iso-8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			params.put("systemName", systemPO.getSystemName());
		}

		return params;

	}

	/*
	 * 修改系统信息
	 * @see cn.emag.system.service.SystemService#updateSystemPO(cn.emag.system.domain.SystemPO)
	 */
	public void updateSystemPO(SystemPO systemPO) {
		
	        Map params = new HashMap();
	        
	        params.put("systemId", systemPO.getSystemId());
	        
	        // 根据userId查询得到将被修改的用户信息
	        SystemPO SystemPOForUpdate = systemIbatisDao.querySystemBySystemId(params).get(0);
	        
	        SystemPOForUpdate.setSystemDesc(systemPO.getSystemDesc());
	        
	        SystemPOForUpdate.setLoginUrl(systemPO.getLoginUrl());
	        
	        SystemPOForUpdate.setValid(systemPO.getValid());
	        
	        // 系统信息
	        systemIbatisDao.updateUserInfo(SystemPOForUpdate);
	        
	    
		
	}

	public void saveAddSystem(SystemPO systemPO) {
		systemIbatisDao.saveAddSystem(systemPO);
	}

	

}
