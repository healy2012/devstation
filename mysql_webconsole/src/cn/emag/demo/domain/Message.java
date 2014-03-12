package cn.emag.demo.domain;

import cn.emag.framework.bean.BaseObj;

public class Message extends BaseObj {

	private Integer messageId;

	private String messageAuthor;

	private String messageContent;

	private String messageTime;

	private String state;

	public String getMessageAuthor() {
		return messageAuthor;
	}

	public void setMessageAuthor(String messageAuthor) {
		this.messageAuthor = messageAuthor;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
