package com.team10.user.model;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07 0:42:58
 */
public class User {
	private String userId;       //用户id user+10000 递增
	private String username;     //用户名
	private String password;     //用户密码
	private String description;  //用户简介
	private String picUrl;       //用户头像的地址
	private String createTime;
	private String editTime;
	private String version;
	private String state;   //保留字段，用于判断用户的状态 0表示账号异常，1表示账号正常，2表示账号有风险

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEditTime() {
		return editTime;
	}

	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
