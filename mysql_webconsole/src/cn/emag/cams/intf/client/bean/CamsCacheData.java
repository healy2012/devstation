package cn.emag.cams.intf.client.bean;

import java.util.Map;

import com.emag.cams.intf.atomic.pojo.Resource;

import cn.emag.framework.bean.BaseObj;

public class CamsCacheData extends BaseObj
{
    private Map<String,String> menuUrlMap;
    
    private Map<String,String> permUrlMap;
    
    private Map<String,Resource> resourceMap;
    
    private String systemId;

    public Map<String,String> getMenuUrlMap()
    {
        return menuUrlMap;
    }

    public void setMenuUrlMap(Map<String,String> menuUrlMap)
    {
        this.menuUrlMap = menuUrlMap;
    }

    public Map<String,String> getPermUrlMap()
    {
        return permUrlMap;
    }

    public void setPermUrlMap(Map<String,String> permUrlMap)
    {
        this.permUrlMap = permUrlMap;
    }

    public Map<String, Resource> getResourceMap()
    {
        return resourceMap;
    }

    public void setResourceMap(Map<String, Resource> resourceMap)
    {
        this.resourceMap = resourceMap;
    }

    public String getSystemId()
    {
        return systemId;
    }

    public void setSystemId(String systemId)
    {
        this.systemId = systemId;
    }

}
