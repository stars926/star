package com.star.common.enums.gf.site;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 学历
 *
 * @author zt
 * @date 2022/11/14 16:15
 */
@AllArgsConstructor
@Getter
public enum WorkerEdu {
    初中(0),
    高中(1),
    专科(2),
    本科(3),
    研究生(4);
    private int code;
}
