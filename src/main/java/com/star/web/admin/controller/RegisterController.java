package com.star.web.admin.controller;

import com.star.common.result.Result;
import com.star.common.validator.group.AddGroup;
import com.star.web.admin.pojo.dto.RegisterUserDTO;
import com.star.web.admin.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 注册验证
 *
 * @author abcqwez
 */
@Tag(name = "用户注册")
@RestController
@RequiredArgsConstructor
@RequestMapping("register")
public class RegisterController {

	private final SysUserService sysUserService;

	@Operation(summary = "用户注册")
	@PostMapping
	public Result<Boolean> register(@Validated(AddGroup.class)
									@RequestBody RegisterUserDTO registerUserDto) {
		return Result.ok(sysUserService.registerUser(registerUserDto));
	}
}
