package com.team10.goods.service;

import java.util.Map;

/**
 * 处理有关商品的业务逻辑
 * @Author LINZHIPIN
 * @CreateTime 2021/07/06 23:09:51
 */
public interface GoodsService {

	/**
	 *  通过二级分类的id去获取商品列表
	 * @param subTypeId 二级分类的id
	 * @return goodsId
	 *         goodsDescription,
	 *         picUrl1,
	 *         unionId,
	 *         color,
	 *         saleNum,
	 *         goodsPrice
	 */
	Map<String, Object> getGoodsBySubType(String subTypeId);

	/**
	 * 根据unionId获取相关的商品集合的部分信息，用于用户点击颜色时使用
	 * @param unionId 商品集合的id
	 * @return goodsId,
	 *         unionId,
 	 *         color,
	 *         state
	 */
	Map<String, Object> getGoodsUnionByUnionId(String unionId);

	/**
	 * 根据商品编号获得商品的详细信息
	 * @param goodsId 商品的id
	 * @return goods_Id,
	 *         goodsDescription,
	 *         picUrl1,
	 *         picUrl2,
	 *         unionId,
	 *         stock(库存量),
	 *         color,
	 *         state,
	 *         saleNum,
	 *         goodsPrice
	 */
	Map<String, Object> getGoodsDetailById(String goodsId);
}
