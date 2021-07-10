package com.team10.goods.controller;

import com.team10.annotation.NullCheck;
import com.team10.goods.service.GoodsService;
import com.team10.user.log.CarLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/06/00006 23:10:55
 */
@RestController
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	//通过二级分类的id去获取商品列表
	@RequestMapping(value = "/goods/getGoodsBySubType", method = RequestMethod.GET)
	@NullCheck
	public Object getGoodsByType(String subTypeId) {
		Map<String, Object> map = goodsService.getGoodsBySubType(subTypeId);
		return map;
	}

	//根据unionId获取相关的商品集合的部分信息
	@RequestMapping(value = "/goods/getGoodsUnionByUnionId", method = RequestMethod.GET)
	@NullCheck
	public Object getGoodsUnionByUnionId(String unionId) {
		Map<String, Object> map = goodsService.getGoodsUnionByUnionId(unionId);
		return map;
	}

	//根据商品编号获得商品的详细信息
	@RequestMapping(value = "/goods/getGoodsDetailById", method = RequestMethod.GET)
	@NullCheck
	public Object getGoodsDetailById(String goodsId) {
		Map<String, Object> map = goodsService.getGoodsDetailById(goodsId);
		return map;
	}

	@CarLog
	@RequestMapping(value = "/goods/collectGoods", method = RequestMethod.POST)
	public Object collectGoods() {
		return null;
	}
}
