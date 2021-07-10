package com.team10.goods.service.impl;

import com.team10.goods.mapper.GoodsMapper;
import com.team10.goods.model.Goods;
import com.team10.goods.service.GoodsService;
import com.team10.util.ReturnDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 3:16:01
 */
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public Map<String, Object> getGoodsBySubType(String subTypeId) {
		List<Goods> list = goodsMapper.getGoodsBySubType(subTypeId);
		return ReturnDataUtil.getReturnMap("操作成功", list);
	}

	@Override
	public Map<String, Object> getGoodsUnionByUnionId(String unionId) {
		List<Goods> list = goodsMapper.getGoodsDetailByUnionId(unionId);
		return ReturnDataUtil.getReturnMap("操作成功",list);
	}

	@Override
	public Map<String, Object> getGoodsDetailById(String goodsId) {
		Goods goods = goodsMapper.getGoodsDetailById(goodsId);
		return ReturnDataUtil.getReturnMap("操作成功", goods);
	}
}
