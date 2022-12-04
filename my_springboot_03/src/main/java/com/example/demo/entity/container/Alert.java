package com.example.demo.entity.container;

import lombok.Data;

/**
 * @program: my_springboot_03
 * @description:
 * @author: gyg
 * @create: 2021-11-11 17:06
 **/
@Data
public class Alert {
    private String status ;


    private Label labels ;

    private Annotation annotations ;

    /**
     * 2021-09-16T09:06:13.167936072Z
    */
    private String startsAt;

    /**
     * 2021-09-16T09:10:13.167936072Z
     */
    private String endsAt;

}
    
    