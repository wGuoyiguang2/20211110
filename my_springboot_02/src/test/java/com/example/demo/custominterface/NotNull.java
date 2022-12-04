package com.example.demo.custominterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
// 次注解作用于类和字段上
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface NotNull {
    // 定义属性
    String value () default  "设置默认值，或者设置业务值";
    String description () default "设置默认值，或者设置业务值";
}
