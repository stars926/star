package com.star.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/***
 * 错误码和错误信息定义类
 * 1. 错误码定义规则为5位数字
 * 2. 前两位表示业务场景，最后三位表示错误码。例如：100000。10:通用 000:系统未知异常
 * 3. 维护错误码后需要维护错误描述，将他们定义为枚举形式
 *
 * 错误码列表：
 *  10: 通用
 *      001：参数格式校验
 *  11: 用户
 *  12: 商品
 *
 * @author star
 */
@Getter
@AllArgsConstructor
public enum BizCodeEnum {
	/**
	 * 10：通用；000：系统未知异常
	 */
	UNKNOWN_EXCEPTION(10000, "系统未知异常"),
	/**
	 * 10：通用；001：参数格式校验异常
	 */
	VALID_EXCEPTION(10001, "参数格式校验失败"),

	/**
	 * 10：通用；002：拦截器异常
	 */
	Filter_EXCEPTION(10003, "Http请求参数转换异常"),

	/**
	 * 10：通用；003：Http请求参数转换异常
	 */
	CONVERSION_EXCEPTION(10003, "Http请求参数转换异常"),

	/**
	 * 10：通用；004：唯一索引异常
	 */
	SQL_INTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION(10004, "数据不符合唯一性")
	;

	private final int code;
	private final String msg;
}
