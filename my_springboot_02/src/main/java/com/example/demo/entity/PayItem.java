package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-08 21:31
 **/
@Data
public class PayItem {


    public PayItem() {

    }
    public PayItem(LocalDate time, BigDecimal value) {
        this.time = time;
        this.value = value;
    }

    LocalDate time;

    BigDecimal value;
}
