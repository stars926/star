package com.star.web.admin.controller;

import com.nimbusds.jose.JOSEException;
import com.star.common.result.Result;
import com.star.web.admin.pojo.dto.LoginDTO;
import com.star.web.admin.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 登录接口
 *
 * @author star926
 */
@Tag(name = "用户登录")
@RestController
@RequiredArgsConstructor
@RequestMapping("login")
public class LoginController {

	private final LoginService loginService;

	@Operation(summary = "登录")
	@PostMapping
	public Result<String> login(@RequestBody LoginDTO loginDTO) throws JOSEException {
		return Result.ok(loginService.login(loginDTO));
	}

}
