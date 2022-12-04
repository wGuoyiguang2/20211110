package com.example.demo.entity.event;

import org.springframework.context.ApplicationEvent;

/**
 * @program: springboot_01
 * @description:  继承  ApplicationEvent  自定义事件；同步事件
 * @author: guoyiguang
 * @create: 2021-06-02 11:51
 **/
public class SynCustomEvent extends  ApplicationEvent  {

    
    /** 
    * 要封装的消息，可以是自定义对象
    */ 
    private String message;
    public SynCustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    /**
     * 调用 getMessage 获取 被封装的消息
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
