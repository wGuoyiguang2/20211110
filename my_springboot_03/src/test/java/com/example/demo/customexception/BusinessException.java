package com.example.demo.customexception;

/**
 * @program: springboot_01
 * @description:
 * @create: 2021-01-12 15:53
 **/
public class BusinessException extends RuntimeException {
    private Integer code;
    private String  msg;
    public BusinessException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 这个get方法不可丢 需要将错误信息 返给前端的
    public String getMsg() {
        return msg;
    }
}
