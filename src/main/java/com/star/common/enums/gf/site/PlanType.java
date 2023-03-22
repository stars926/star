package com.star.common.enums.gf.site;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 社工类型
 *
 * @author zt
 * @date 2022/11/14 16:15
 */
@AllArgsConstructor
@Getter
public enum PlanType {
    月度报表(0),
    年度报表(1);
    private int code;
}
