/**
 * TODO
 * @author Administrator
 * Create on 2011-7-8
 */
package cn.emag.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.emag.system.dao.NavigatorJdbcDao;
import cn.emag.system.domain.Navigator;
import cn.emag.system.service.NavigatorService;

@Service("navigatorService")
public class NavigatorServiceImpl implements NavigatorService {

	@Autowired
	private NavigatorJdbcDao navigatorJdbcDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.emag.system.service.NavigatorService#listDisplayNavigator()
	 */
	public List<Navigator> listDisplayNavigator() 
	{
		
	    return this.navigatorJdbcDao.listDisplayNavigator();
	}

    public void saveNavigator(Navigator navigator)
    {
        
         this.navigatorJdbcDao.saveNavigator(navigator);
        
    }

    public void deleteNavigators(String navIds)
    {
        String[] navIdArr = navIds.split(",");
        
        for(String navId:navIdArr)
        {
            this.navigatorJdbcDao.deleteNavigators(navId);
        }
       
        
    }
    

    public Navigator getNavigator(String navIds)
    {
        String[] navIdArr = navIds.split(",");
        
        return this.navigatorJdbcDao.getNavigator(navIdArr[0]);
       
    }

    public void updateNavigator(Navigator navigator)
    {
        Integer navId = navigator.getNavId();
        
        Navigator navForUpdate = this.navigatorJdbcDao.getNavigator(navId.toString());
        
        navForUpdate.setNavName(navigator.getNavName());
        
        navForUpdate.setNavNote(navigator.getNavNote());
        
        navForUpdate.setNavUrl(navigator.getNavUrl());
        
        navForUpdate.setNavSeq(navigator.getNavSeq());
        
        navForUpdate.setNavStatus(navigator.getNavStatus());
        
        this.navigatorJdbcDao.updateNavigator(navForUpdate);
        
    }

    public List<Navigator> queryNavigatorList()
    {
        return this.navigatorJdbcDao.queryNavigatorList();
    }

    public boolean isNotNavSeqExist(Integer navId, Integer navSeq)
    {
       
        int result = this.navigatorJdbcDao.getSameSeqCount(navId, navSeq);
        
        if(0 == result)
        {
            return true;
        }
        
        return false;
    }

    

}
