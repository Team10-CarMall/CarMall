package com.team10.util;

import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *  redis的工具类，这里也基本没用上
 */
public class RedisUtil {

	//设置储存的DataBase
	public static void setDataBase(int index) {
		RedisTemplate<String, Object> jsonTemplate = (RedisTemplate<String, Object>) SpringUtil.getBean("redisTemplateOfJson");
		LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory) jsonTemplate.getConnectionFactory();
		connectionFactory.setDatabase(index);
	}
}
