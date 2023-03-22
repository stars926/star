package com.star.web.admin.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author abcqwez
 */
@Data
@Schema(name  = "注册信息")
public class RegisterUserDTO implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@Schema(title = "登录名")
	private String account;

	@Schema(title = "用户名")
	private String name;

	@Schema(title = "密码")
	private String password;

	@Schema(title = "邮箱")
	private String email;

	@Schema(title = "手机号")
	private String phone;
}
