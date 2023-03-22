package com.star.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * @author zt
 * @date 2023/1/5 23:30
 */
@Data
public class BaseEntity implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 创建者
	 */
	@TableField(fill = FieldFill.INSERT)
	private Long createBy;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDate createTime;

	/**
	 * 更新者
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long updateBy;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDate updateTime;

}
