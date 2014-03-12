//package cn.emag.demo.test;
//
//
//import java.util.List;
//
//import junit.framework.Assert;
//import cn.emag.demo.domain.UserInfo;
//import cn.emag.demo.service.PortalInfoService;
//import cn.emag.framework.spring.SpringContextHolder;
//import cn.emag.framework.test.BaseTestCase;
//
//
//public class PortalInfoServiceImplTest  extends BaseTestCase 
//{
//	private String user;
  
//	public void testSaveUserInfo() 
//	{
//		try {
//			PortalInfoService userService = (PortalInfoService) SpringContextHolder
//					.getService("portalInfoService");
//			UserInfo userInfo = new UserInfo();
//			userInfo.setUserName("Nicole1");
//			userInfo.setPassword("nicole111");
//			userInfo.setTel("123457");
//			userInfo.setName("0");
//			
//			userService.saveUserInfo(userInfo);
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void testQueryUserInfoList()
//	{
//		PortalInfoService userService = (PortalInfoService) SpringContextHolder
//		.getService("portalInfoService");
//       
//		List<UserInfo> userInfoList = userService.queryUserInfoList(null, "", false);
//        
//        for(UserInfo userInfo1:userInfoList)
//        {
//        	System.out.println(userInfo1.getUserId());
//        }
//        
//        Assert.assertEquals(0, userInfoList.size());
//	}
        
//        
//    	PortalInfoService userService = (PortalInfoService) SpringContextHolder
//		.getService("portalInfoService");
//		UserInfo userInfo = new UserInfo();
//	    userInfo.setUserId("100016");
//        List<UserInfo> userInfoList = userService.queryUserInfoList(userInfo);
//        
//        Assert.assertEquals(1, userInfoList.size());
//	}
//	
//	public void testqueryUserInfoListByPage()
//	{
//		PortalInfoService userService = (PortalInfoService) SpringContextHolder
//		.getService("portalInfoService");
//		
//		System.out.println("..................");
//		
//		List<UserInfo> userInfoList = userService.queryUserInfoListByPage(null,1, 5);
//		
//		for(UserInfo userInfo:userInfoList)
//		{
//			System.out.println(userInfo.getUserId());
//		}
//		
//		Assert.assertEquals(5, userInfoList.size());
//		
//	}
	
//	public void testGetUserCount()
//	{
//		PortalInfoService userService = (PortalInfoService) SpringContextHolder
//		.getService("portalInfoService");
//		
//		 UserInfo userInfo = new UserInfo();
//		 
//		 userInfo.setUserId(null);
//		 
//		 userInfo.setUserName("admin");
//		 
//		 userInfo.setPassword("adminadmin");
//		  
//		 int count = userService.getPortalUserCount(userInfo);
//		 
//		 System.out.println(count);
//		 
//		 Assert.assertEquals(10, count);
//	}
//	
//	public void testDelUsers()
//	{
//		PortalInfoService userService = (PortalInfoService) SpringContextHolder
//		.getService("portalInfoService");
//		
//		 userService.deleteUserInfos("1000008");
//
//	}
	
//	public void testUpdateUser()
//	{
//     	PortalInfoService userService = (PortalInfoService) SpringContextHolder
// 		.getService("portalInfoService");
//     	UserInfo userInfo = new UserInfo();
//     	
//     	userInfo.setUserId("1000008");
//     	userInfo.setName("0");
//     	userInfo.setEmail("nicole@qq.com");
//     	userInfo.setTel("8888");
//     	userInfo.setPassword("66666");
//     	userInfo.setUserName("123453");
//     	
//     	userService.updateUserInfo(userInfo);
//	
//	}

//}
	



