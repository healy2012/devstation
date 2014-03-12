/**
 * TODO
 * @author Administrator
 * Create on 2010-8-26
 */
package cn.emag.global.domain;

import java.util.ArrayList;
import java.util.Collection;

import cn.emag.framework.bean.BaseObj;

/**
 * 描述Menu的属性，对应Menu.xml的属性
 * 
 * @author  pc
 * @version  [1.0, Jul 7, 2011]
 * @since 统一平台开发1.0
 */
public class Menu extends BaseObj
{
    /**
     * 目录ID
     */
    private String menuId;
    
    /**
     * 图片名称，可用于扩展页面href的点击图片
     */
    private String imageName;
    
    /**
     * 目录名称
     */
	private String name;

	/**
	 * 点击目录链接要跳转的地址
	 */
	private String action;
	
	/**
	 * 该目录是否展示
	 */
	private boolean display;
    
	/**
	 * 当前目录的父目录
	 */
	private Menu parent;

	/**
	 * 当前目录的子目录们
	 */
	private Collection<Menu> children;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Collection<Menu> getChildren() {
		return children;
	}

	public void setChildren(Collection<Menu> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public void addChild(Menu child) {
		if (children == null) {
			children = new ArrayList<Menu>();
		}
		children.add(child);
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

    public String getMenuId()
    {
        return menuId;
    }

    public void setMenuId(String menuId)
    {
        this.menuId = menuId;
    }

    public String getImageName()
    {
        return imageName;
    }

    public void setImageName(String imageName)
    {
        this.imageName = imageName;
    }
}
