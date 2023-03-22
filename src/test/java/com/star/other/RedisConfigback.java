//package com.star.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author star926
// */
////@EnableCaching
//@Configuration
//public class RedisConfigback {
//
//
////	/**
////	 * 配置文件的配置没有用上
////	 * @return
////	 */
////	@Bean
////	public RedisCacheConfiguration redisCacheConfiguration() {
////
////		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
////		// config = config.entryTtl();
////		config = config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
////		config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
////
//////		CacheProperties.Redis redisProperties = cacheProperties.getRedis();
//////		//将配置文件中所有的配置都生效
//////		if (redisProperties.getTimeToLive() != null) {
//////			config = config.entryTtl(redisProperties.getTimeToLive());
//////		}
//////		if (redisProperties.getKeyPrefix() != null) {
//////			config = config.prefixKeysWith(redisProperties.getKeyPrefix());
//////		}
//////		if (!redisProperties.isCacheNullValues()) {
//////			config = config.disableCachingNullValues();
//////		}
//////		if (!redisProperties.isUseKeyPrefix()) {
//////			config = config.disableKeyPrefix();
//////		}
////
////		return config;
////	}
//
//	@Autowired
//	private RedisConnectionFactory redisConnectionFactory;
//
//	/***
//	 * 设置RedisTemplate规则
//	 *
//	 * @return
//	 */
//	@Bean
//	public RedisTemplate<Object, Object> redisTemplate() {
//		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
//
//		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//		Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//		objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//		jsonRedisSerializer.setObjectMapper(objectMapper);
//
//		// key使用StringRedisSerializer来序列化和反序列化
//		redisTemplate.setKeySerializer(stringRedisSerializer);
//		// Value使用Jackson2JsonRedisSerializer来序列化和反序列化
//		redisTemplate.setValueSerializer(jsonRedisSerializer);
//		// Hash的key采用StringRedisSerializer的序列化方式
//		redisTemplate.setHashKeySerializer(stringRedisSerializer);
//		// Hash的Value使用Jackson2JsonRedisSerializer来序列化和反序列化
//		redisTemplate.setHashValueSerializer(jsonRedisSerializer);
//		redisTemplate.setConnectionFactory(redisConnectionFactory);
//		redisTemplate.afterPropertiesSet();
//
//		return redisTemplate;
//	}
//}