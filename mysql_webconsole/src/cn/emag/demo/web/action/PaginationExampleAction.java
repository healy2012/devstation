/**
 * TODO
 * @author Administrator
 * Create on 2011-6-26
 */
package cn.emag.demo.web.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.emag.demo.domain.Message;
import cn.emag.demo.service.DemoService;
import cn.emag.framework.action.PaginationAction;
import cn.emag.framework.spring.SpringContextHolder;

public class PaginationExampleAction extends PaginationAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 806028515031874305L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.emag.framework.action.PaginationAction#getItemCount(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected int getItemCount(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DemoService service = (DemoService) SpringContextHolder
				.getService("demoService");
		return service.getMessageCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.emag.framework.action.PaginationAction#executePaginationAction(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * int, int)
	 */
	@Override
	protected String executePaginationAction(HttpServletRequest request,
			HttpServletResponse response, int pageNumber, int pageSize)
			throws Exception {
		DemoService service = (DemoService) SpringContextHolder
				.getService("demoService");
		List<Message> list = service.listMessage(pageNumber, pageSize);
		request.setAttribute("list", list);
		return SUCCESS;
	}
}
