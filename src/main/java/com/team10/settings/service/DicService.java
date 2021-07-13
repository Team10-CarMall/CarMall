package com.team10.settings.service;

import com.team10.exception.AccessException;
import com.team10.settings.model.DicType;

import java.util.List;
import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:10:28
 */
public interface DicService {

	/**
	 * @param enable : 查询的是是否启用的一级分类
	 * @return id,
	 *         text,
	 *         value,
	 *         order,
	 *         picUrl
	 */
	Map<String, Object> getGoodsType(Boolean enable);

	Map<String, Object> getGoodsSubType(String id) throws AccessException;
}
