package cn.emag.cams.intf.client.service;

import java.util.Map;

import cn.emag.cams.intf.client.bean.UserDataObject;


public interface ObtainUserAuthDataService 
{
    Map<String,String> getUserMenu(String userAccount,String menuType);
    
    UserDataObject getUserDataObject(String userAccount);
    
}
