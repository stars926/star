package com.star.common.enums.gf.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zt
 * @date 2022/12/8 20:38
 */
@AllArgsConstructor
@Getter
public enum WaitType {
    待办(0),
    消息(1);
    private int code;
}
