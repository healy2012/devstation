/**
 * TODO
 * @author Administrator
 * Create on 2011-7-8
 */
package cn.emag.system.web.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import net.sf.json.JSONObject;
import cn.emag.framework.action.BaseAction;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.system.domain.Navigator;
import cn.emag.system.service.NavigatorService;

@SuppressWarnings("serial")
public class ManageNavigatorAction extends BaseAction {

    private List<Navigator> list;
	
	private Navigator navigator;
	
	private InputStream inputStream;
	
	private String navIds;
	
	private Object obj;
	
	NavigatorService service = (NavigatorService) SpringContextHolder
	    .getService("navigatorService");

	
	public String queryNavigatorList() {

        list = service.queryNavigatorList();
        return SUCCESS;
    }
	
	public String addNavigator()
	{
	    return SUCCESS;
	}
	
	public String createNavigator()
    {
	    service.saveNavigator(navigator);
	    
        return SUCCESS;
    }
	
	public String delNavgators()
    {
        service.deleteNavigators(navIds);
	    
        return SUCCESS;
    }
	
	public String updateNavigator()
	{
	    navigator = service.getNavigator(navIds);
	    
	    return SUCCESS;
	}
	
	public String updateSaveNavigator()
	{
	    service.updateNavigator(navigator);
	    
	    return SUCCESS;
	}
	
	public String remoteValidateSeq()
	{
	    Integer navId = null;
	   
	    if(null != navIds)
	    {
	      navId = Integer.parseInt(navIds);
	       
	    }
	     
	     Integer seq = getIntegerParameter("navigator.navSeq");
	    
	     Boolean flag = service.isNotNavSeqExist(navId,seq);
	    
	     inputStream = new ByteArrayInputStream(flag.toString().getBytes());      
	   
	    return SUCCESS;
	}
	
	public String test()
	{
	    JSONObject json = new JSONObject();
	    
	    JSONObject data = json.getJSONObject("jsonstr");
	    
	    return SUCCESS;
	}
    
	
    public List<Navigator> getList() 
    {
	        return list;
	}

    public void setList(List<Navigator> list) 
    {
	        this.list = list;
	}

    public Navigator getNavigator()
    {
        return navigator;
    }

    public void setNavigator(Navigator navigator)
    {
        this.navigator = navigator;
    }

    public String getNavIds()
    {
        return navIds;
    }

    public void setNavIds(String navIds)
    {
        this.navIds = navIds;
    }
    
    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Object getObj()
    {
        return obj;
    }

    public void setObj(Object obj)
    {
        this.obj = obj;
    }
    

    
}
