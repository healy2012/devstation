package cn.emag.cams.intf.client.filter;

import java.io.IOException;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.emag.cams.intf.client.bean.CamsCacheData;
import cn.emag.cams.intf.client.bean.UserDataObject;
import cn.emag.cams.intf.client.service.CamsCacheDataFactory;
import cn.emag.framework.security.ClientSession;

public class AuthorizedFilter implements Filter {

    private String serverURL;
    
    private String unAuthorizedURL;
    
    private String authMenuUrl;
    
    private String authPermUrl;
    
    private String cancelSysAdminAuth;

    public static final String ORIGINAL_SERVLET_PATH = "ORIGINAL_SERVLET_PATH";

    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        String path = (String) request.getAttribute(ORIGINAL_SERVLET_PATH);
        if (path == null) {
            request.setAttribute(ORIGINAL_SERVLET_PATH, request
                    .getServletPath());
        }
        HttpSession session = request.getSession(false);
        
        ClientSession cs = null;
     
        
        if(null == session || ("0".equals(authMenuUrl) && "0".equals(authPermUrl)))
        {
            chain.doFilter(request, response);
            return;
        }
        else
        {
            cs = (ClientSession) session.getAttribute("CLIENT_SESSION");
            
            if ((cs != null && cs.isLogined())) 
            {
              
                CamsCacheData cacheData = CamsCacheDataFactory.getInstance().getCamsCacheData();
                
                UserDataObject userDataObject = (UserDataObject)cs.getAttribute("userDataObject");
                
                //若为sysadmin,默认不需要鉴权
                if(userDataObject.isSysAdmin() && ("0".equals(cancelSysAdminAuth) || null == cancelSysAdminAuth))
                {
                    chain.doFilter(request, response);
                    
                    return;
                }
                
                boolean isAuthMenuUrlPass = false;
                
                boolean isAuthPerUrlPass = false;
                
                //当authMenuUrl初始化为1时，表示菜单url需要鉴权
                if("1".equals(authMenuUrl))
                {
                   String urlPath = request.getAttribute(ORIGINAL_SERVLET_PATH).toString();
                
                   Map<String,String> menuUrlMap = cacheData.getMenuUrlMap();
                
                   Map<String,String> userMenuUrlMap = userDataObject.getUserMenuUrlMap();
                
                   isAuthMenuUrlPass = authPass(urlPath,menuUrlMap,userMenuUrlMap);
                       
               }
                
               if("1".equals(authPermUrl))
                {
                   String urlPath = request.getAttribute(ORIGINAL_SERVLET_PATH).toString();
                
                   Map<String,String> permUrlMap = cacheData.getPermUrlMap();
                
                   Map<String,String> userPermUrlMap = userDataObject.getUserPermUrlMap();
                
                   isAuthPerUrlPass = authPass(urlPath,permUrlMap,userPermUrlMap);
                   
                 }
              
               if(isAuthMenuUrlPass && isAuthPerUrlPass)
               {
                   chain.doFilter(request, response);
                   return;  
               }
               else
               {
                   showUnAuthorizedPage(request, response); 
                   return;
               }
            }
            else
            {
                chain.doFilter(request, response);
                return;
            }
          
        }
        
    }

    public void init(FilterConfig config) throws ServletException {
        unAuthorizedURL = config.getInitParameter("unAuthorizedURL");
        
        authPermUrl = config.getInitParameter("authPermUrl");
        
        authMenuUrl = config.getInitParameter("authMenuUrl");
        
        cancelSysAdminAuth = config.getInitParameter("cancelSysAdminAuth");
        
        
    }
    
    private void showUnAuthorizedPage(HttpServletRequest req, HttpServletResponse res)
    throws IOException 
     {
        String destination = null;
        serverURL = req.getScheme() + "://" + req.getServerName() + ":"
        + req.getServerPort() + req.getContextPath();
        destination = serverURL + unAuthorizedURL;
        res.sendRedirect(destination);
     }
    
    private boolean authPass(String urlPath, Map<String,String> sysUrlMap,Map<String,String> userUrlMap)
    {
        boolean flag = false;
        
       if(null == sysUrlMap.get(urlPath))
       {
           flag = true;
       }
       
       if(null != sysUrlMap.get(urlPath) && null != userUrlMap.get(urlPath))
       {
           flag = true;
       }
       
       return flag;
       
    }
    
    
}
