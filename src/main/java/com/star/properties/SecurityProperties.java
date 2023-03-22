package com.star.properties;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

/**
 * @author zt
 * @date 2023/1/6 17:43
 */
@Data
@Validated
@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
	/**
	 * 匿名访问
	 */
	private String[] anonymous;

	/**
	 * 无认证访问
	 */
	private String[] permitAll;
}
