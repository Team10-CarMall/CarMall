package com.team10.config;

import com.team10.exception.HandleCacheException;
import com.team10.user.mapper.UserCollectionMapper;
import com.team10.user.model.UserCollection;
import com.team10.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/10/00010 13:11:41
 */
@Configuration
public class PersistentTask {
	@Resource(name = "redisTemplateOfJson")
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private UserCollectionMapper userCollectionMapper;
	@Autowired
	private UserService userService;

	/*
	*   设置在每天晚上12点进行持久化，将redis中用户收藏的商品数据进行持久化
	*   redis中的结构设计如下:
	*     key为coll_goodsId
	*     value为json格式的UserCollection，有,userId、createTime、editTime、state
	* */
	@Scheduled(cron = "0 0 0 * * ?")
	public void saveCollectionGoods() throws HandleCacheException {
		Set<String> keys = redisTemplate.keys("coll_*");
		SetOperations<String, Object> ops = redisTemplate.opsForSet();

		for(String key : keys) {
			Set<Object> members = ops.members(key);
			for(Object o  : members) {
				//这里还需要日志记录
				UserCollection uc = (UserCollection) o;
				uc.setGoodsId(key.substring(5));
				if(userService.updateUserCollections(uc) != true) {
					throw new HandleCacheException("处理用户" + uc.getUserId());
				}
			}
		}
		redisTemplate.delete(keys);
	}
}
