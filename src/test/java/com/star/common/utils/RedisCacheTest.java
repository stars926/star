package com.star.common.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;

import java.time.Duration;

/**
 * @author star926
 * @date 2022/6/18 19:14
 */
@SpringBootTest
class RedisCacheTest {

	@Autowired
	public RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		Object o = redisTemplate.opsForValue().get("login:token:100000000");
		System.out.println(o);
		Duration duration = Duration.ofHours(1L);
		long l = Duration.ofHours(6).toHours();
		System.out.println(duration);
		System.out.println(l);
		System.out.println(TimeoutUtils.hasMillis(Duration.ofHours(6)));
	}

}