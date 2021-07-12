package com.team10.order.model;

import lombok.Data;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 0:44:47
 */

@Data
public class Order {
	private Integer id;      //订单编号 三位随机数+时间
	private String num;          //购买的数量
	private Double price;        //单价
	private String expressFee;   //快递费
	private Double totalPrice;   //总价
	private String goodsId;      //商品id: goods+10000 递增
	private String userId;       //用户id: user+10000 递增
	private int addressId;    //快递地址id 主键自增
	private String state;        // 0未付款，1已付款，2表示未发货，3表示已发货，4表示已完成
	private String createTime;
	private String editTime;
	private Integer version;



	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(String expressFee) {
		this.expressFee = expressFee;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
