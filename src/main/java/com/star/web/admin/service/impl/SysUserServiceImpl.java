package com.star.web.admin.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.star.common.exceptions.BusinessException;
import com.star.web.admin.converter.RegisterUserConverter;
import com.star.web.admin.mapper.SysUserMapper;
import com.star.web.admin.pojo.dto.RegisterUserDTO;
import com.star.web.admin.pojo.po.SysUser;
import com.star.web.admin.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 系统用户
 *
 * @author abcqwez
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	private final RegisterUserConverter registerUserConverter;

	private final PasswordEncoder passwordEncoder;

	@Override
	public Boolean registerUser(RegisterUserDTO registerUserDto) {
		SysUser sysUser = registerUserConverter.registerUserDtoToSysUser(registerUserDto);

		// 校验唯一性
		Assert.isTrue(!checkAccountUnique(sysUser.getAccount()), "账号已经存在，请修改账号！");

		// 加密
		sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));

		// return SqlHelper.retBool(baseMapper.insert(sysUser));
		return true;
	}

	/**
	 * 校验账号是否唯一
	 *
	 * @param account 账号
	 * @return true：账号存在
	 */
	protected Boolean checkAccountUnique(String account) {
		return false;
		// return baseMapper.exists(new LambdaQueryWrapper<SysUser>().eq(SysUser::getAccount, account));
	}
}