/**
 * TODO
 * @author Administrator
 * Create on 2011-6-24
 */
package cn.emag.demo.service;

import java.util.List;
import cn.emag.demo.domain.Message;

public interface DemoService {
	public int insertMessage(Message message);

	public List<Message> listMessage(Integer pageNumber, Integer pageSize);
	
	public int getMessageCount();
	
	public void insertMessageByIbatis(Message message);
	
	public List<Message> listMessageByIbatis(Integer pageNumber, Integer pageSize);
}
