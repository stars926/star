package com.star.common.annotation;

import java.lang.annotation.*;

/**
 * 操作日志注解，保存至ES中
 *
 * @author star926
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	/**
	 * 模块
	 */
	String title() default "";
//
//	/**
//	 * 功能
//	 */
//	BusinessType businessType() default BusinessType.OTHER;
//
//	/**
//	 * 操作人类别
//	 */
//	OperatorType operatorType() default OperatorType.MANAGE;

	/**
	 * 是否保存请求的参数
	 */
	boolean isSaveRequestData() default true;

	/**
	 * 是否保存响应的参数
	 */
	boolean isSaveResponseData() default true;

	String value() default "";
}
