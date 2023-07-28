package com.star.web.admin.mapper;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryCondition;
import com.star.web.admin.pojo.po.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author zt
 * @date 2022/10/24 19:09
 */
@SpringBootTest
public class MybatisPlusTest {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Test
	void testNull(){
		List<SysUser> sysUsers = sysUserMapper.selectListByCondition(QueryCondition.createEmpty());
		System.out.println(sysUsers);
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
