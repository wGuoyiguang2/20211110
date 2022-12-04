package com.example.demo.controller;

import com.example.demo.entity.event.AsynCustomEvent;
import com.example.demo.entity.event.SynCustomEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-06-02 11:56
 **/

@RestController
public class AsyncEventController {


    /**
     * 使用@Async实现异步
     * Spring中可以使用@Async注解标注方法异步执行，不过需要在配置类上开启异步功能，使用@EnableAsync注解，如下
     *
     * 然后 此时可以在监听方法上标注@Async注解，使得事件异步执行
     *
     *
    */
    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("/asyn/hello")
    public String hello(){
        System.out.println("事件开始发布消息："+System.currentTimeMillis()+"线程id"+Thread.currentThread().getId());
        applicationContext.publishEvent(new AsynCustomEvent(this,"嘿嘿嘿！"));
        return "success";
    }
}
