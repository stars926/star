package com.star.common.enums.gf;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是否
 *
 * @author ruoyi
 */
@AllArgsConstructor
@Getter
public enum SysYesNo {
    是(1),否(0);

    private final Integer code;

}
