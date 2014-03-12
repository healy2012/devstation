/**
 * TODO
 * @author Administrator
 * Create on 2011-7-26
 */
package cn.emag.global.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import cn.emag.framework.security.ClientSession;
import cn.emag.framework.security.ClientSessionHolder;

public class LogUtil {
	private static Log log = LogFactory.getLog(LogUtil.class);

	/**
	 * 记录用户日志
	 * 
	 * @param model
	 *            模块
	 * @param func
	 *            功能
	 * @param message
	 *            信息
	 */
	public static void info(String sysModule, String func, String message) {
		ClientSession cs = ClientSessionHolder.getClientSession();
		StringBuilder builder = new StringBuilder();
		builder.append(cs.getUserId()).append(",");
		builder.append(cs.getUserName()).append(",");
		builder.append(sysModule).append(",");
		builder.append(func).append(",");
		builder.append(message);
		log.info(builder.toString());
	}
}
