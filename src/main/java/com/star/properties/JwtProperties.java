package com.star.properties;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author zt
 * @date 2023/1/7 12:32
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

	/**
	 * 请求头名称
	 */
	private String header;

	/**
	 * 密钥
	 */
	private String secret;

	/**
	 * 签发者
	 */
	private String issuer;

	/**
	 * 过期时间（单位：小时）
	 */
	private Long expirationTime;

	/**
	 * 判断剩余多久续期（单位：小时）
	 */
	private Long renewalTime;

	/**
	 * 过期时间（单位：秒）
	 *
	 * @return 过期时间秒
	 */
	public Long getExpirationTimeToMillis() {
		return Duration.ofHours(expirationTime).toMillis();
	}

	/**
	 * 续期时长（单位：秒）
	 *
	 * @return 续期时长秒
	 */
	public Long getRenewalTimeToMillis() {
		return Duration.ofHours(renewalTime).toMillis();
	}
}
