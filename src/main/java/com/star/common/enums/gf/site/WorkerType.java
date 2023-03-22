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
public enum WorkerType {
    持证(0),
    非持证(1),
    志愿者(2),
    其他工作人员(3);
    private int code;
}
