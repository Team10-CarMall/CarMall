package com.team10.order.service.impl;

import com.team10.enums.ReturnCode;
import com.team10.order.mapper.OrderMapper;
import com.team10.order.model.Order;
import com.team10.order.response.EzOrderResponse;
import com.team10.order.response.HdOrderResponse;
import com.team10.order.service.OrderService;
import com.team10.util.ReturnDataUtil;
import com.team10.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Map<String, Object> getOrderList(String userId) {
        String msg = "操作成功";
        int code = ReturnCode.SUCCESS;
        List<EzOrderResponse> list = orderMapper.selectByUserId(userId);
        if (list.isEmpty()) {
            msg = "操作失败";
            code = ReturnCode.UNKNOWN_ERROR;
        }
        return ReturnDataUtil.getReturnMap(code,msg,list);
    }

    @Override
    public Map<String, Object> getOrderDetail(Integer id) {
        String msg = "操作成功";
        int code = ReturnCode.SUCCESS;
        HdOrderResponse hdOrderResponse = orderMapper.selectOrderById(id);
        if (hdOrderResponse == null) {
            msg = "操作失败";
            code = ReturnCode.UNKNOWN_ERROR;
        }
        return ReturnDataUtil.getReturnMap(code,msg,hdOrderResponse);
    }

    @Override
    public Map<String, Object> placeOrder(Order order) {
        String msg = "操作成功";
        int code = ReturnCode.SUCCESS;
        order.setCreateTime(TimeUtil.getSystemTime());
        if(order.getState().equals("1")){
            order.setEditTime(TimeUtil.getSystemTime());
        }
        if (orderMapper.insertSelective(order) != 1) {
            msg = "下单失败";
            code = ReturnCode.UNKNOWN_ERROR;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }
}
