package cn.emag.system.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.lang.StringUtils;

import cn.emag.framework.action.BaseAction;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.system.domain.BaseData;
import cn.emag.system.service.BaseDataService;

/**添加 修改 删除 展示树状 */
public class BaseDataAction extends BaseAction {
	
	private Integer  bdId;
	private Integer  parentId;
	private String   parentCode;
	private String   checkFlag;
	private BaseData baseData;
	
	
	/**去添加数据页面*/
	public String toAddBd(){
		System.out.println("bdId:"+bdId + " parentId:" +parentId);
		String msg = "添加根节点";
		msg = (parentId==null)?msg:"添加子节点";
		getRequest().setAttribute("msg", msg);
		return SUCCESS;
	}

	/**添加数据
	 * 得到父亲的lvl 再加1 service 里面做业务
	 * code新算 目前code4位一级 */
	public String doAddBd(){
		System.out.println("BaseDataAction.doAddBd BdCode:" + baseData.getBdLvl());
		BaseDataService baseDataService = (BaseDataService) SpringContextHolder.getService("baseDataService");
		bdId = baseDataService.save(baseData);
		if(bdId==0){
			return "MaxCoded";
		}
		return SUCCESS;
	}

	/**去修改数据页面*/
	public String toEditBd(){
		BaseDataService baseDataService = (BaseDataService) SpringContextHolder.getService("baseDataService");
		baseData = baseDataService.findById(bdId);
		return SUCCESS;
	}
	
	/**修改数据*/
	public String doEditBd(){
		bdId = baseData.getBdId();
		System.out.println("BaseDataAction.doEditBd BdCode:" + baseData.getBdName());
		BaseDataService baseDataService = (BaseDataService) SpringContextHolder.getService("baseDataService");
		baseDataService.update(baseData);
		
		return SUCCESS;
	}
	
	/**删除数据*/
	public void doDelBd(){
		BaseDataService baseDataService = (BaseDataService) SpringContextHolder.getService("baseDataService");
		baseDataService.delete(bdId);
	}
	
	/**checkFlag*/
	public void checkFlag(){
		BaseDataService baseDataService = (BaseDataService) SpringContextHolder.getService("baseDataService");
		checkFlag = baseDataService.checkFlag(checkFlag);
		System.out.println("BaseDataAction.checkBaseDataSeq checkFlag:"+checkFlag);
		try {
			PrintWriter pw =	getResponse().getWriter();
			String rs = (StringUtils.isBlank(checkFlag))?"false":"true";
			pw.print(rs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Integer getBdId() {
		return bdId;
	}
	public void setBdId(Integer bdId) {
		this.bdId = bdId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public BaseData getBaseData() {
		return baseData;
	}

	public void setBaseData(BaseData baseData) {
		this.baseData = baseData;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	

	
}
