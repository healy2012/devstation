/**
 * TODO
 * @author Administrator
 * Create on 2010-8-17
 */
package cn.emag.global.web.ajax;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import cn.emag.framework.action.JsonAction;
import cn.emag.framework.security.ClientSession;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.global.service.LoginService;

public class GlobalAjaxAction extends JsonAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5973191570432426067L;
	
	private LoginService loginService = (LoginService)SpringContextHolder.getService("loginService");

	public void validateUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String validateCode = request.getParameter("smsRandomCode");
		String valCodeInSession = null;
		
		
	    ClientSession clientSession = (ClientSession)getHttpSession().getAttribute("CLIENT_SESSION");
	    
	    if(null != clientSession)
	    {
	       valCodeInSession = (String)clientSession.getAttribute("VALIDATECODE");
	    }
		// UserService service = (UserService) SpringContextHolder
		// .getService("userService");
		// User user = service.getUserByName(username);
		// if (user == null) {
		// throw new IllegalArgumentException("用户名不存在。");
		// } else if (!StringUtils.equals(PasswordUtils.md5Encode(password),
		// user
		// .getPassword())) {
		// throw new IllegalArgumentException("密码不正确。");
		// }
		if (!"admin".equals(username)) {
			throw new IllegalArgumentException("用户名不存在。");
		}
		if (!"9125a8403e31aeefeb6e93eb6e23a7bf".equals(getMd5(password))) {
			throw new IllegalArgumentException("密码不正确。");
		}
	      if(!validateCode.equals(valCodeInSession))
        {
	        throw new IllegalArgumentException("输入的短信验证码不正确");
	    }
		
		JSONObject json = new JSONObject();
		json.put("result", 1);
		serializer(json);
	}
	
	public static void main(String[] args){
	    System.out.println(GlobalAjaxAction.getMd5(""));
	}
	
	public final static String getMd5(String str) {
        MessageDigest mdInst = null;
        try {
            mdInst = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        mdInst.update(str.getBytes());// 使用指定的字节更新摘要
        byte[] md = mdInst.digest();// 获得密文
        return byteArrToHexStr(md);
    }
	
	public static String byteArrToHexStr(byte[] arrB) {
        int iLen = arrB.length;
        // 每个byte(8位)用两个(16进制)字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            while (intTmp < 0) {// 把负数转换为正数
                intTmp = intTmp + 256;
            }
            if (intTmp < 16) {// 小于0F的数需要在前面补0
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }
	
	
	/**
	 * 点击页面的"点击或得验证码按钮"进入此方法,构造随机验证码，并发送短信
	 * @param request 请求对象，该方法不带任何参数进入
	 * @param response 响应对象
	 * @throws Exception
	 */
	public void sendValidateCode(HttpServletRequest request,
            HttpServletResponse response)throws Exception 
     {
	       
	        //获得验证码并发送短信
            String validateCode = loginService.getValidateCode();
            
            ClientSession clientSession = new ClientSession();
            
            clientSession.addAttribute("VALIDATECODE", validateCode);
            
            getHttpSession().setAttribute("CLIENT_SESSION", clientSession);
            
	        JSONObject json = new JSONObject();
	        
	        json.put("result", "success:" + validateCode);
	    
	        serializer(json);
	    
	    
      }
}
