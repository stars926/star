package com.star.common.utils;

import com.star.web.admin.pojo.bo.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 安全工具
 *
 * @author star926
 */
public class SecurityUtils {

	/**
	 * 获取用户
	 **/
	public static LoginUser getLoginUser() {
		try {
			return (LoginUser) getAuthentication().getPrincipal();
		} catch (Exception e) {
			throw new RuntimeException("获取用户信息异常");
		}
	}

	/**
	 * 获取Authentication
	 */
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
