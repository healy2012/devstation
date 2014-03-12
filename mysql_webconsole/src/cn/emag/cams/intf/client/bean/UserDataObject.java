package cn.emag.cams.intf.client.bean;

import java.io.Serializable;
import java.util.Map;

import com.emag.cams.intf.atomic.pojo.Resource;

import cn.emag.framework.bean.BaseObj;

public class UserDataObject extends BaseObj implements Serializable
{
    private Map<String,String> userMenuUrlMap;
    
    private Map<String,String> userMenuIdMap;
    
    private Map<String,String> userPermUrlMap;
    
    private Map<String,String> userPermObjectMap;
    
    private Map<String,Resource> userResourceMap;
    
    private boolean isSysAdmin;
    
    private int systemId;

    public Map<String,String> getUserMenuUrlMap()
    {
        return userMenuUrlMap;
    }

    public void setUserMenuUrlMap(Map<String,String> userMenuUrlMap)
    {
        this.userMenuUrlMap = userMenuUrlMap;
    }

    public Map<String,String> getUserMenuIdMap()
    {
        return userMenuIdMap;
    }

    public void setUserMenuIdMap(Map<String,String> userMenuIdMap)
    {
        this.userMenuIdMap = userMenuIdMap;
    }

    public Map<String,String> getUserPermUrlMap()
    {
        return userPermUrlMap;
    }

    public void setUserPermUrlMap(Map<String,String> userPermUrlMap)
    {
        this.userPermUrlMap = userPermUrlMap;
    }

    public Map<String,String> getUserPermObjectMap()
    {
        return userPermObjectMap;
    }

    public void setUserPermObjectMap(Map<String,String> userPermObjectMap)
    {
        this.userPermObjectMap = userPermObjectMap;
    }

    public Map<String, Resource> getUserResourceMap()
    {
        return userResourceMap;
    }

    public void setUserResourceMap(Map<String, Resource> userResourceMap)
    {
        this.userResourceMap = userResourceMap;
    }

    public boolean isSysAdmin()
    {
        return isSysAdmin;
    }

    public void setSysAdmin(boolean isSysAdmin)
    {
        this.isSysAdmin = isSysAdmin;
    }

    public int getSystemId()
    {
        return systemId;
    }

    public void setSystemId(int systemId)
    {
        this.systemId = systemId;
    }
    
    
    
    
}
