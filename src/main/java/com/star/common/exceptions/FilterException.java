package com.star.common.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serial;

/**
 * 自定义异常：业务异常
 *
 * @author star926
 */
public class FilterException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;

	private String message;
	private int code = HttpStatus.INTERNAL_SERVER_ERROR.value();

	public FilterException(String message) {
		super(message);
		this.message = message;
	}

	public FilterException(String message, int code) {
		super(message);
		this.message = message;
		this.code = code;
	}

	public FilterException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}

	public FilterException(String message, int code, Throwable e) {
		super(message, e);
		this.message = message;
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
