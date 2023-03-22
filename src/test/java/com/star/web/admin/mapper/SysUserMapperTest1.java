package com.star.web.admin.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

/**
 * @author star926
 * @date 2022/6/16 1:14
 */

@SpringBootTest
//@RequiredArgsConstructor
class SysUserMapperTest1 {

	@Autowired
	private  SysUserMapper sysMenuMapper;

	@Test
	void selectPermsByUserId() {
		Long userId = 100000000L;
		Set<String> stringSet = sysMenuMapper.selectPermsByUserId(userId);
		System.out.println(stringSet);
	}
}