package com.star.web.admin.service;

import com.mybatisflex.core.service.IService;
import com.star.web.admin.pojo.dto.RegisterUserDTO;
import com.star.web.admin.pojo.po.SysUser;

/**
 * @author abcqwez
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * 注册用户
	 *
	 * @param registerUserDto 注册信息
	 * @return true:成功 false:失败
	 */
	Boolean registerUser(RegisterUserDTO registerUserDto);

}
