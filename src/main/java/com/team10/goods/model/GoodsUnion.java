package com.team10.goods.model;

/**
 * 商品集合
 * @Author LINZHIPIN
 * @CreateTime 2021/07/06 23:39:40
 */
public class GoodsUnion {
	private Integer id;         //集合id
	private String subTypeId;   //所属的二级分类的id
	private String createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(String subTypeId) {
		this.subTypeId = subTypeId;
	}
}
