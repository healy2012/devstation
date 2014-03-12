/**
 * TODO
 * @author Administrator
 * Create on 2011-6-24
 */
package cn.emag.demo.dao;

import java.sql.Types;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import cn.emag.demo.domain.Message;
import cn.emag.framework.dao.MySqlBaseJdbcDao;

@Repository
public class DemoJdbcDao extends MySqlBaseJdbcDao {

	public int insertMessage(Message message) {
		String sql = loadSQL("insertMessage");
		return getJdbcTemplate()
				.update(
						sql,
						new Object[] { message.getMessageId(),
								message.getMessageAuthor(),
								message.getMessageContent() },
						new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR });
	}

	@SuppressWarnings("unchecked")
	public List<Message> listMessage(Integer pageNumber, Integer pageSize) {
		String sql = loadSQL("listMessage");
		sql = getPaginationSql(sql, pageNumber, pageSize);
		return getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Message.class));
	}

	public int getMessageCount() {
		String sql = loadSQL("getMessageCount");
		return getJdbcTemplate().queryForInt(sql);
	}
}
