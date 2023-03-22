package com.star.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.star.web.admin.converter.SysUserConverter;
import com.star.web.admin.mapper.SysUserMapper;
import com.star.web.admin.pojo.bo.LoginUser;
import com.star.web.admin.pojo.po.SysUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * 认证详情
 *
 * @author abcqwez
 */
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final SysUserConverter sysUserConverter;

	private final SysUserMapper sysUserMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 查询用户信息，若没有则抛出异常
		SysUser user = Optional
				.ofNullable(new LambdaQueryChainWrapper<>(sysUserMapper).eq(SysUser::getAccount, username).one())
				.orElseThrow(() -> new UsernameNotFoundException("用户名或者密码错误！"));

		// 查询用户权限信息
		Set<String> permits = sysUserMapper.selectPermsByUserId(user.getUserId());

		// 封装成UserDetails并返回
		return new LoginUser(sysUserConverter.sysUserToSysUserVo(user), permits);
	}
}
