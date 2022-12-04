package com.example.demo.entity.ThreadResponse;

import lombok.Data;

/**
 * @program: springboot_01
 * @description: 封装子线程的处理结果
 * @author: guoyiguang
 * @create: 2021-09-30 17:09
 **/

@Data
public class ThreadResponse {


    /**
     * status  0 是 正在开始 ； status 1  是 已完成
    */ 
    private String status ;

   private String message ;

   private Long id;

    public ThreadResponse() {

    }

    public ThreadResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ThreadResponse(String status, String message,Long id) {
        this.status = status;
        this.message = message;
        this.id = id;
    }
}
