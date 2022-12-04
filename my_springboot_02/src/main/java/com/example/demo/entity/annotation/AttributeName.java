package com.example.demo.entity.annotation;

import java.lang.annotation.*;

/** 
* @Description:  获取汉字名称的注解
* @Param:  
* @return:  
* @Author: guoyiguang
* @Date:  
*/ 
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AttributeName {
    String value() default "";
}
