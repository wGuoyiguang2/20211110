package com.example.demo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-04-18 20:26
 **/
@Data
public class OrderDetail {

    @NotBlank(message= " OrderDetail id 非空")
    private  String id ;

    @NotBlank(message= " OrderDetail orderGUID 非空")
    private  String orderGUID ;

    private  Integer ordernum ;


    private  String orderType ;



}
