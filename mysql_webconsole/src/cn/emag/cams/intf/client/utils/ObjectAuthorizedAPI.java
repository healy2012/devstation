package cn.emag.cams.intf.client.utils;

import java.util.HashMap;
import java.util.Map;

import com.emag.cams.intf.atomic.pojo.Resource;
import cn.emag.cams.intf.client.bean.CamsCacheData;
import cn.emag.cams.intf.client.bean.UserDataObject;
import cn.emag.cams.intf.client.service.CamsCacheDataFactory;
import cn.emag.framework.security.ClientSession;
import cn.emag.framework.security.ClientSessionHolder;


public class ObjectAuthorizedAPI
{
    public static boolean isExistMenuObject(String identifier,boolean isCancelAdminAuth)
    {
       ClientSession clientSession = ClientSessionHolder.getClientSession();
       
       UserDataObject dataObject = (UserDataObject)clientSession.getAttribute("userDataObject");
        
        if(null != dataObject)
        {
            boolean isSysAdmin = dataObject.isSysAdmin();
            
            if(isSysAdmin && !isCancelAdminAuth)
            {
                return true;
            }
            
            Map<String,String> userMenuIdMap = dataObject.getUserMenuIdMap();
            
            if(null != userMenuIdMap.get(identifier))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean isExistPermObject(String identifier,String operationId,boolean isCancelAdminAuth)
    {
        ClientSession clientSession = ClientSessionHolder.getClientSession();
        
        UserDataObject dataObject = (UserDataObject)clientSession.getAttribute("userDataObject");
        
        if(null != dataObject)
        {
            boolean isSysAdmin = dataObject.isSysAdmin();
            
            if(isSysAdmin && !isCancelAdminAuth)
            {
                return true;
            }
            
            Map<String,String> userPermObjectMap = dataObject.getUserPermObjectMap();
            
            StringBuffer strBuffer = new StringBuffer();
            
            strBuffer.append(identifier);
           
            strBuffer.append("@");
            
            strBuffer.append(operationId);
            
            String key = strBuffer.toString();
           
            if(null != userPermObjectMap.get(key))
            {
                return true;
            }
           
        }
       
        return false;
    }
    
    public static Map<String,Resource> getResObjects(String resAuthStr,boolean isCancelAdminAuth)
    {
        CamsCacheData camsCacheData = CamsCacheDataFactory.getInstance().getCamsCacheData();
        
        ClientSession clientSession = ClientSessionHolder.getClientSession();
        
        UserDataObject dataObject = (UserDataObject)clientSession.getAttribute("userDataObject");
        
        Map<String,Resource> userResForResStyle = new HashMap<String,Resource>();
        
        if(null != dataObject && null != camsCacheData)
        {
            Map<String,Resource> sysResMap = camsCacheData.getResourceMap();
            
            boolean isSysAdmin = dataObject.isSysAdmin();
            
            //如果是系统管理员，且权限不取消，返回该鉴权标识下所有的资源
            if(isSysAdmin && !isCancelAdminAuth)
            {
               if(null != sysResMap.get(resAuthStr))
               {
                   Resource parentRes = sysResMap.get(resAuthStr);
                   
                   String parentResId = parentRes.getRes_id();
                   
                   for(Map.Entry<String, Resource> sysResEntry: sysResMap.entrySet())
                   {  
                       Resource resource = sysResEntry.getValue();
                       
                       if(null != resource)
                       {
                           String resParentId = resource.getParent_id();
                           
                           String resId = resource.getRes_id();
                           
                           String currentResAuthStr = resource.getRes_auth_string();
                           
                           if(parentResId.equals(resParentId))
                           {
                               userResForResStyle.put(currentResAuthStr, resource);
                               
                               getResForAdmin(sysResMap,resId,userResForResStyle);
                           }
                       }
                   }
                   
               }
                
                return userResForResStyle;
            }
            
            //若不是系统管理员，或者系统管理员权限被取消
            Map<String,Resource> userResMap = dataObject.getUserResourceMap();
            
            //看该用户是否拥有父节点鉴权标识
            if(null != userResMap.get(resAuthStr))
            {
                Resource parentRes = userResMap.get(resAuthStr);
                
                //给定鉴权标识节点的节点ID
                String parentResId = parentRes.getRes_id();
                
                //循环系统资源，找出父节点res_auth_string的所有子节点
                for(Map.Entry<String, Resource> sysResEntry: sysResMap.entrySet())
                {  
                    Resource res = sysResEntry.getValue();
                    
                    if(null != res)
                    {
                        String resParentId = res.getParent_id();
                        
                        String resId = res.getRes_id();
                        
                        String childResAuthStr = res.getRes_auth_string();
                        
                        //系统中直接父节点为parentResId的节点
                        if(null != userResMap.get(childResAuthStr) && resParentId.equals(parentResId))
                        {
                            userResForResStyle.put(res.getRes_auth_string(), res);
                            //递归循环，查询出该节点（resParentId的所有子节点）
                           getChildrenMap(sysResMap,userResMap,resId,userResForResStyle);
                        }
                        
                    }
                
                } 

            }

        }
       
        return userResForResStyle;
    }
    
    private  static void getChildrenMap(Map<String,Resource> sysResMap,Map<String,Resource> userResMap,String resId,Map<String,Resource> userResForResStyle)
    {
        for(Map.Entry<String, Resource> sysResEntry: sysResMap.entrySet())
        {  
            Resource res = sysResEntry.getValue();
            
            if(null != res && resId.equals(res.getParent_id()) && null != userResMap.get(res.getRes_auth_string()))
            {
                userResForResStyle.put(res.getRes_auth_string(), res);
                
                getChildrenMap(sysResMap,userResMap,res.getRes_id(),userResForResStyle);
            }
            
        }
      
    }
    
    private static void getResForAdmin(Map<String,Resource> sysResMap,String resId,Map<String,Resource> userResForResStyle)
    {
        for(Map.Entry<String, Resource> sysResEntry: sysResMap.entrySet())
        {  
            Resource res = sysResEntry.getValue();
            
            if(null != res && resId.equals(res.getParent_id()))
            {
                userResForResStyle.put(res.getRes_auth_string(), res);
                
                getResForAdmin(sysResMap,res.getRes_id(),userResForResStyle);
            }
            
        }
    }
    
}
