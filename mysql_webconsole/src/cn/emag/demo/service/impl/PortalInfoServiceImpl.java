package cn.emag.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.emag.demo.dao.PortalInfoDAO;
import cn.emag.demo.domain.UserInfo;
import cn.emag.demo.service.PortalInfoService;

/**
 * 
 * 用户增、删、改、查service层
 * 
 * 主要实现以下功能： 1.增加一个用户 2.用户分页查询，条件查询 3.用户数量查询 4.修改用户 5.删除用户
 * 
 * @author 冯庆媛
 * @version [1.0, Jul 5, 2011]
 * @since 统一平台开发1.0
 */
@Service("portalInfoService")
public class PortalInfoServiceImpl implements PortalInfoService
{
    /**
     * 注入DAO层，与数据库交互
     */
    @Autowired
    private PortalInfoDAO portalInfoDAO;
    
    /**
     * 增加用户操作，向数据中增加userInfo携带的用户信息
     * 
     * @param userInfo 用户信息pojo,该值由action从页面携带进入
     */
    public void saveUserInfo(UserInfo userInfo) {
		portalInfoDAO.saveUserInfo(userInfo);
	}
    
    /**
     * 条件查询用户操作，可根据userInfo携带的参数进行条件查询
     * 
     * @param userInfo 用户信息pojo,该值由action从页面携带进入
     * @param sortByColumn 若查询需要按列排序，则该参数为列名，如“USERID”; 若不需要案例排序，则该参数标示为：""即可
     * @param sortAsc 该值为true,查询按升序排列；为false，查询按降序排列
     * @return List<UserInfo> 用户信息列表
     */
    @SuppressWarnings("unchecked")
    public List<UserInfo> queryUserInfoList(UserInfo userInfo, String sortByColumn, boolean sortAsc)
    {
        
        // 将userInfo组装成map，便于参数扩展
        Map params = organizeParams(userInfo);
        
        // 查看sortByColumn是否为"",即是否要按列排序
        if (StringUtils.isNotBlank(sortByColumn))
        {
            StringBuffer orderByColumnSql = new StringBuffer();
            orderByColumnSql.append(sortByColumn).append(" ");
            if (sortAsc)
            {
                orderByColumnSql.append("ASC");
            }
            else
            {
                orderByColumnSql.append("DESC");
            }
            // orderByColumnSql的值形如："USERID ASC"或"USERID DESC"
            params.put("orderByColumnSql", orderByColumnSql.toString());
        }
        else
        {
            params.put("orderByColumnSql", null);
        }
        
        return portalInfoDAO.queryUserInfoList(params);
    }
    
    /**
     * 实现对用户信息的分页查询，可根据userInfo携带的参数进行条件查询
     * 
     * @param userInfo 用户信息pojo,该值由action从页面携带进入
     * @param pageNumber 当前页数
     * @param pageSize 每页显示“pageSize”条记录
     * @return List<UserInfo> 用户信息查询分页列表
     */
    @SuppressWarnings("unchecked")
    public List<UserInfo> queryUserInfoListByPage(UserInfo userInfo, int pageNumber, int pageSize)
    {
        // 将userInfo组装成map，便于参数扩展
        Map params = organizeParams(userInfo);
        
        // 分页查询
        return portalInfoDAO.queryUserInfoListByPage(pageNumber, pageSize, "USERID", false, params);
    }
    
    /**
     * 查询用户信息数目。可根据userInfo携带的参数进行条件查询
     * 
     * @param userInfo 用户信息pojo,该值由action从页面携带进入
     * @return int 用户信息数
     */
    public int getPortalUserCount(UserInfo userInfo)
    {
        if (null == userInfo)
        {
            userInfo = new UserInfo();
        }
        
        // 页面条件查询时，若文本框不输入内容，则点击查询按钮将查出所有用户信息数
        if ((null != userInfo.getUserName()) && ("".equals(userInfo.getUserName().trim())))
        {
            userInfo.setUserName(null);
        }
        
        return portalInfoDAO.getPortalUserCount(userInfo);
    }
    
    /**
     * 删除一条或多条用户信息
     * 
     * @param userIds 页面选择的用户ID拼接而成的字符串
     */
    public void deleteUserInfos(String userIds)
    {
        // 拆分从页面获得的字符串
        String[] userIdArr = userIds.split(",");
        
        UserInfo userInfo = new UserInfo();
        
        // 批量删除
        for (String userId : userIdArr)
        {
            userInfo.setUserId(userId);
            
            portalInfoDAO.deleteUserInfos(userInfo);
        }
        
    }
    
    /**
     * 修改用户信息
     * 
     * @param userInfo 页面携带的修改值
     */
    @SuppressWarnings("unchecked")
    public void updateUserInfo(UserInfo userInfo)
    {
        
        Map params = new HashMap();
        
        params.put("userId", userInfo.getUserId());
        
        // 根据userId查询得到将被修改的用户信息
        UserInfo userInfoForUpdate = portalInfoDAO.queryUserInfoList(params).get(0);
        
        userInfoForUpdate.setUserName(userInfo.getUserName());
        
        userInfoForUpdate.setPassword(userInfo.getPassword());
        
        userInfoForUpdate.setEmail(userInfo.getEmail());
        
        userInfoForUpdate.setTel(userInfo.getTel());
        
        userInfoForUpdate.setName(userInfo.getName());
        
        // 修改用户信息
        portalInfoDAO.updateUserInfo(userInfoForUpdate);
        
    }
    
    /**
     * 查询用户在数据库中是否存在
     * 
     * @param userInfo 携带用于查询的用户信息
     * @return boolean true:不存在;false:存在
     */
    public boolean isUserExist(UserInfo userInfo)
    {
        
        int count = portalInfoDAO.getPortalUserCount(userInfo);
        
        if (count > 0)
        {
            return false;
        }
        
        return true;
    }
    
    @SuppressWarnings("unchecked")
    private Map organizeParams(UserInfo userInfo)
    {
        if (null == userInfo)
        {
            userInfo = new UserInfo();
        }
        
        // 页面条件查询时，若文本框不输入内容，则点击查询按钮将查出所有用户信息数
        if (null != userInfo.getUserName() && ("".equals(userInfo.getUserName().trim())))
        {
            userInfo.setUserName(null);
        }
        
        // 用于存放参数值的容器，用于Ibatis条件查询是取值
        Map params = new HashMap();
        
        params.put("userId", userInfo.getUserId());
        
        params.put("userName", userInfo.getUserName());
        
        params.put("password", userInfo.getPassword());
        
        params.put("email", userInfo.getEmail());
        
        params.put("tel", userInfo.getTel());
        
        params.put("name", userInfo.getName());
        
        return params;
        
    }
    
}
