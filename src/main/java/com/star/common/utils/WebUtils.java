package com.star.common.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.io.IOException;

/**
 * @author abcqwez
 */
@Configuration
public class WebUtils {

	/**
	 * 将字符串渲染到客户端
	 *
	 * @param response 渲染对象
	 * @param string   待渲染的字符串
	 */
	public static void renderString(HttpServletResponse response, String string) throws IOException {
		response.setStatus(HttpStatus.OK.value());
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(string);
	}
}