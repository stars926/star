package com.star.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * 匹配特定数据约束验证器
 *
 * @author star
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue,Long> {

    private Set<Long> set = new HashSet<>();

    /**
     * 初始化方法
     * @param constraintAnnotation
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {

        int[] vals = constraintAnnotation.vals();

        for (int val : vals) {
            set.add(Long.valueOf(val));
        }

    }

    /**
     * 判断是否效验成功
     * @param value 需要效验的值
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        //判断是否有包含的值
        boolean contains = set.contains(value);

        return contains;
    }

}
