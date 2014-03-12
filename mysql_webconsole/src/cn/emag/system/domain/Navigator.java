/**
 * TODO
 * @author Administrator
 * Create on 2011-7-8
 */
package cn.emag.system.domain;

import cn.emag.framework.bean.BaseObj;

public class Navigator extends BaseObj {

	private Integer navId;
	private String navName;
	private String navUrl;
	private Integer navStatus;
	private Integer navSeq;
	private String navNote;

	public Integer getNavId() {
		return navId;
	}

	public void setNavId(Integer navId) {
		this.navId = navId;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public String getNavUrl() {
		return navUrl;
	}

	public void setNavUrl(String navUrl) {
		this.navUrl = navUrl;
	}  

    public Integer getNavStatus()
    {
        return navStatus;
    }

    public void setNavStatus(Integer navStatus)
    {
        this.navStatus = navStatus;
    }

    public Integer getNavSeq() {
		return navSeq;
	}

	public void setNavSeq(Integer navSeq) {
		this.navSeq = navSeq;
	}

	public String getNavNote() {
		return navNote;
	}

	public void setNavNote(String navNote) {
		this.navNote = navNote;
	}
}
