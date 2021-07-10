package com.team10.goods.service;

import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/06 23:09:51
 */
public interface GoodsService {

	Map<String, Object> getGoodsBySubType(String subTypeId);

	Map<String, Object> getGoodsUnionByUnionId(String unionId);

	Map<String, Object> getGoodsDetailById(String goodsId);
}
