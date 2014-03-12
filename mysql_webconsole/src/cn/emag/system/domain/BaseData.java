package cn.emag.system.domain;

import java.util.List;

/**
 * 数据字典*/
public class BaseData {
	private Integer bdId;
	private Integer bdLvl;//--lvl <= code
	private String  bdName;
	private String  bdFlag;
	private String  bdValue;
	private String  bdValue_1;
	private String  bdValue_2;
	private Integer bdParentId;
	private String  bdCode;
	private List<BaseData>    childs;
	public Integer getBdId() {
		return bdId;
	}
	public void setBdId(Integer bdId) {
		this.bdId = bdId;
	}

	public Integer getBdLvl() {
		return bdLvl;
	}
	public void setBdLvl(Integer bdLvl) {
		this.bdLvl = bdLvl;
	}
	public String getBdName() {
		return bdName;
	}
	public void setBdName(String bdName) {
		this.bdName = bdName;
	}
	public String getBdFlag() {
		return bdFlag;
	}
	public void setBdFlag(String bdFlag) {
		this.bdFlag = bdFlag;
	}
	public String getBdValue() {
		return bdValue;
	}
	public void setBdValue(String bdValue) {
		this.bdValue = bdValue;
	}
	public String getBdValue_1() {
		return bdValue_1;
	}
	public void setBdValue_1(String bdValue_1) {
		this.bdValue_1 = bdValue_1;
	}
	public String getBdValue_2() {
		return bdValue_2;
	}
	public void setBdValue_2(String bdValue_2) {
		this.bdValue_2 = bdValue_2;
	}
	public Integer getBdParentId() {
		return bdParentId;
	}
	public void setBdParentId(Integer bdParentId) {
		this.bdParentId = bdParentId;
	}
	public List<BaseData> getChilds() {
		return childs;
	}
	public void setChilds(List<BaseData> childs) {
		this.childs = childs;
	}
	public String getBdCode() {
		return bdCode;
	}
	public void setBdCode(String bdCode) {
		this.bdCode = bdCode;
	}
	
	

}
