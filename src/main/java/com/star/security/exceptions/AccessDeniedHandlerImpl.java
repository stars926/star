package com.star.security.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.star.common.result.Result;
import com.star.common.utils.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 权限校验失败实现类
 *
 * @author abcqwez
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		ObjectMapper objectMapper = new ObjectMapper();
		String data = objectMapper.writeValueAsString(Result.status(HttpStatus.FORBIDDEN.value(), "操作权限不足！").build());

		//处理异常
		WebUtils.renderString(response, data);
	}
}
