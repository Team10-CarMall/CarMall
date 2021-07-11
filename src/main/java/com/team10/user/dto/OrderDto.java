package com.team10.user.dto;

import com.team10.enums.OrderState;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderDto implements Serializable {
    private int id;
    private int num;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String goodsDescription;
    private String goodsPicUrl;
    private OrderState state;
    private String color;
}
