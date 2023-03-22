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
public enum RoleLevel {
    level_0(0),
    level_1(1),
    level_2(2),
    level_3(3),
    level_4(4),
    level_5(5);

    private final int code;

}
