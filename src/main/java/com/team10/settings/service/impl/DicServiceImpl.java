package com.team10.settings.service.impl;

import com.team10.exception.AccessException;
import com.team10.settings.mapper.DicSubTypeMapper;
import com.team10.settings.mapper.DicTypeMapper;
import com.team10.settings.model.DicSubType;
import com.team10.settings.model.DicType;
import com.team10.settings.service.DicService;
import com.team10.util.ReturnDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
	@Autowired
	private DicSubTypeMapper dicSubTypeMapper;
	@Override
	public Map<String, Object> getGoodsType(Boolean enable) {
		/*
		*   以json的方式存储数据，若redis中有，则去redis中获取，若Redis中没有，则去mysql中获取以后再存入redis
		*/
		ValueOperations<String, Object> ops = redisTemplate.opsForValue();
		List<DicType> list = null;
		if(!redisTemplate.hasKey("dic_goodsType")) {
			list = dicTypeMapper.getGoodsType(enable);
			ops.set("dic_goodsType", list);;
		} else {
			list = (List<DicType>) ops.get("dic_goodsType");
		}
		return ReturnDataUtil.getReturnMap("操作成功", list);
	}

	@Override
	public Map<String, Object> getGoodsSubType(String id) throws AccessException {
		/*
		*   先去redis中查询，若Redis中有，则去redis中获取，若redis中没有
		*/
		if(id == null) {
			throw new AccessException("访问时传入的一级分类id为空");
		}

		ValueOperations<String, Object> ops = redisTemplate.opsForValue();
		List<DicSubType> list = null;
		if(!redisTemplate.hasKey("dic_goodsSubType_" + id)){
			DicSubType dicSubType = new DicSubType();
			dicSubType.setParentId(Integer.valueOf(id));
			dicSubType.setEnable(true);
			list = dicSubTypeMapper.getGoodsSubType(dicSubType);
			ops.set("dic_goodsSubType_" + id, list);
		} else {
			list = (List<DicSubType>) ops.get("dic_goodsSubType_" + id);
		}
		return ReturnDataUtil.getReturnMap("操作成功",list);
	}
}
