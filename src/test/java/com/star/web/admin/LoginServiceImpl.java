package com.star.web.admin;

import com.nimbusds.jose.JOSEException;
import com.star.common.constant.RedisConstants;
import com.star.web.admin.pojo.bo.LoginUser;
import com.star.web.admin.pojo.dto.LoginDTO;
import com.star.web.admin.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author abcqwez
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final AuthenticationManager authenticationManager;

	public final RedisTemplate<String, Object> redisTemplate;

	@Override
	public String login(LoginDTO loginDTO) throws JOSEException {
		// 构建认证对象
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getAccount(), loginDTO.getPassword());
		// AuthenticationManager 认证，没通过则通过认证适配器给出对应的提示
		Authentication authenticate = authenticationManager.authenticate(authenticationToken);

		// 认证失败
		//Assert.isTrue(Objects.nonNull(authenticate), "登录失败，请刷新后重试!");

		// 使用userId生成一个token并返回
		LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
		String userId = String.valueOf(loginUser.getSysUser().getUserId());

		// 将userId作为key，用户信息作为value存入redis
		redisTemplate.opsForValue().set(RedisConstants.getTokenKey(userId), loginUser, Duration.ofHours(6));

		//return JwtUtil.createJwt(userId);
		return null;
	}

	//@Override
	//public Result<String> logout() {
	//	//获取SecurityContextHolder中的用户id
	//	UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
	//	LoginUser loginUser = (LoginUser) authentication.getPrincipal();
	//	Long userid = loginUser.getSysUser().getId();
	//
	//	//删除redis中的值
	//	redisTemplate.delete("login:token:" + userid);
	//	return Result.ok("注销成功");
	//}
}
