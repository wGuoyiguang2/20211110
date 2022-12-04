package com.example.demo.entity.annotation;


import com.example.demo.utils.MoneyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/** 
* @Description: 金额校验
* @Author: guoyiguang
*/ 
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
// 指定 这个注解 用哪个校验器去校验
@Constraint(validatedBy = MoneyValidator.class)
public @interface Money {
    String   message ()  default  "money 不合法 ";
    // 下面两行必须加否则报错
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
