//package com.star.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
///**
// * @author star926
// * @date 2022/6/17 9:09
// */
//@Component
//public class A implements AuthenticationManager {
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
////		// 这里我们自定义了验证通过条件：username与password相同就可以通过认证
//////		 if (authentication.getName().equals(authentication.getCredentials())) {
//		boolean matches = passwordEncoder.matches((String) authentication.getCredentials(),"$2a$10$R9RKM0k..RwGKgVhjNUnNeLyzprXBEEiqJEoEk/GdCKzZhqGwqoqK");
//
//		if (authentication.getName().equals("admin") && matches) {
//				 return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), null);
//		 }
////		 // 没有通过认证则抛出密码错误异常
//		throw new BadCredentialsException("Bad Credentials");
////		new WebSecurityConfigurerAdapter.AuthenticationManagerDelegator(this.authenticationBuilder, this.context);
//	}
//}
