package com.star.web.admin.pojo.po;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import com.star.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色
 *
 * @author star926 
 * @since  2022-06-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_role")
public class SysRole extends BaseEntity {
	/**
	* 角色ID
	*/
	@Id
	private Long userId;

	/**
	* 角色名称
	*/
	private String name;

	/**
	* 角色权限字符串
	*/
	private String key;

	/**
	* 角色状态（0正常 1停用）
	*/
	private Integer status;

	/**
	* del_flag
	*/
	private Integer delFlag;

	/**
	* 备注
	*/
	private String remark;

}