/**
 * TODO
 * @author Administrator
 * Create on 2011-6-24
 */
package cn.emag.demo.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import cn.emag.demo.domain.Message;
import cn.emag.demo.service.DemoService;
import cn.emag.framework.spring.SpringContextHolder;
import cn.emag.framework.test.BaseTestCase;
import cn.emag.framework.utils.DataUtil;

public class DemoServiceTestCase extends BaseTestCase {

	public void testInsertMessage() {
		try {
			DemoService service = (DemoService) SpringContextHolder
					.getService("demoService");
			Message message = new Message();
			message.setMessageId(DataUtil.getNextIntegerIdFromSequence());
			message.setMessageAuthor("zhangchao");
			message.setMessageContent("Hey Jude");
			service.insertMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testListMessage() {
		try {
			DemoService service = (DemoService) SpringContextHolder
					.getService("demoService");
			service.listMessage(1, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testInsertMessageByIbatis() {
		try {
			Message message = new Message();
			message.setMessageAuthor("jolin");
			message.setMessageContent("Hello,world!");
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			message.setMessageTime(format.format(new Date()));
			DemoService service = (DemoService) SpringContextHolder
					.getService("demoService");
			service.insertMessageByIbatis(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
