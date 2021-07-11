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
 * 定时任务
 * 1。可以设置在特定时间将缓存中的数据进行持久化
 * 2。也可以设定每隔一段时间进行持久化操作
 * @Author LINZHIPIN
 * @CreateTime 2021/07/10/00010 13:11:41
 */
@Configuration
public class PersistentTask {
	@Resource(name = "redisTemplateOfJson")
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private UserService userService;

	/*
	 *   设置在每天凌晨3点进行持久化，将redis中用户收藏的商品数据进行持久化
	 *   redis中的结构设计如下:
	 *     key为coll_goodsId
	 *     value为json格式的UserCollection，有,userId、createTime、editTime、state
	 */
	@Scheduled(cron = "0 0 3 * * ?")
	//@Scheduled(fixedRate = 3000)
	public void saveCollectionGoods() throws HandleCacheException {
		String keyPattern = "coll_*";
		Set<String> keys = redisTemplate.keys(keyPattern);
		SetOperations<String, Object> ops = redisTemplate.opsForSet();
		//将Redis中set集合获取到的数据进行持久化操作
		for(String key : keys) {
			Set<Object> members = ops.members(key);
			for(Object o  : members) {
				//这里还需要日志记录
				if(!(o instanceof UserCollection)) {
					throw new HandleCacheException("redis中存储的数据在转化过程中出现异常!");
				}
				UserCollection uc = (UserCollection) o;
				//业务处理中如果存在异常就会抛出，因此这里不用判断操作成功或者操作失败
				userService.updateUserCollections(uc);
			}
		}
		//处理完成后删除keys
		redisTemplate.delete(keys);
	}
}
