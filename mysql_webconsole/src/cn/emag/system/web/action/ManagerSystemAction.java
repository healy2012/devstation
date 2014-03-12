package cn.emag.system.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.emag.demo.domain.UserInfo;
import cn.emag.framework.action.PaginationAction;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.system.domain.SystemPO;
import cn.emag.system.service.SystemService;

public class ManagerSystemAction extends PaginationAction {

	/**
     * 序列号
     */
    private static final long serialVersionUID = 1L;
    
    private List<SystemPO> systemList;
	
    private String systemIds;
	
    private SystemPO systemPO;
	
    private SystemService systemService = (SystemService) SpringContextHolder
			.getService("systemService");

	/**
	 * 获得总的系统总数
	 */
	@Override
	protected int getItemCount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SystemService systemService = (SystemService) SpringContextHolder
				.getService("systemService");
		return systemService.getSystemCount(systemPO);
	}

	/**
	 * 获得总的系统总数进行分页
	 */
	@Override
	protected String executePaginationAction(HttpServletRequest request,
			HttpServletResponse response, int pageNumber, int pageSize)
			throws Exception {

		systemList = systemService.querySystemListByPage(systemPO, pageNumber,
				pageSize);
		return SUCCESS;
	}

	/**
	 * 增加系统（准备需要的数据）
	 * 
	 * @return
	 */
	public String addSystem() {
		return SUCCESS;
	}

	
	/**
	 * 保存增加系统
	 * 
	 * @return
	 */
	public String saveAddSystem() {
		systemService.saveAddSystem(systemPO);
		return SUCCESS;
	}

	/**
	 * 删除角色（删除用户的关系，给用户表中那个角色分配为null）先删除关联的功能权限和报表权限
	 * 
	 * @return
	 */
	public String deleteSystem() {
		systemService.deleteSystems(systemIds);
		return SUCCESS;
	}

	/**
	 * 修改系统
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateSystem() {

		SystemPO systemForQuery = new SystemPO();

		systemForQuery.setSystemId((systemIds.split(","))[0]);

		systemPO = systemService.querySystemBySystemId(systemForQuery,"",true).get(0);

		return SUCCESS;
	}

	public String updateSaveSystem(){
		systemService.updateSystemPO(systemPO);	
		return SUCCESS;
	}
	
	
	

	

	public List<SystemPO> getSystemList() {
		return systemList;
	}

	public void setSystemList(List<SystemPO> systemList) {
		this.systemList = systemList;
	}

	public String getSystemIds() {
		return systemIds;
	}

	public void setSystemIds(String systemIds) {
		this.systemIds = systemIds;
	}

	public SystemPO getSystemPO() {
		return systemPO;
	}

	public void setSystemPO(SystemPO systemPO) {
		this.systemPO = systemPO;
	}
}
