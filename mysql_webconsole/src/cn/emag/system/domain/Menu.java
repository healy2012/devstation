/**
 * TODO
 * @author Administrator
 * Create on 2011-7-8
 */
package cn.emag.system.domain;

import cn.emag.framework.bean.BaseObj;

public class Menu extends BaseObj {

	private Integer menuId;
	private Integer navId;
	private String menuTitle;
	private String menuCode;
	private String menuUrl;
	private Integer menuSeq;
	private Integer menuStatus;
	private Integer menuParentId;
	private String menuNote;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getNavId() {
		return navId;
	}

	public void setNavId(Integer navId) {
		this.navId = navId;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(Integer menuSeq) {
		this.menuSeq = menuSeq;
	}

	public Integer getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(Integer menuStatus) {
		this.menuStatus = menuStatus;
	}

	public Integer getMenuParentId() {
		return menuParentId;
	}

	public void setMenuParentId(Integer menuParentId) {
		this.menuParentId = menuParentId;
	}

	public String getMenuNote() {
		return menuNote;
	}

	public void setMenuNote(String menuNote) {
		this.menuNote = menuNote;
	}

}
