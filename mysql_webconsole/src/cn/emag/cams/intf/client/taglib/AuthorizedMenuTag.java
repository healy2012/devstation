package cn.emag.cams.intf.client.taglib;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import cn.emag.cams.intf.client.bean.UserDataObject;
import cn.emag.framework.security.ClientSession;

public class AuthorizedMenuTag extends BodyTagSupport 
{

    private static final long serialVersionUID = 7131936980129306012L;

    protected String identifier;
    
    protected String cancelSysAdminAuth;

    public int doEndTag() throws JspException 
    {
        BodyContent bc = getBodyContent();
        
        if(null == bc)
        {
            return Tag.EVAL_PAGE;
        }
       
        boolean flag = isShowBodyContent();
       
        try
        {
            if(!flag)
            {
               bc.getEnclosingWriter().write("");
            }
            else
            {
                String bodyContent = bc.getString();
               
                if(null != bodyContent)
                {
                    bc.getEnclosingWriter().write(bodyContent);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       
        return Tag.EVAL_PAGE;

    }
    
    private boolean isShowBodyContent()
    {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        
        HttpSession session = request.getSession(false);
        
        ClientSession cs = null;
        
        if(null != session)
        {
            cs = (ClientSession) session.getAttribute("CLIENT_SESSION");
            
            if(null != cs)
            {
                UserDataObject userDataObject = (UserDataObject)cs.getAttribute("userDataObject");
                
                boolean isSysAdmin = userDataObject.isSysAdmin();
                
                if(isSysAdmin && (null == cancelSysAdminAuth || "NO".equals(cancelSysAdminAuth)))
                {
                    return true;
                }
                
                Map<String,String> userMenuIdMap = userDataObject.getUserMenuIdMap();
                
                if(null != userMenuIdMap.get(identifier))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
   

    public String getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier(String identifier)
    {
        this.identifier = identifier;
    }

    public String getCancelSysAdminAuth()
    {
        return cancelSysAdminAuth;
    }

    public void setCancelSysAdminAuth(String cancelSysAdminAuth)
    {
        this.cancelSysAdminAuth = cancelSysAdminAuth;
    }

    

    

   
    
    
    
}
