package com.example.demo.entity;

import com.example.demo.entity.annotation.Money;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:43
 **/
@Data
public class User {

    private Integer id;

    @NotBlank(message = "用户 name 非空")
    private String name;
    @Range(min = 0, max = 1, message = "性别选择错误")
    private Integer sex;


    /**
    * @Valid 可以用来 校验属性（和@validated 的主要区别），必须加这个，否则进不了 Order 里的 属性值校验
    */
//    @Valid
//    @NotEmpty(message = "orderList 非空")
//    private List<Order> orderList;

    @Money(message = "金额格式错误")
    private BigDecimal amount;


}
