package cn.emag.cams.intf.client.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.emag.cams.intf.servces.CamsServicesSoapBindingStub;

import com.emag.cams.intf.servces.request.GetSysMenuReq;
import com.emag.cams.intf.servces.request.GetSysPermReq;
import com.emag.cams.intf.servces.request.GetSysResReq;
import com.emag.cams.intf.servces.response.GetSysMenuRsp;
import com.emag.cams.intf.servces.response.GetSysPermRsp;
import com.emag.cams.intf.servces.response.GetSysResRsp;
import com.emag.cams.intf.atomic.pojo.Menu;
import com.emag.cams.intf.atomic.pojo.Perm;
import com.emag.cams.intf.atomic.pojo.Resource;

import cn.emag.cams.intf.client.bean.CamsCacheData;
import cn.emag.cams.intf.client.utils.PropertiesReaderUtil;


public class CamsCacheDataFactory
{
    private CamsCacheData cacheData = new CamsCacheData();
    
    private static CamsServicesSoapBindingStub stub ;
    
    private CamsCacheDataFactory()
    {
        
    }
    static class SingletonHolder 
    {
        static CamsCacheDataFactory instance = new CamsCacheDataFactory();
    }
    
    public static CamsCacheDataFactory getInstance() 
    {
        return SingletonHolder.instance;
    }
    
   static
   {
           Properties pro = PropertiesReaderUtil.getPro();
           
           String serviceAddress = pro.getProperty("ServiceAddress");
           
           try 
           {               
               URL url = new URL(serviceAddress);
               
               System.out.println("serviceAddress:"+serviceAddress);
               
               stub = new CamsServicesSoapBindingStub(url,null);
               
               stub.setTimeout(10*1000);
           }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (Exception e) 
            {
                 e.printStackTrace();
            }
      
   }
    
    private Map<String,String> getUrlTypeMenus(String systemId)
    {
            Map<String,String> urlTypeMenus = new HashMap<String,String>();
       
            GetSysMenuReq getSysMenuReq = new GetSysMenuReq();
            
            //查询菜单类型为url地址方式
            getSysMenuReq.setMenu_type("1");
            
            getSysMenuReq.setSystem_id(systemId);
            
            GetSysMenuRsp rsp = null;
            try
            {
                rsp = stub.getSysMenu(getSysMenuReq);
            }
            catch (RemoteException e)
            {
                e.printStackTrace();
            }
      
            if(null != rsp)
            {
               Menu[] menuArr = rsp.getMenuList();
            
               if(null != menuArr && 0 != menuArr.length)
               {
            
                 for(Menu menu : menuArr)
                 {
                    if(null != menu)
                    {
                     urlTypeMenus.put(menu.getMenu_auth_string(), menu.getMenu_item_name());
                    }
                 }
                 
               }
            }
        
        return urlTypeMenus;
      }
    
    private Map<String,String> getUrlTypePerms(String systemId)
    {
            Map<String,String> urlTypePerms = new HashMap<String,String>();
       
            GetSysPermReq getSysPermReq = new GetSysPermReq();
            
            //查询权限类型为url地址方式
            getSysPermReq.setPerm_type("2");
            
            getSysPermReq.setSystem_id(systemId);
            
            GetSysPermRsp rsp = null;
            try 
            {
                rsp = stub.getSysPerm(getSysPermReq);
            }
            catch (RemoteException e)
            {
                e.printStackTrace();
            }
            
            if(null != rsp)
            {
               Perm[] permArr = rsp.getPermList();
            
               if(null != permArr && 0 != permArr.length)
               {
            
                 for(Perm perm : permArr)
                 {
                    if(null != perm)
                    {
                     urlTypePerms.put(perm.getAuth_url(), perm.getPerm_id());
                    }
                 }
                 
               }
            }
        
        return urlTypePerms;
      }
    
    private Map<String,Resource> getResources(String systemId)
    {
            Map<String,Resource> resourceMap = new HashMap<String,Resource>();
       
            GetSysResReq getSysResReq = new GetSysResReq();
            
            //查询系统所有资源
            getSysResReq.setSystem_id(systemId);
            
            getSysResReq.setRes_auth_string("");
            
            GetSysResRsp rsp = null;
            try 
            {
                rsp = stub.getSysRes(getSysResReq);
            }
            catch (RemoteException e) 
            {
                e.printStackTrace();
            }
            
            if(null != rsp)
            {
               Resource[] resArr = rsp.getResourceList();
            
               if(null != resArr && 0 != resArr.length)
               {
            
                 for(Resource res : resArr)
                 {
                    if(null != res)
                    {
                        resourceMap.put(res.getRes_auth_string(),res);
                    }
                 }
                 
               }
            }
        
        return resourceMap;
      }
    
    
       public void init(String systemId)
       {
           cacheData.setMenuUrlMap(getUrlTypeMenus(systemId));
           
           cacheData.setSystemId(systemId);
           
           cacheData.setPermUrlMap(getUrlTypePerms(systemId));
           
           cacheData.setResourceMap(getResources(systemId));
           
       }
       
       public CamsCacheData getCamsCacheData()
       {
           return cacheData;
       }
}
