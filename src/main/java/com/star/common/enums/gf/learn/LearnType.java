package com.star.common.enums.gf.learn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 *  学习类型
 *
 * @date 2022/11/14 16:15
 */
@AllArgsConstructor
@Getter
@Slf4j
public enum LearnType {
    线上(0),
    线下(1);
    private Integer code;

}
