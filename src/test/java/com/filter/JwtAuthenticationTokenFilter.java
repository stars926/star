package com.filter;

import com.star.common.utils.JwtUtils;
import com.star.web.admin.pojo.bo.LoginUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * token校验
 *
 * @author star926
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        // 获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        String loginUrl = request.getServletPath();
        //TODO
        if ("/login".equals(loginUrl)) {
            // 问题在于默认获取为表单格式，提前可以将json转为request
            // form格式转换并且放行
            Map paramter = new HashMap(16);
            paramter.put("account", "admin");
            paramter.put("password", "password");
            ParameterRequestWrapper wrapper = new ParameterRequestWrapper(request, paramter);
            filterChain.doFilter(wrapper, response);
//            filterChain.doFilter(request, response);
            return;
        }

        // 解析token
        String userid;
        try {
            userid = JwtUtils.parseJwt(token);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }

        // 从redis中获取用户信息
        String redisKey = "login:token:" + userid;
        LoginUser loginUser = (LoginUser) redisTemplate.opsForValue().get(redisKey);
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("用户未登录");
        }
        Collection<? extends GrantedAuthority> authorities = loginUser.getAuthorities();

        // 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,authorities);
        // 存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        filterChain.doFilter(request, response);
    }
}
