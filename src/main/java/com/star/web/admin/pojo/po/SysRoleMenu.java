package com.star.web.admin.pojo.po;

import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 菜单
 *
 * @author star926
 * @since 2022-06-16
 */
@Data
@Table("sys_role_menu")
public class SysRoleMenu implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 菜单ID
	 */
	private Long menuId;
}