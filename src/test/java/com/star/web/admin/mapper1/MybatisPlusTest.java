package com.star.web.admin.mapper1;

import com.star.web.admin.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author zt
 * @date 2022/10/24 19:09
 */
@SpringBootTest
//@RequiredArgsConstructor
public class MybatisPlusTest {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Test
	void testNull(){
// 		List<SysUser> list = new LambdaQueryChainWrapper<>(sysUserMapper).list();
// 		List<SysUser> list2 = new LambdaQueryChainWrapper<>(sysUserMapper).in(false,SysUser::getUserId,List.of()).list();
// 		List<SysUser> list3 = sysUserMapper.selectBatchIds(List.of(1));
//
// //		System.out.println(CollectionUtils.isEmpty(list2));
// 		System.out.println(list);
// 		System.out.println(list2);
// 		System.out.println(list3);
	}
}
