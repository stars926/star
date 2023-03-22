package com.star.common.enums.gf;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 操作状态
 *
 * @author ruoyi
 */
@AllArgsConstructor
@Getter
public enum SysDelFlag {

    删除(2),
    存在(0);

    private final Integer code;
}
