package com.star.web.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.star.common.validator.ListValue;
import com.star.common.validator.group.UpdateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


/**
 * 记录类使用，校验参数传值
 *
 * @author star926
 * @date 2022/6/14 20:17
 */
public record SysUserRecord(@NotNull(groups = {UpdateGroup.class})
							@ListValue(vals = {0})
							Long id,
							@NotBlank
							String username,
							@NotBlank
							String password,
							@NotNull
							Byte enabled,
							LocalDate createTime,
							LocalDate updateTime,
							@JsonInclude
							Byte isnullM) {
}
