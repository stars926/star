package com.star.common.enums.gf.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zt
 * @date 2022/12/6 10:02
 */
@AllArgsConstructor
@Getter
public enum ReadStatus {
    未读(0),
    已读(1);
    private int code;
}
