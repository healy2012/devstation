/**
 * TODO
 * @author Administrator
 * Create on 2011-6-24
 */
package cn.emag.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.emag.demo.dao.DemoIbatisDao;
import cn.emag.demo.dao.DemoJdbcDao;
import cn.emag.demo.domain.Message;
import cn.emag.demo.service.DemoService;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoJdbcDao demoJdbcDao;

	@Autowired
	private DemoIbatisDao demoIbatisDao;

	public int insertMessage(Message message) {
		return this.demoJdbcDao.insertMessage(message);
	}

	public List<Message> listMessage(Integer pageNumber, Integer pageSize) {
		return this.demoJdbcDao.listMessage(pageNumber, pageSize);
	}

	public int getMessageCount() {
		return this.demoJdbcDao.getMessageCount();
	}

	public void insertMessageByIbatis(Message message) {
		this.demoIbatisDao.insertMessage(message);
	}

	public List<Message> listMessageByIbatis(Integer pageNumber,
			Integer pageSize) {
		return this.demoIbatisDao.queryForPaginatedList(pageNumber, pageSize,
				"", true, null);
	}
}
