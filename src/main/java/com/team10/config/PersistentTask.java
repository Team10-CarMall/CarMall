package com.team10.config;

import com.team10.user.mapper.UserCollectionMapper;
import com.team10.user.model.UserCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
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

	//设置在每天晚上12点进行持久化，将redis中用户收藏的商品数据进行持久化
	@Scheduled(cron = "0 0 24 * * ?")
	public void saveCollectionGoods() {
		Set<String> keys = redisTemplate.keys("colls_*");
		ValueOperations<String, Object> ops = redisTemplate.opsForValue();
		for(String key : keys) {
			UserCollection uc = (UserCollection) ops.get(key);
		}
	}

}
