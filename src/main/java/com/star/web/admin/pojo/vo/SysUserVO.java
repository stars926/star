package com.star.web.admin.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 系统用户
 *
 * @author star926
 * @since 1.0.0 2022-06-16
 */
@Data
public class SysUserVO implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long userId;

	/**
	 * 登录账户
	 */
	private String account;

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 账号状态（0正常 1停用）
	 */
	private Integer status;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 用户性别（0男，1女，2未知）
	 */
	private Byte sex;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 用户类型（0管理员，1普通用户）
	 */
	private Byte type;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 反序列化忽略
	 *
	 * @return password
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * 序列化接收
	 *
	 * @param password password
	 */
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
}