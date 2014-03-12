package cn.emag.global.service.impl;

import org.springframework.stereotype.Service;

import cn.emag.framework.exception.ServiceException;
import cn.emag.global.service.LoginService;
import cn.emag.global.utils.GlobalUtil;

@Service("loginService")
public class LoginServiceImpl implements LoginService
{

    public String getValidateCode()
    {
     char[] validateChars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
            '5', '6', '7', '8', '9' };
     
     try
    {
        String validateCode =  GlobalUtil.generateValiCode(validateChars, 6);
        
         //调用短信接口发送验证码
         //
         
         return validateCode;
    }
    catch (RuntimeException e)
    {
        throw new ServiceException("系统错误，发送验证码失败");
    }
        
    }
    
}
