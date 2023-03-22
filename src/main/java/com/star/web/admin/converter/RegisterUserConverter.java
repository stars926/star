package com.star.web.admin.converter;

import com.star.web.admin.pojo.dto.RegisterUserDTO;
import com.star.web.admin.pojo.po.SysUser;
import org.mapstruct.Mapper;

/**
 * @author zt
 * @date 2023/1/5 23:25
 */
@Mapper(componentModel = "spring")
public interface RegisterUserConverter {

	SysUser registerUserDtoToSysUser(RegisterUserDTO registerUserDto);
}
