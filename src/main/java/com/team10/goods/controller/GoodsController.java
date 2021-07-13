package com.team10.goods.controller;

import com.team10.annotation.CarLog;
import com.team10.annotation.NullCheck;
import com.team10.annotation.TokenCheck;
import com.team10.exception.HandleCacheException;
import com.team10.goods.service.GoodsService;
import com.team10.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 映射有关商品的请求
 * @Author LINZHIPIN
 * @CreateTime 2021/07/06/00006 23:10:55
 */
@RestController
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserService userService;

	//通过二级分类的id去获取商品列表
	@RequestMapping(value = "/goods/getGoodsBySubType", method = RequestMethod.GET)
	@NullCheck
	public Object getGoodsByType(String subTypeId) {
		Map<String, Object> map = goodsService.getGoodsBySubType(subTypeId);
		return map;
	}

	//根据unionId获取相关的商品集合的部分信息,用于用户点击颜色时使用
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

	//根据商品id和用户id来收藏商品，用户id从后端拿
	@RequestMapping(value = "/goods/collectGoods", method = RequestMethod.POST)
	@CarLog
	@TokenCheck
	@NullCheck
	public Object collectGoods(String goodsId) throws HandleCacheException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Map<String, Object> map = userService.collectGoods(goodsId);
		return map;
	}

	//根据商品id判断用户是否收藏过该商品
	@RequestMapping(value = "/goods/isCollect", method = RequestMethod.GET)
	@CarLog
	@TokenCheck
	@NullCheck
	public Object isCollect(String goodsId) throws HandleCacheException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Map<String, Object> map = userService.isCollect(goodsId);
		return map;
	}
}
