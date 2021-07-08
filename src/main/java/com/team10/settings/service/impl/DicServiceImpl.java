package com.team10.settings.service.impl;

import com.team10.settings.mapper.DicTypeMapper;
import com.team10.settings.model.DicType;
import com.team10.settings.service.DicService;
import com.team10.util.ReturnDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:10:37
 */
@Service
public class DicServiceImpl implements DicService {
	@Resource(name = "redisTemplateOfJson")
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private DicTypeMapper dicTypeMapper;

	@Override
	public Map<String, Object> getGoodsType(Boolean enable) {
		List<DicType> list = dicTypeMapper.getGoodsType(enable);
		return ReturnDataUtil.getReturnMap("操作成功", list);
	}
}
