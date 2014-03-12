/**
 * TODO
 * @author Administrator
 * Create on 2011-6-27
 */
package cn.emag.demo.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import cn.emag.demo.domain.Message;
import cn.emag.framework.dao.BaseIBatisDao;

@Repository
public class DemoIbatisDao extends BaseIBatisDao {

	public void insertMessage(Message message) {
//		message.setMessageId(getNextIntegerID());
		getSqlMapClientTemplate().insert(
				"cn.emag.demo.domain.Message.insertMessage", message);
	}

	@SuppressWarnings("unchecked")
	public List<Message> queryForPaginatedList(int pageNumber, int pageSize,
			String sortByColumn, boolean sortAsc, Map<String, String> map) {
		return queryForPaginatedList("cn.emag.demo.domain.Message.listMessage",
				map, pageNumber, pageSize, sortByColumn, sortAsc);
	}
}
