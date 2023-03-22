package com;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 *
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 *
 * @author Mark sunlightcs@gmail.com
 */
public class ValidatorUtils {
	private static Validator validator = Validation.buildDefaultValidatorFactory()
			.getValidator();
	public static void beanValidate(Object obj) throws Exception {
		Map<String, String> validatedMsg = new HashMap<>();
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);
		for (ConstraintViolation<Object> c : constraintViolations) {
			validatedMsg.put(c.getPropertyPath().toString(), c.getMessage());
		}
		if (CollectionUtils.isNotEmpty(constraintViolations)) {
			throw new Exception();
		}

	}
//    static {
//        validator = Validation.buildDefaultValidatorFactory().getValidator();
//    }
//
//    /**
//     * 校验对象
//     * @param object        待校验对象
//     * @param groups        待校验的组
//     * @throws RuntimeException  校验不通过，则报RRException异常
//     */
//    public static void validateEntity(Object object, Class<?>... groups) throws RuntimeException {
//        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
//        if (!constraintViolations.isEmpty()) {
//            StringBuilder msg = new StringBuilder();
//            for (ConstraintViolation<Object> constraint : constraintViolations) {
//                msg.append(constraint.getMessage()).append("<br>");
//            }
//            throw new RuntimeException(msg.toString());
//        }
//    }

//    public static void validateEntity(Object object, Constant.CloudService type) {
//        validateEntity(object, type.getValidatorGroupClass());
//    }
}
