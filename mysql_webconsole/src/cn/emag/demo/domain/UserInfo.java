package cn.emag.demo.domain;

/**
 * 用户pojo类，定义用户相关字段
 * @author  冯庆媛
 * @version  [1.0, Jul 5, 2011]
 * @since  统一平台开发1.0
 */
import cn.emag.framework.bean.BaseObj;

/**
 * Portal用户信息
 * 
 */
public class UserInfo extends BaseObj
{
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 用户名称
     */
    private String userName;
    
    /**
     * 用户密码
     */
    private String password;
    
    /**
     * 用户邮箱地址
     */
    private String email;
    
    /**
     * 用户电话
     */
    private String tel;
    
    /**
     * 用户真实姓名
     */
    private String name;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getTel()
    {
        return tel;
    }
    
    public void setTel(String tel)
    {
        this.tel = tel;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}
