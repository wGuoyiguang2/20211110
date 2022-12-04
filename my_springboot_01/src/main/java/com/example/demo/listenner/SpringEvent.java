package com.example.demo.listenner;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_01
 * @description: spring
 *
 * 监听器用来监听事件触发，一旦事件触发了，监听器会执行相应的操作。
 * 监听器的实现有两种方式： ① 实现ApplicationListener接口 ② 使用@EventListener注解
 *
 *
 **/
@Component
public class SpringEvent {

    /**
    * @Param:   event 传入的事件源
    */ 
    @EventListener(classes = {ApplicationEvent.class})
    public void onApplicationEvent(ApplicationEvent  event){


        if (event instanceof ContextRefreshedEvent) {
            ContextRefreshedEvent e=(ContextRefreshedEvent)event;
            System.out.println("ContextRefreshedEvent启动了........");
            System.out.println(event.getSource() + "---->" + event.getTimestamp() + "----" + e.getApplicationContext());
            System.out.println(".........................................");
        }else if(event instanceof ContextStartedEvent){
            ContextStartedEvent e=(ContextStartedEvent)event;
            System.out.println("ContextStartedEvent启动了........");
            System.out.println(event.getSource() + "---->" + event.getTimestamp() + "----" + e.getApplicationContext());
            System.out.println(".........................................");
        }else if(event instanceof ContextStoppedEvent){
            ContextStoppedEvent e=(ContextStoppedEvent)event;
            System.out.println("ContextStoppedEvent启动了........");
            System.out.println(event.getSource() + "---->" + event.getTimestamp() + "----" + e.getApplicationContext());
            System.out.println(".........................................");
        }else if(event instanceof ContextClosedEvent){
            ContextClosedEvent e=(ContextClosedEvent)event;
            System.out.println("ContextClosedEvent启动了........");
            System.out.println(event.getSource() + "---->" + event.getTimestamp() + "----" + e.getApplicationContext());
            System.out.println(".........................................");
        }
    }
}
