package com.team10.order.mapper;

import com.team10.order.model.Order;
import com.team10.order.response.EzOrderResponse;
import com.team10.order.response.HdOrderResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    HdOrderResponse selectOrderById(Integer id);

    int insertSelective(Order record);


    List<EzOrderResponse> selectByUserId(String userId);

}