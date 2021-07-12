package com.team10.order.response;

import lombok.Data;


@Data
public class HdOrderResponse {
    private Integer id;
    private String num;
    private Double price;
    private Double totalPrice;
    private Double expressFee;
    private String goodsDescription;
    private String goodsPicUrl;
    private String state;
    private String color;
    private String createTime;
    private String payTime;
    private String name;
    private String phone;
    private String addr;
}
