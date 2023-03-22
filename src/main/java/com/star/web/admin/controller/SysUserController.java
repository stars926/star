package com.star.web.admin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户
 */
@RestController
@RequestMapping("sys/user")
@Slf4j
public class SysUserController {
//	private SysUserService sysUserService;
//
//	/**
//	 * 获取登录的用户信息
//	 */
//
//	@GetMapping("/info")
//	public Result<LoginUser> info() {
//		LoginUser loginUser = SecurityUtils.getLoginUser();
//		return Result.ok(loginUser);
//	}
//
//	@GetMapping("/list")
//	public Result<List<SysUser>> list() {
//		List<SysUser> list = sysUserService.list();
//		return Result.ok(list);
//	}
//
//	/**
//	 *
//	 * @param oldPassword
//	 * @param newPassword
//	 * @return
//	 */
//	@PutMapping("/update/password")
//	public Result<Object> updatePassword(@Valid @NotBlank String oldPassword, @NotBlank String newPassword) {
//		SysUser userInfo = sysUserService.getById(SecurityUtils.getLoginUser().getSysUser().getUserId());
//
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		// 旧密码错误
//		if (!bCryptPasswordEncoder.matches(oldPassword, userInfo.getPassword())) {
//			throw new BusinessException("修改密码失败，旧密码错误");
//		}
//		// 新旧密码相同
//		if (bCryptPasswordEncoder.matches(newPassword, userInfo.getPassword())) {
//			throw new BusinessException("新密码不能与旧密码相同");
//		}
//		// 修改密码
//		userInfo.setPassword(bCryptPasswordEncoder.encode(newPassword));
//		sysUserService.updateById(userInfo);
//		return Result.ok().build();
//	}
//
//	/**
//	 * 重置密码
//	 * @param newPassword newPassword
//	 * @return
//	 */
//	@PostMapping("/reset/password")
//	public Result<Object> resetPassword(@Valid @NotBlank String newPassword) {
//		SysUser userInfo = sysUserService.getById(SecurityUtils.getLoginUser().getSysUser().getUserId());
//
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		// 修改密码
//		userInfo.setPassword(bCryptPasswordEncoder.encode(newPassword));
//		sysUserService.updateById(userInfo);
//		return Result.ok().build();
//	}
}
