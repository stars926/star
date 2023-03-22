package com.star.common.enums.gf.site;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 持证等级
 *
 * @author zt
 * @date 2022/11/14 16:15
 */
@AllArgsConstructor
@Getter
public enum WorkerCertLevel {
    初级(0),
    中级(1),
    高级(2);
    private int code;
}
