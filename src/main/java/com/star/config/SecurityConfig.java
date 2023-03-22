package com.star.config;

import com.star.properties.SecurityProperties;
import com.star.security.exceptions.AccessDeniedHandlerImpl;
import com.star.security.exceptions.AuthenticationEntryPointImpl;
import com.star.security.filter.JwtAuthenticationTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * securityConfig配置文件
 *
 * @author star
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SecurityConfig {

	private final SecurityProperties securityProperties;

	private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

	private final AuthenticationEntryPointImpl authenticationEntryPoint;

	private final AccessDeniedHandlerImpl accessDeniedHandler;

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http
				// 关闭模拟请求，ApiFox测试工具等测试
				.csrf().disable()
				// 不通过Session获取SecurityContext
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				// 授权请求
				.and().authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
						authorizationManagerRequestMatcherRegistry
								// 匿名访问
								.requestMatchers(securityProperties.getAnonymous()).anonymous()
								// 放权
								.requestMatchers(securityProperties.getPermitAll()).permitAll()
								// 鉴权认证
								.anyRequest().authenticated())
				// jwt认证过滤器
				.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
//				.rememberMe()
//				.rememberMeServices()
				// 配置异常处理器
				.exceptionHandling()
				// 过滤器认证失败处理器
				.authenticationEntryPoint(authenticationEntryPoint)
				// 权限校验失败处理器
				.accessDeniedHandler(accessDeniedHandler)
				// 允许跨域
				.and().cors()
				// 构建返还
				.and().build();
	}

	/**
	 * 创建BCryptPasswordEncoder注入容器
	 *
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 获取AuthenticationManager
	 *
	 * @return authenticationManagerBean
	 * @throws Exception Exception
	 */
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

}
