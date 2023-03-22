package com.star.common.enums.gf.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zt
 * @date 2022/12/6 11:03
 */
@AllArgsConstructor
@Getter
public enum RemarkType {
    红灯("red"),
    绿灯("green");

    private String code;
}
