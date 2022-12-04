package com.example.demo.entity.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @program: springboot_01
 * @description:  //@JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
 * // @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
 * @author: guoyiguang
 * @create: 2021-07-31 15:33
 **/
@Data
public class Person {

    private Date createdDate;

    // 向前段展示
    @JsonFormat( pattern = "yyyy-MM-dd",timezone="GMT+8")
    private LocalDateTime createdTime;


    @JsonIgnore
    private BigDecimal money ;
}
