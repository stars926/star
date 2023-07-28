package com.star.common.base;

import com.mybatisflex.annotation.Column;
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
	@Column(onInsertValue = "now()")
	private Long createBy;

	/**
	 * 创建时间
	 */
	@Column(onInsertValue = "now()")
	private LocalDate createTime;

	/**
	 * 更新者
	 */
	@Column(onUpdateValue = "now()")
	private Long updateBy;

	/**
	 * 更新时间
	 */
	@Column(onUpdateValue = "now()")
	private LocalDate updateTime;

}
