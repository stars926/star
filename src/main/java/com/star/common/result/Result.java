package com.star.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.star.common.exceptions.BizCodeEnum;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serial;
import java.io.Serializable;

/**
 * 返回数据，不返回空值
 *
 * @author star926
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private int status;

	private String message;

	private T data;

	/**
	 * 用于Jackson反序列化
	 */
	public Result() {
	}

	public Result(int status, T data) {
		this.status = status;
		this.data = data;
	}

	public Result(int status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	/**
	 * 设置响应状态
	 *
	 * @param status 状态码
	 * @return ResultBuilder构造器
	 */
	public static Result.ResultBuilder status(Integer status) {
		Assert.notNull(status, "响应状态不能为空");
		return new Result.DefaultBuilder(status);
	}

	public static Result.ResultBuilder status(Integer status, String message) {
		Assert.notNull(status, "响应状态不能为空");
		return new Result.DefaultBuilder(status, message);
	}

	/**
	 * 默认成功：0
	 */
	public static Result.ResultBuilder ok() {
		return status(0);
	}

	public static <T> Result<T> ok(T data) {
		return ok().data(data);
	}

	public static Result.ResultBuilder error() {
		return status(BizCodeEnum.UNKNOWN_EXCEPTION.getCode());
	}

	public static Result.ResultBuilder error(BizCodeEnum bizCodeEnum) {
		Assert.notNull(bizCodeEnum, "响应状态不能为空");
		return new Result.DefaultBuilder(bizCodeEnum.getCode(), bizCodeEnum.getMsg());
	}

	public interface ResultBuilder {
		/**
		 * 赋予data值
		 *
		 * @param data 值
		 * @param <T>  值类型
		 * @return 结果集
		 */
		<T> Result<T> data(T data);

		/**
		 * 构建出Result
		 *
		 * @param <T> 值类型
		 * @return 结果集
		 */
		<T> Result<T> build();
	}

	private static class DefaultBuilder implements ResultBuilder {
		private int status;
		private String message;

		public DefaultBuilder() {
		}

		public DefaultBuilder(int status) {
			this.status = status;
		}

		public DefaultBuilder(int status, String message) {
			this.status = status;
			this.message = message;
		}

		@Override
		public <T> Result<T> data(T data) {
			return new Result<>(this.status, this.message, data);
		}

		@Override
		public <T> Result<T> build() {
			return new Result<>(this.status, this.message, null);
		}
	}

}
