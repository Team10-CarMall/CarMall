package com.team10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * redis的相关配置
 * 暂时只用到了以json格式存储的数据，若需要可以添加以序列化的方式存储
 * @Author LINZHIPIN
 * @CreateTime 2021/07/08/00010 13:11:41
 */
@Configuration
public class RedisConfig {

	//创建一个以json形式存储数据的redisTemplate
	@Bean("redisTemplateOfJson")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		template.setDefaultSerializer(jackson2JsonRedisSerializer);
		//template.setValueSerializer(jackson2JsonRedisSerializer);
		return template;
	}
}
