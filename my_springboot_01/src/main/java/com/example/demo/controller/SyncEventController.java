package com.example.demo.controller;

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
public class SyncEventController {


    /**
    * 事件发布
     * Spring中发布事件的接口是ApplicationEventPublisher，我们可以自定义自己的类，当然也可以使用spring现成的类
     * Spring的事件发布类
     * ApplicationContext
     * AnnotationConfigApplicationContext
     *
     * 在容器启动刷新的时候已经注入了ApplicationEventPublisher的实现，我们可以直接注入使
    *
    */
    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("syn/hello")
    public String hello(){
        System.out.println("事件开始发布消息："+System.currentTimeMillis());
         // 自定义事件
        applicationContext.publishEvent(new SynCustomEvent(this,"嘿嘿嘿！"));
        return "success";
    }
}
