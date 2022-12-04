package com.example.demo.entity.container;

import lombok.Data;

/**
 * @program: my_springboot_03
 * @description:
 * @author: gyg
 * @create: 2021-11-11 17:10
 **/
@Data
public class Label {
    private String alertname ;

    private String namespace ;

    private String pod ;

    private String severity ;
}
    
    