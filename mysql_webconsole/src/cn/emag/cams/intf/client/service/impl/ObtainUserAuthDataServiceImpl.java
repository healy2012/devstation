package cn.emag.cams.intf.client.service.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.emag.cams.intf.atomic.pojo.Menu;
import com.emag.cams.intf.atomic.pojo.Perm;
import com.emag.cams.intf.atomic.pojo.Resource;
import com.emag.cams.intf.atomic.pojo.Userinfo;
import com.emag.cams.intf.servces.CamsServicesSoapBindingStub;

import com.emag.cams.intf.servces.request.GetSysAdministratorReq;
import com.emag.cams.intf.servces.request.GetUserMenuReq;
import com.emag.cams.intf.servces.request.GetUserPermReq;
import com.emag.cams.intf.servces.request.GetUserResReq;
import com.emag.cams.intf.servces.response.GetSysAdministratorRsp;
import com.emag.cams.intf.servces.response.GetUserMenuRsp;
import com.emag.cams.intf.servces.response.GetUserPermRsp;
import com.emag.cams.intf.servces.response.GetUserResRsp;

import cn.emag.cams.intf.client.bean.CamsCacheData;
import cn.emag.cams.intf.client.bean.UserDataObject;
import cn.emag.cams.intf.client.service.CamsCacheDataFactory;
import cn.emag.cams.intf.client.service.ObtainUserAuthDataService;
import cn.emag.cams.intf.client.utils.PropertiesReaderUtil;

@Service("obtainUserAuthDataService")
public class ObtainUserAuthDataServiceImpl implements ObtainUserAuthDataService
{
    private UserDataObject userDataObject = new UserDataObject();
   
    private static CamsServicesSoapBindingStub stub  ;
    
    static 
    {
            try {
                PropertiesReaderUtil.init("ClientConfig.properties");
                
                Properties pro = PropertiesReaderUtil.getPro();
                
                String serviceAddress = pro.getProperty("ServiceAddress");
                
                URL url = new URL(serviceAddress);
                
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
    
    public Map<String,String> getUserMenu(String userAccount,String menuType)
    {
            Map<String,String> userMenuMap = new HashMap<String,String>();
      
            CamsCacheData camsCacheData = CamsCacheDataFactory.getInstance().getCamsCacheData();
            
            String systemId = camsCacheData.getSystemId();
            
            GetUserMenuReq getUserMenuReq = new GetUserMenuReq();
            
            getUserMenuReq.setMenu_type(menuType);
            
            getUserMenuReq.setSystem_id(systemId);
            
            getUserMenuReq.setUser_account(userAccount);
            
            GetUserMenuRsp rsp = null;
           
            try 
            {
                rsp = stub.getUserMenu(getUserMenuReq);
            }
            catch (RemoteException e) {
               
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
                     userMenuMap.put(menu.getMenu_auth_string(), menu.getMenu_item_name());
                    }
                  }
                 
               }
   
            }
        
        return userMenuMap;
        
     }
    
    public Map<String,String> getUserPerm(String userAccount,String permType)
    {
            Map<String,String> userPermMap = new HashMap<String,String>();
        
            CamsCacheData camsCacheData = CamsCacheDataFactory.getInstance().getCamsCacheData();
            
            String systemId = camsCacheData.getSystemId();
            
            GetUserPermReq getUserPermReq = new GetUserPermReq();
            
            getUserPermReq.setPerm_type(permType);
            
            getUserPermReq.setSystem_id(systemId);
            
            getUserPermReq.setUser_account(userAccount);
            
            GetUserPermRsp rsp = null;
           
            try
            {
                rsp = stub.getUserPerm(getUserPermReq);
            }
            catch (RemoteException e) 
            {
                e.printStackTrace();
            }
            
            if(null != rsp)
            {
                Perm[] permArr = rsp.getPermList();
              
                if(null != permArr && 0 != permArr.length && "1".equals(permType))
                {
               
                  for(Perm perm : permArr)
                  {
                    if(null != perm )
                    {
                        userPermMap.put(perm.getObj_id()+"@"+perm.getOperation_id(),perm.getPerm_id());
                    }
                  }
                 
               }
               
                if(null != permArr && 0 != permArr.length && "2".equals(permType))
                {
               
                  for(Perm perm : permArr)
                  {
                    if(null != perm )
                    {
                        userPermMap.put(perm.getAuth_url(), perm.getPerm_id());
                    }
                  }
                 
               }
                
   
            }
        
            return userPermMap;
        }
        
     
    
    public Map<String,Resource> getUserRes(String userAccount)
    {
        
            Map<String,Resource> userResMap = new HashMap<String,Resource>();
 
            CamsCacheData camsCacheData = CamsCacheDataFactory.getInstance().getCamsCacheData();
            
            String systemId = camsCacheData.getSystemId();
            
            GetUserResReq getUserResReq = new GetUserResReq();
            
            getUserResReq.setSystem_id(systemId);
            
            getUserResReq.setUser_account(userAccount);
            
            getUserResReq.setRes_auth_string("");
            
            GetUserResRsp rsp = null;
            try 
            {
                rsp = stub.getUserRes(getUserResReq);
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
               
                  for(Resource resource : resArr)
                  {
                    if(null != resource)
                    {
                        userResMap.put(resource.getRes_auth_string(),resource);
                    }
                  }
                 
               }
               
            }
        
        return userResMap;
        
     }
    
    public boolean isSysAdmin(String userAccount)
    {
            CamsCacheData camsCacheData = CamsCacheDataFactory.getInstance().getCamsCacheData();
            
            String systemId = camsCacheData.getSystemId();
            
            GetSysAdministratorReq getSysAdminReq = new GetSysAdministratorReq();
            
            getSysAdminReq.setSystem_id(systemId);
            
            GetSysAdministratorRsp rsp = null;
            try 
            {
                rsp = stub.getSysAdministrator(getSysAdminReq);
            }
            catch (RemoteException e) {
                e.printStackTrace();
            }
            
            if(null != rsp)
            {
               Userinfo[] userArr = rsp.getUserInfoList();
            
               if(null != userArr && userArr.length != 0)
               {  
                for(Userinfo userInfo : userArr)
                {
                   if(null != userInfo && userAccount.equals(userInfo.getUser_account()))
                   {
                       return true;
                   }
                }
               }
            }
   
        return false;
    }
    
    public UserDataObject getUserDataObject(String userAccount)
    {
        
        userDataObject.setUserMenuUrlMap(getUserMenu(userAccount,"1"));
        
        userDataObject.setUserMenuIdMap(getUserMenu(userAccount,"2"));
        
        userDataObject.setSysAdmin(isSysAdmin(userAccount));
        
        userDataObject.setUserPermUrlMap(getUserPerm(userAccount,"2"));
        
        userDataObject.setUserPermObjectMap(getUserPerm(userAccount,"1"));
        
        userDataObject.setUserResourceMap(getUserRes(userAccount));
        
        return userDataObject;
    }
    
    
}
