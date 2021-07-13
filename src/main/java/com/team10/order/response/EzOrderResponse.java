package com.team10.order.response;

import lombok.Data;

@Data
public class EzOrderResponse {
    private int id;
    private String num;
    private Double price;
    private Double totalPrice;
    private String goodsDescription;
    private String goodPicUrl;
    private String state;
    private String color;
}
