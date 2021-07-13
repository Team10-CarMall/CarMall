package com.team10.settings.model;

/**
 * 一级分类的对象
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:01:36
 */
public class DicType {
	private Integer id;   //类型的id 简单自增
	private String text;  //商品类型的中文描述
	private String value; //商品类型的值
	private String order; //用于排序
	private Boolean enable; //是否启用
	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}
