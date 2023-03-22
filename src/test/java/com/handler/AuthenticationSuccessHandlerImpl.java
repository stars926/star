package com.handler;

import com.star.web.admin.pojo.bo.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * 认证成功适配器
 *
 * @author abcqwez
 */
@Component
@RequiredArgsConstructor
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    public RedisTemplate<String, Object> redisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 认证通过，使用userId生成一个token并返回
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String userId = loginUser.getSysUser().getUserId().toString();
        String token = null;
        //try {
        //    //token = JwtUtil.createJwt(userId);
        //} catch (JOSEException e) {
        //    e.printStackTrace();
        //}
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("userInfo", loginUser.getSysUser());
        map.put("permits", loginUser.getPermissions());

        // 将userId作为key，用户信息作为value存入redis
        redisTemplate.opsForValue().set("login:token:" + userId, loginUser, Duration.ofHours(6));
        System.out.println("认证成功了");
    }
}
