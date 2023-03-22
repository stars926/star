//import com.star.security.exceptions.AccessDeniedHandlerImpl;
//import com.star.security.exceptions.AuthenticationEntryPointImpl;
//import com.star.security.filter.JwtAuthenticationTokenFilter;
//import com.filter.LoginParameterConversionFilter;
//import com.star.security.handler.AuthenticationFailureHandlerImpl;
//import com.star.security.handler.AuthenticationSuccessHandlerImpl;
//import com.star.security.handler.LogoutSuccessHandlerImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * securityConfig配置文件
// *
// * @author star
// */
//@RequiredArgsConstructor
//@Configuration
//@EnableWebSecurity
//@EnableGlobalAuthentication
//public class SecurityConfig60 {
//
//	private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
//	private final LoginParameterConversionFilter loginParameterConversionFilter;
//	private final AuthenticationEntryPointImpl authenticationEntryPoint;
//	private final AccessDeniedHandlerImpl accessDeniedHandler;
//	private final AuthenticationSuccessHandlerImpl authenticationSuccessHandler;
//	private final AuthenticationFailureHandlerImpl authenticationFailureHandler;
//	private final LogoutSuccessHandlerImpl logoutSuccessHandler;
//
//	@Bean
//	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
//		return http
//				// 关闭模拟请求，ApiFox测试工具等测试
//				.csrf().disable()
//				// 不通过Session获取SecurityContext
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				// 授权请求
//				.and()
//				.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
//						authorizationManagerRequestMatcherRegistry
//								// 匿名访问
//								.requestMatchers("/login").anonymous()
//								// 放权
//								.requestMatchers("/swagger/api/docs/**").permitAll()
//								// 鉴权认证
//								.anyRequest().authenticated())
//				// 添加过滤器
//				// TOKEN认证
//				.addFilterBefore(loginParameterConversionFilter, UsernamePasswordAuthenticationFilter.class)
//				.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
////				.rememberMe()
////				.rememberMeServices()
//				// 验证码
//				// 配置异常处理器
//				.exceptionHandling()
//				// 认证失败处理器
//				.authenticationEntryPoint(authenticationEntryPoint)
//				// 权限校验失败处理器
//				.accessDeniedHandler(accessDeniedHandler)
//				// 登录认证处理器，或配置userDetail
//				.and().formLogin()
//				.loginProcessingUrl("/login")
//				.usernameParameter("account")
//				.passwordParameter("password")
//				// 认证成功处理器
//				.successHandler(authenticationSuccessHandler)
//				// 认证失败处理器
//				.failureHandler(authenticationFailureHandler)
//				// 注销处理
//				.and().logout()
//				.logoutUrl("/logout")
//				// 注销成功处理器
//				.logoutSuccessHandler(logoutSuccessHandler)
//				// 允许跨域
//				.and().cors()
//				// 构建返还
//				.and().build();
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
//	/**
//	 * 获取AuthenticationManager
//	 *
//	 * @return authenticationManagerBean
//	 * @throws Exception Exception
//	 */
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//		return configuration.getAuthenticationManager();
//	}
//
//}
