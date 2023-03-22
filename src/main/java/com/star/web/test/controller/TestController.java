package com.star.web.test.controller;

import com.nimbusds.jose.JOSEException;
import com.star.common.result.Result;
import com.star.common.utils.JwtUtils;
import com.star.web.admin.pojo.po.SysUser;
import org.springframework.web.bind.annotation.*;

/**
 * 测试
 *
 * @author star926
 */

@RequestMapping("test")
@RestController
public class TestController {

	@GetMapping
	public Result<Boolean> page() {
		return Result.ok(true);
	}
	@GetMapping("login")
	public Result<Boolean> login() throws JOSEException {
		String jwt = JwtUtils.createJwt("1");
		return Result.ok(true);
	}

//	@Autowired
//	private SysUserService sysUserService;
//
//	@Autowired
//	private RedisTemplate redisTemplate;
//
//	/**
//	 * 分页
//	 */
//	@Cacheable(value = "page", key = "'page'")
//	@GetMapping("page")
//	public Result<Page<SysUser>> page(@RequestBody Page<SysUser> page) {
//		return Result.ok().build();
//	}
//
//	/**
//	 * 缓存
//	 *
//	 * @return
//	 */
//	@GetMapping("cache")
//	public Result<List<SysUser>> cache() {
//		Result<List<SysUser>> o = (Result<List<SysUser>>) redisTemplate.opsForValue().get("info::info");
//
//		return o;
//	}
//
//	@Cacheable(value = "page", key = "'page'")
//	@GetMapping("result")
//	public Result page2() {
////		return Result.ok().data("123");
////		return Result.ok().build();
//		return Result.ok("123");
////		return Result.error().data("123");
////		return Result.error().build();
////		return Result.error("123");
//	}
}
