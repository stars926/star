package com.star.common.exceptions;

import com.star.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 统一异常处理
 *
 * @author star926
 */
@Slf4j(topic = "GlobalExceptionHandler")
@RestControllerAdvice(basePackages = {"com.star.web"})
public class GlobalExceptionHandler {

	/**
	 * 所有未收集的异常
	 *
	 * @param throwable Throwable
	 * @return BAD_REQUEST
	 */
	//@ExceptionHandler(value = Throwable.class)
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	//public Result<String> handleThrowableException(Throwable throwable) {
	//	log.error("未收集异常：{}", throwable.getMessage());
	//	log.error("异常类型：{}", throwable.getClass());
	//	return Result.error(BizCodeEnum.UNKNOWN_EXCEPTION).build();
	//}

	/**
	 * Http请求参数转换异常，一般处理日期转换异常
	 *
	 * @param e HttpMessageNotReadableException
	 * @return BAD_REQUEST
	 */
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result<String> handleConversionException(HttpMessageNotReadableException e) {
		log.warn("Http请求参数转换异常：{}", e.getMessage());
		log.warn("异常类型：{}", e.getClass());
		return Result.error(BizCodeEnum.CONVERSION_EXCEPTION).build();
	}

	/**
	 * 方法参数无效异常，一般处理效验参数异常
	 *
	 * @param e MethodArgumentNotValidException
	 * @return BAD_REQUEST
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result<Map<String, String>> handleValidException(MethodArgumentNotValidException e) {
		log.warn("数据效验异常：{}", e.getMessage());
		log.warn("异常类型：{}", e.getClass());
		Map<String, String> map = e
				.getBindingResult()
				.getFieldErrors()
				.stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		return Result.error(BizCodeEnum.VALID_EXCEPTION).data(map);
	}

	/**
	 * 拦截器异常，一般处理XSS攻击
	 *
	 * @param e FilterException
	 * @return BAD_REQUEST
	 */
	@ExceptionHandler(FilterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result<Object> handleBusinessException(FilterException e) {
		log.error("拦截器异常：{}", e.getMessage());
		log.error("异常类型：{}", e.getClass());
		return Result.error(BizCodeEnum.Filter_EXCEPTION).build();
	}

	/**
	 * 业务异常，一般处理业务异常
	 *
	 * @param e BusinessException
	 * @return INTERNAL_SERVER_ERROR
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result<Object> handleBusinessException(BusinessException e) {
		log.warn("业务数据：{}", e.getMessage());
		log.warn("异常类型：{}", e.getClass());
		return Result.error(BizCodeEnum.VALID_EXCEPTION).build();
	}

	/**
	 * 约束异常，SQL完整性约束冲突异常
	 *
	 * @param e BusinessException
	 * @return INTERNAL_SERVER_ERROR
	 */
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result<Object> handleDuplicateKeyException(BusinessException e) {
		log.warn("业务数据：{}", e.getMessage());
		log.warn("异常类型：{}", e.getClass());
		return Result.error(BizCodeEnum.SQL_INTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION).build();
	}

}
