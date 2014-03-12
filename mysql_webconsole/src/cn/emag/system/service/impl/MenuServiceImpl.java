/**
 * TODO
 * @author Administrator
 * Create on 2011-7-8
 */
package cn.emag.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.emag.global.utils.GlobalUtil;
import cn.emag.system.dao.MenuJdbcDao;
import cn.emag.system.domain.Menu;
import cn.emag.system.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuJdbcDao menuJdbcDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.emag.system.service.MenuService#listDisplayMenu()
	 */
	public List<Menu> listDisplayMenu(Integer navId) {
		return this.menuJdbcDao.listDisplayMenu(navId);
	}

	public List<Menu> listAllMenu(Integer navId) {
		return this.menuJdbcDao.listAllMenu(navId);
	}
	
	public Menu getMenu(Integer menuId) {
		return this.menuJdbcDao.getMenu(menuId);
	}
	
	public int updateMenu(Menu menu) {
		return this.menuJdbcDao.updateMenu(menu);
	}
	
	public int insertMenu(Menu menu) {
		return this.menuJdbcDao.insertMenu(menu);
	}

	public String generatorCode(Integer parentId,String parentCode) {
		String childrenMaxCode = this.menuJdbcDao.getChildrenMaxCode(parentId);
		return GlobalUtil.generatorTreeCode(parentCode, childrenMaxCode);
	}
	
    public int deleteMenusByCode(Integer navId,String parentCode) {
		return this.menuJdbcDao.deleteMenusByCode(navId,parentCode);
	}
	
	public boolean checkMenuSeq(Integer navId,Integer parentId,Integer seq,Integer menuId) {
		return this.menuJdbcDao.checkMenuSeq(navId,parentId, seq, menuId);
	}
}
