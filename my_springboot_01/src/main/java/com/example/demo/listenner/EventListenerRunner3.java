package com.example.demo.listenner;

import com.example.demo.entity.event.SynCustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_01
 * @description: 事件监听
 * @author: guoyiguang
 * @create: 2021-06-02 11:21
 **/
@Component
public class EventListenerRunner3 {

    /** 
    *      @Async  指定一步执行
    */ 
    @EventListener(SynCustomEvent.class)
//    @Async  // 异步接受消息
    public void onApplicationEvent(SynCustomEvent customEvent){
        System.out.println("接收到的消息为："+customEvent.getMessage());
    }
}
