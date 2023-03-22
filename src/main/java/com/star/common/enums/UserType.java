package com.star.common.enums;

/**
 * 用户角色
 *
 * @author zt
 */
public enum UserType {
    admin("00"),
    user("10");
    private final String code;

    UserType(String code) {
        this.code = code;
    }
}
