package com.star.common.enums.gf.unit;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 操作状态
 *
 * @author ruoyi
 */
@AllArgsConstructor
@Getter
public enum UnitType {
    系统(0),
    股室(1),
    政府(2),
    相关部门(3);
    private int code;
}
