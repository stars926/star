package com.star.web.admin.converter;

import org.mapstruct.Mapper;

import com.star.web.admin.pojo.po.SysUser;
import com.star.web.admin.pojo.vo.SysUserVO;

/**
 * @author zt
 * @date 2023/1/3 19:32
 */
@Mapper(componentModel = "spring")
public interface SysUserConverter {

	SysUserVO sysUserToSysUserVo(SysUser sysUser);
}
