package com.team10.util;

import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtil {

	//可不用
	public static void setDataBase(int index) {
		RedisTemplate<String, Object> jsonTemplate = (RedisTemplate<String, Object>) SpringUtil.getBean("redisTemplateOfJson");
		LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory) jsonTemplate.getConnectionFactory();
		connectionFactory.setDatabase(index);
	}
}
