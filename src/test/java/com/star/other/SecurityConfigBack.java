//package com.star.config;
//
//import com.star.security.filter.JwtAuthenticationTokenFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
///**
// * @author star926
// */
//@Configuration
//public class SecurityConfig {
//
//	@Autowired
//	JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
//
////	@Autowired
////	AuthenticationEntryPoint authenticationEntryPoint;
//
//	@Autowired
//	private AuthenticationSuccessHandler successHandler;
//
//	@Autowired
//	private AuthenticationFailureHandler failureHandler;
//
//	@Autowired
//	private LogoutSuccessHandler logoutSuccessHandler;
//
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		//基础配置
//		http
//				// 关闭csrf
//				.csrf().disable()
//				// 不通过Session获取SecurityContext
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and()
//				.authorizeRequests()
//				// 对于登录接口 允许匿名访问
//				.antMatchers("/login").anonymous()
//				// 除上面外的所有请求全部需要鉴权认证
//				.anyRequest().authenticated();
//
//		//添加过滤器
//		http
//				// jwt过滤器
//				.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//				// 验证码
//				//.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//
////		http
////				.formLogin(有问题)
////				// 认证成功处理器
////				.successHandler(successHandler)
////				// 认证失败处理器
////				.failureHandler(failureHandler)
////				.and()
////				.logout()
////				//配置注销成功处理器
////				.logoutSuccessHandler(logoutSuccessHandler);
//
////		//配置异常处理器
////		http.exceptionHandling()
////				//配置认证失败处理器
////				.authenticationEntryPoint(authenticationEntryPoint)
////				.accessDeniedHandler(accessDeniedHandler);
//
//		// spring security 配置允许跨域
//		http.cors();
//		return http.build();
//	}
//
//	/**
//	 * 创建BCryptPasswordEncoder注入容器
//	 *
//	 * @return BCryptPasswordEncoder
//	 */
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//}
