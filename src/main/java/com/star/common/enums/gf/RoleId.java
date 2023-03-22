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
public enum RoleId {
    一线工作人员(6L),
    社会组织管理员(22L),
    社工站点管理员(23L);

    private final long code;
}
