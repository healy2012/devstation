package cn.emag.demo.service;

import java.util.List;

import cn.emag.demo.domain.UserInfo;

public interface PortalInfoService 
{
    void saveUserInfo(UserInfo userInfo);
    
    List<UserInfo> queryUserInfoList(UserInfo userInfo,String sortByColumn,boolean sortAsc);
    
    List<UserInfo> queryUserInfoListByPage(UserInfo userInfo,int pageNumber,int pageSize);
    
    int getPortalUserCount(UserInfo userInfo);
    
    void deleteUserInfos(String userIds);
    
    void updateUserInfo(UserInfo userInfo);
    
    boolean isUserExist(UserInfo userInfo);
}
