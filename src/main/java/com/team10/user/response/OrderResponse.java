package com.team10.user.response;

import com.team10.user.dto.OrderDto;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private int code;
    private String msg;
    private List<OrderDto> list;
}
