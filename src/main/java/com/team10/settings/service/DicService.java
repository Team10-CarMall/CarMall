package com.team10.settings.service;

import com.team10.exception.AccessException;
import com.team10.settings.model.DicType;

import java.util.List;
import java.util.Map;

/**
 * 用于处理数据字典的业务
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:10:28
 */
public interface DicService {

	/**
	 * 获得商品的一级分类列表
	 *
	 * @param enable : 查询的是是否启用的一级分类
	 * @return id,
	 *         text,
	 *         value,
	 *         order,
	 *         picUrl
	 */
	Map<String, Object> getGoodsType(Boolean enable);

	/**
	 * 根据商品的一级分类id来获取二级分类
	 *
	 * @param id 一级分类的id
	 * @return id            二级分类的id
	 *         text          二级分类的文本说明
	 *         value         二级分类的值
	 *         order         用于排序
	 *         parent_id     所属的一级分类id
	 */
	Map<String, Object> getGoodsSubType(String id) throws AccessException;
}
