package com.star.common.enums.gf.site;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 个人擅长领域
 *
 * @author zt
 * @date 2022/11/14 16:15
 */
@AllArgsConstructor
@Getter
public enum WorkerField {
    活动组织(0),
    实施(1),
    方案策划(2);
    private int code;
}
