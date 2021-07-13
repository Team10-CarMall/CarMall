package com.team10.goods.model;

/**
 * 商品对象
 * @Author LINZHIPIN
 * @CreateTime 2021/07/06 22:41:01
 */
public class Goods {
	private String goodsId;             //商品的id
	private String goodsDescription;    //商品的描述信息
	private String picUrl1;             //商品的图片地址
	private String picUrl2;
	private String unionId;             //商品是属于哪一个集合的id,自增
	private String color;               //颜色的中文描述
	private String state;               //商品状态，0表示下架了，1表示可以购买,  2表示售罄了
	private Integer saleNum;            //卖出的数量
	private Double goodsPrice;          //单价
	private String createTime;
	private String editTime;
	private Integer version;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public String getPicUrl1() {
		return picUrl1;
	}

	public void setPicUrl1(String picUrl1) {
		this.picUrl1 = picUrl1;
	}

	public String getPicUrl2() {
		return picUrl2;
	}

	public void setPicUrl2(String picUrl2) {
		this.picUrl2 = picUrl2;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
