package cn.emag.system.web.ajax;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import cn.emag.framework.action.JsonAction;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.system.domain.BaseData;
import cn.emag.system.service.BaseDataService;

public class BaseDataAjaxAction extends JsonAction {
	
	
	/**列出直接子类*/
	public void getListByFlag(){
		BaseDataService baseDataService = (BaseDataService) SpringContextHolder.getService("baseDataService");

		String flag = getStringParameter("flag");
		String name = getStringParameter("name");
		List<BaseData> baseDatas = baseDataService.findChildsByFlag(flag,name);
		
		JSONObject json = new JSONObject();
		json.put("result", baseDatas);
		try {
			serializer(json);
		} catch (IOException e) {
			e.printStackTrace();
			//IO 异常
		}
	}
	/**列出所有子类 包含子类的子类*/
	public void getListAllByFlag(){
		BaseDataService baseDataService = (BaseDataService) SpringContextHolder.getService("baseDataService");

		String flag = getStringParameter("flag");
		String name = getStringParameter("name");
		List<BaseData> baseDatas = baseDataService.findAllChildsByFlag(flag,name);
		
		JSONObject json = new JSONObject();
		json.put("result", baseDatas);
		try {
			serializer(json);
		} catch (IOException e) {
			e.printStackTrace();
			//IO 异常
		}
	}

}
