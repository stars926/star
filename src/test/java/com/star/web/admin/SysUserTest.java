package com.star.web.admin;

import com.star.web.admin.converter.SysUserConverter;
import com.star.web.admin.pojo.po.SysUser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author star926
 * @date 2022/6/11 14:55
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SysUserTest {

	private final SysUserConverter sysUserConvert;

	@Test
	void contextLoads() {
		SysUser sysUser = new SysUser();
		sysUser.setUserId(1L);
		sysUser.setName("star");

		//OpenAPI openAPI = BeanUtils.getWriteMethodParameter();
		//System.out.println(openAPI);
		//sysUser.setUserTypeList(List.of((byte)1,(byte)2));
		//SysUserVo convert = sysUserConvert.convert(sysUser);
		//System.out.println(convert);
	}
}