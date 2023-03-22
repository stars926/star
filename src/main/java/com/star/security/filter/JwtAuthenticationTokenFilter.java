package com.star.security.filter;

import com.star.common.constant.RedisConstants;
import com.star.common.utils.JwtUtils;
import com.star.web.admin.pojo.bo.LoginUser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * token校验
 *
 * @author star926
 */
@Component
@RequiredArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private final RedisTemplate<String, Object> redisTemplate;

	@SneakyThrows
	@Override
	protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) {
		// 获取token
		String token = request.getHeader(JwtUtils.getHeader());
		// token不存在，则放行交由后续过滤器
		if (!StringUtils.hasText(token)) {
			// 放行
			filterChain.doFilter(request, response);
			return;
		}

		// 认证过期，给出提示
		Assert.isTrue(!JwtUtils.isExpiration(token), "认证已过期，请重新登录！");
		// 进入过期时间，则刷新token
		if (JwtUtils.isExpiringSoon(token)) {
			response.setHeader(JwtUtils.getHeader(), JwtUtils.freshJwt(token));
			//redis刷新时间
		}

		// 解析token，SneakyThrows包装处理异常
		String userid = JwtUtils.parseJwt(token);

		// 从redis中获取用户信息
		LoginUser loginUser = (LoginUser) redisTemplate.opsForValue().get(RedisConstants.getTokenKey(userid));
		Assert.notNull(loginUser, "用户尚未登录，请重新登录!");

		// 获取权限信息封装到Authentication中
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
		// 存入SecurityContextHolder
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		// 放行
		filterChain.doFilter(request, response);
	}
}
