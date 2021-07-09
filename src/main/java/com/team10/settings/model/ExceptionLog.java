package com.team10.settings.model;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/09/00009 15:14:46
 */
public class ExceptionLog {
	private String content;
	private String createTime;
	private String userId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
