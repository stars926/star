//package com.star.config;
//
//import com.star.security.filter.JwtAuthenticationTokenFilter;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.stereotype.Component;
//
///**
// * @author zt
// * @date 2022/9/15 0:27
// */
//@Component
//public class HttpConfiguration extends AbstractHttpConfigurer<HttpConfiguration, HttpSecurity> {
//
//	@Override
//	public void configure(HttpSecurity builder) {
//		AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
//		builder.addFilter(new JwtAuthenticationTokenFilter(authenticationManager));
//	}
//}
