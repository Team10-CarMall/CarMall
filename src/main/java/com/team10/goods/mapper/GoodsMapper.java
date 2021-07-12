package com.team10.goods.mapper;

import com.team10.goods.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/06/00006 23:10:40
 */
@Mapper
public interface GoodsMapper {

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
	List<Goods> getGoodsBySubType(String subTypeId);

	/**
	 * 根据unionId获取相关的商品集合的部分信息，用于用户点击颜色时使用
	 * @param unionId 商品集合的id
	 * @return goodsId,
	 *         unionId,
	 *         color,
	 *         state
	 */
	List<Goods> getGoodsDetailByUnionId(String unionId);

	/**
	 * 根据商品编号获得商品的详细信息
	 * @param goodsId 商品的id
	 * @return goods_Id,
	 *         goodsDescription,
	 *         picUrl1,
	 *         picUrl2,
	 *         unionId,
	 *         stock,
	 *         color,
	 *         state,
	 *         saleNum,
	 *         goodsPrice
	 */
	Goods getGoodsDetailById(String goodsId);
}
