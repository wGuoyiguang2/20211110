package com.example.demo.custominterface;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// 次注解作用于类和字段上
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface CutString {
    int maxLength () default  10;
    int minLength () default  0;
    String description () default  "请输入字段汉语描述";
}
