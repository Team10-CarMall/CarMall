package com.team10.order.service;

import com.team10.order.model.Order;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface OrderService {

    Map<String, Object> getOrderList(String userId);

    Map<String, Object> getOrderDetail(Integer id);

    Map<String, Object> placeOrder(Order order);
}
