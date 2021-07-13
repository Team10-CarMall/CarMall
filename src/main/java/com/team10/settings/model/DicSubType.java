package com.team10.settings.model;

/**
 * 二级分类的对象
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:07:39
 */
public class DicSubType {
	private Integer id;    //商品二级分类类型的id,简单自增
	private String text;   //商品二级分类的中文描述
	private String value;  //商品二级分类的值
	private String order;  //用于排序
	private Integer parentId; //商品类型的id
	private Boolean enable;   //是否启用

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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}
