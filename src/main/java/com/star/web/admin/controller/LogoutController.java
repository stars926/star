package com.star.web.admin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zt
 * @date 2023/1/6 22:24
 */
@Tag(name = "用户登出")
@RestController
@RequiredArgsConstructor
@RequestMapping("logout")
public class LogoutController {

	@Operation(summary = "登出")
	@PostMapping
	public void logout() {

	}
}
