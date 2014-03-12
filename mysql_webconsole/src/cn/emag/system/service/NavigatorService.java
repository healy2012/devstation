/**
 * TODO
 * @author Administrator
 * Create on 2011-7-8
 */
package cn.emag.system.service;

import java.util.List;
import cn.emag.system.domain.Navigator;

public interface NavigatorService {
	public List<Navigator> listDisplayNavigator();
	
	public List<Navigator> queryNavigatorList();
	
	void saveNavigator(Navigator navigator);
	
	void deleteNavigators(String navIds);
	
	Navigator getNavigator(String navIds);
	
	void updateNavigator(Navigator navigator);
	
	boolean isNotNavSeqExist(Integer navId,Integer navSeq);
}
