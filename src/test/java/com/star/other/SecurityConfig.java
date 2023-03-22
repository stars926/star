//package com.star.config;
//
//import com.star.security.filter.JwtAuthenticationTokenFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
////@Configuration
//@RequiredArgsConstructor
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig{
//
//	private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
//    private final AuthenticationEntryPoint authenticationEntryPoint;
//    private final AccessDeniedHandler accessDeniedHandler;
//
//	private final UserDetailsService userDetailsService;
//	/**
//	 * 安全配置
//	 *
//	 * @param http http
//	 * @throws Exception Exception
//	 */
//	@Bean
//	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//				//关闭csrf
//				.csrf().disable()
//				//不通过Session获取SecurityContext
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and()
//				.authorizeRequests()
//				// 对于登录接口 允许匿名访问
//				.antMatchers("/login").anonymous()
//				// 除上面外的所有请求全部需要鉴权认证
//				.anyRequest().authenticated();
//
//		// 添加过滤器
//		http
//				.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//
//		// 配置异常处理器
//		http
//				.exceptionHandling()
//				//配置认证失败处理器
//				.authenticationEntryPoint(authenticationEntryPoint)
//				.accessDeniedHandler(accessDeniedHandler);
//
//		// spring security 配置允许跨域
//		http.cors();
//
////		http.csrf()
////				.disable()
////				.httpBasic()
////				.disable()
////				.formLogin()
////				.successHandler(authenticationSuccessHandler)
////				.failureHandler(authenticationFailureHandler)
////				.permitAll()
////				.and()
////				.logout()
////				.logoutSuccessHandler(logoutSuccessHandler)
////				.and()
////				.authorizeRequests()
////				.antMatchers("/wxmp/api/**")
////				.permitAll()
////				.anyRequest()
////				.authenticated()
////				.and()
////				.sessionManagement()
////				.disable()
////				.exceptionHandling()
////				.accessDeniedHandler(accessDeniedHandler)
////				.authenticationEntryPoint(authenticationEntryPoint)
////				.and()
////				.apply(httpConfiguration)
////				.and()
////				.build();
//
//		return http.build();
//	}
//
//	@Bean
//	public AuthenticationProvider daoAuthenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//		// 这里要隐藏系统默认的提示信息，否则一直显示账户或密码错误
//		daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
//		return daoAuthenticationProvider;
//	}
//
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//		return configuration.getAuthenticationManager();
//	}
//
//}
