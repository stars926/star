package com.star.web.admin.pojo.po;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.star.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单
 *
 * @author star926 
 * @since  2022-06-16
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Table("sys_menu")
public class SysMenu extends BaseEntity {
	@Id
	private Long menuId;

	/**
	* 菜单名
	*/
	private String name;

	/**
	* 路由地址
	*/
	private String path;

	/**
	* 组件路径
	*/
	private String component;

	/**
	* 菜单状态（0显示 1隐藏）
	*/
	private Integer visible;

	/**
	* 菜单状态（0正常 1停用）
	*/
	private Integer status;

	/**
	* 权限标识
	*/
	private String permits;

	/**
	* 菜单图标
	*/
	private String icon;

	/**
	* 是否删除（0未删除 1已删除）
	*/
	private Integer delFlag;

	/**
	* 备注
	*/
	private String remark;

}