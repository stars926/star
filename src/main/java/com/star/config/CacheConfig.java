package com.star.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存配置
 *
 * @author star926
 */
@EnableCaching
@Configuration
public class CacheConfig {

	/**
	 * 配置文件的配置
	 *
	 * @return RedisCacheConfiguration redis缓存配置
	 */
	@Bean
	public RedisCacheConfiguration redisCacheConfiguration() {
		return RedisCacheConfiguration
				// 默认配置
				.defaultCacheConfig()
				// 统一过期时间
				.entryTtl(Duration.ofHours(1))
				// 配置key序列化
				.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
				// 配置value序列化
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

	/**
	 * 指定 key 策略
	 *
	 * @return redisCacheConfigurationMap
	 */
	private Map<String, RedisCacheConfiguration> redisCacheConfigurationMap() {
		return new HashMap<>(16);
	}

	/**
	 * 配置redisTemplate操作模板序列化
	 *
	 * @param redisConnectionFactory 构建工厂
	 * @return redisTemplate
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

		// key使用StringRedisSerializer来序列化和反序列化
		redisTemplate.setKeySerializer(stringRedisSerializer);
		// Value使用Jackson2JsonRedisSerializer来序列化和反序列化
		redisTemplate.setValueSerializer(jsonRedisSerializer);

		// Hash的key采用StringRedisSerializer的序列化方式
		redisTemplate.setHashKeySerializer(stringRedisSerializer);
		// Hash的Value使用Jackson2JsonRedisSerializer来序列化和反序列化
		redisTemplate.setHashValueSerializer(jsonRedisSerializer);

		redisTemplate.setConnectionFactory(redisConnectionFactory);

		return redisTemplate;
	}

	/**
	 * 自定义序列化
	 *
	 * @return Jackson2JsonRedisSerializer
	 */
	public Jackson2JsonRedisSerializer<Object> jsonRedisSerializer() {
		Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
		jsonRedisSerializer.setObjectMapper(objectMapper);

		return jsonRedisSerializer;
	}


}
