package com.example.demo.utils;

import com.example.demo.entity.annotation.Money;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * @program: springboot_01
 * @description: 校验金额
 * @author: guoyiguang
 * @create: 2021-05-07 14:10
 **/
public class MoneyValidator implements ConstraintValidator<Money,BigDecimal> {


    @Override
    public void initialize(Money money) {

    }

    @Override
    public boolean isValid(BigDecimal bigDecimal, ConstraintValidatorContext constraintValidatorContext) {
        // 不能为空
        if (null == bigDecimal) {
            return false;
        }
        String  regExp= "^(([0-9]|([1-9][0-9]{0,9}))((\\.[0-9]{1,2})?))$";
        return  bigDecimal.toString().matches(regExp);

    }
}
