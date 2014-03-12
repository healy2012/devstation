/**
 * TODO
 * @author Administrator
 * Create on 2011-7-8
 */
package cn.emag.system.service;

import java.util.List;
import cn.emag.system.domain.Menu;

public interface MenuService {
	public List<Menu> listDisplayMenu(Integer navId);
	
	public List<Menu> listAllMenu(Integer navId);
	
	public Menu getMenu(Integer menuId);
	
	public int updateMenu(Menu menu);
	
	public int insertMenu(Menu menu);
	
	public String generatorCode(Integer parentId,String parentCode);
	
	public int deleteMenusByCode(Integer navId,String treeId);
	
	public boolean checkMenuSeq(Integer navId,Integer parentId,Integer seq,Integer menuId);
}
