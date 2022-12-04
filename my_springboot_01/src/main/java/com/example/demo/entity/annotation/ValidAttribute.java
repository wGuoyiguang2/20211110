package com.example.demo.entity.annotation;

import java.lang.annotation.*;

/** 
* @Description:  针对库里是数字，要在前台显示 对应数字的 字段
* @Author: guoyiguang
* @Date:  
*/ 
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAttribute {
    int isDeleted() default 0;
    int isValid() default 1;
    String comments() default "数字转汉字注解";
}
