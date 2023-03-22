package com.star.common.enums.gf.draft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 *  学习类型
 *
 * @date 2022/11/14 16:15
 */
@AllArgsConstructor
@Getter
@Slf4j
public enum DraftType {
    后台未成年(0),
    后台低收入(1),
    后台为老老人(2),
    后台其他人员(3),
    后台养老老人(4),
    APP未成年(5),
    APP低收入(6),
    APP为老老人(7),
    APP其他人员(8);
    private Integer code;

}
