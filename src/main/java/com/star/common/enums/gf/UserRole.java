package com.star.common.enums.gf;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户角色
 *
 * @author ruoyi
 */

@AllArgsConstructor
@Getter
public enum UserRole {
    超级管理员("admin"),
    平台管理员("plat"),
    机构管理员("org"),
    为老机构管理员("org_old"),
    养老机构管理员("org_elder"),
    社会组织管理员("org_social"),
    社工站站长("org_site"),
    一线工作人员("staff"),
    地名信息员("place"),
    乡镇管理员("town");
    private final String code;
}
