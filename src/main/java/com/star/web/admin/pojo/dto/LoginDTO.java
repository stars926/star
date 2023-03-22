package com.star.web.admin.pojo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author zt
 * @date 2022/9/22 1:28
 */
@Data
@Schema(name = "登录信息")
public class LoginDTO {

	@Schema(title = "登录账户")
	private String account;

	@Schema(title = "密码")
	private String password;

	@Schema(title = "是否记住登录")
	private Boolean rememberMe;
}
