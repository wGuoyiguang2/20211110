package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-07-22 15:55
 **/
@Data
public class TestEntity {

    private String timeStr ;

    private LocalDateTime lt ;
}
