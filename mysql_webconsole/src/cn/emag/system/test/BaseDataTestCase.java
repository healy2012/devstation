package cn.emag.system.test;

import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.framework.test.BaseTestCase;
import cn.emag.system.domain.BaseData;
import cn.emag.system.service.BaseDataService;

public class BaseDataTestCase extends BaseTestCase {

	/**测试添加方法*/
	public void testSaveBaseData(){
		BaseDataService bs =  (BaseDataService) SpringContextHolder.getBean("baseDataService");
		
		BaseData bd = new BaseData();
		bd.setBdId(1);
		bd.setBdFlag("");
		bd.setBdLvl(1);
		bd.setBdName("test");
		bd.setBdValue("value");
		bd.setBdValue_1("value");
		bd.setBdValue_2("value");
		bd.setBdParentId(0);
		
		bs.save(bd);
	}
	
	
}
