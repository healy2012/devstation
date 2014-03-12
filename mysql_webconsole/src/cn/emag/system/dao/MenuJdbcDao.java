/**
 * TODO
 * @author Administrator
 * Create on 2011-7-8
 */
package cn.emag.system.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import cn.emag.framework.dao.BaseJdbcDao;
import cn.emag.system.domain.Menu;

@Repository
public class MenuJdbcDao extends BaseJdbcDao {

	@SuppressWarnings("unchecked")
	public List<Menu> listDisplayMenu(Integer navId) {
		String sql = loadSQL("listDisplayMenu");
		return getJdbcTemplate().query(sql, new Object[] { navId },
				new BeanPropertyRowMapper(Menu.class));
	}

	@SuppressWarnings("unchecked")
	public List<Menu> listAllMenu(Integer navId) {
		String sql = loadSQL("listAllMenu");
		return getJdbcTemplate().query(sql, new Object[] { navId },
				new BeanPropertyRowMapper(Menu.class));
	}

	public Menu getMenu(Integer menuId) {
		String sql = loadSQL("getMenu");
		return (Menu) getJdbcTemplate().queryForObject(sql,
				new Object[] { menuId }, new BeanPropertyRowMapper(Menu.class));
	}

	public int updateMenu(Menu menu) {
		String sql = loadSQL("updateMenu");
		return getJdbcTemplate().update(
				sql,
				new Object[] { menu.getMenuTitle(), menu.getMenuUrl(),
						menu.getMenuSeq(), menu.getMenuStatus(),
						menu.getMenuId() });
	}

	public int insertMenu(Menu menu) {
		String sql = loadSQL("insertMenu");
		int reInt = getJdbcTemplate().update(
				sql,
				new Object[] { menu.getMenuId(), menu.getMenuTitle(),
						menu.getMenuCode(), menu.getMenuUrl(),
						menu.getMenuSeq(), menu.getMenuStatus(),
						menu.getMenuParentId(), menu.getMenuNote(),
						menu.getNavId()}, new int[] { Types.INTEGER, Types.VARCHAR, 
				        Types.VARCHAR,Types.VARCHAR,Types.INTEGER,Types.INTEGER,Types.INTEGER,Types.VARCHAR,Types.INTEGER});
		if(reInt == 1){
			reInt = getJdbcTemplate().queryForInt("SELECT LAST_INSERT_ID()");
		}
		
		return reInt;
	}

	/**
	 * 获得某节点下所有子节点的最大code
	 * @param parentId 父节点id
	 * @return
	 */
	public String getChildrenMaxCode(Integer parentId) {
		String sql = loadSQL("getChildrenMaxCode");
		return (String) getJdbcTemplate().queryForObject(sql,
				new Object[] { parentId }, String.class);
	}
	
	/**
	 * 根据父节点的code删除所有子节点
	 * @param navId 导航菜单id
	 * @param parentCode 父节点code
	 * @return
	 */
	public int deleteMenusByCode(Integer navId,String parentCode) {
		String sql = loadSQL("deleteMenusByCode");
		return getJdbcTemplate().update(sql, new Object[]{navId,parentCode + "%"});
	}
	
	/**
	 * 检查序号是否重复
	 * @param navId 导航菜单id
	 * @param parentId 父节点id
	 * @param seq 序号
	 * @param menuId 菜单id
	 * @return
	 */
	public boolean checkMenuSeq(Integer navId,Integer parentId,Integer seq,Integer menuId) {
		String sql = loadSQL("checkMenuSeq");
		return getJdbcTemplate().queryForInt(sql, new Object[]{navId,parentId,seq,menuId}) > 0;
	}
	
}
