package com.star.common.enums.gf.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户角色
 *
 * @author ruoyi
 */

@AllArgsConstructor
@Getter
public enum AppUserType {
    一线工作人员("staff"),
    地名信息员乡镇管理员("place"),
    其他管理员("other"),
    非法用户("illegal");
    private final String code;
}
