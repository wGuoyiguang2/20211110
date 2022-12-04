package com.example.demo.entity;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:43
 **/
@Data
public class Order {

    private Integer id;

    @NotBlank(message= "orderGUID 非空")
    private String orderGUID;
    private String name;
    private String description;

    /**
    *  以下属性测试mybatis插件
    */
    private String createdGUID;
    private String updatedGUID;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    private String delFlag;



    private List<OrderDetail> orderDetailChildren;


    private String orderDetailsTypeStr;








}
