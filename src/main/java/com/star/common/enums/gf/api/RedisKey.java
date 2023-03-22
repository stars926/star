package com.star.common.enums.gf.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zt
 * @date 2022/12/23 14:00
 */
@AllArgsConstructor
@Getter
public enum RedisKey {
    历史记录("home:search:history:");
    private final String code;
}
