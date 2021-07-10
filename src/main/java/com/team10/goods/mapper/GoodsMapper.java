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

	List<Goods> getGoodsBySubType(String subTypeId);

	List<Goods> getGoodsDetailByUnionId(String unionId);

	Goods getGoodsDetailById(String goodsId);
}
