package com.team10.order.controller;

import com.team10.annotation.TokenCheck;
import com.team10.order.model.Order;
import com.team10.order.service.OrderService;
import com.team10.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 0:59:00
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/orderList")
    @TokenCheck
    public Object orderList() {
        Map<String, Object> map = orderService.getOrderList(TokenUtils.getUserId());
        return map;
    }

    @GetMapping("/order/orderDetail")
    @TokenCheck
    public Object orderDetail(Integer id) {
        Map<String, Object> map = orderService.getOrderDetail(id);
        return map;
    }

    @PostMapping("/order/placeOrder")
    @TokenCheck
    public Object placeOrder(String goodsId,String num,int addrId,String isPay) {
        //支付时确定支付时间
        Order order = new Order();
        order.setGoodsId(goodsId);
        order.setNum(num);
        order.setAddressId(addrId);
        order.setState(isPay);
        order.setUserId(TokenUtils.getUserId());
        Map<String, Object> map = orderService.placeOrder(order);
        return map;
    }
}
