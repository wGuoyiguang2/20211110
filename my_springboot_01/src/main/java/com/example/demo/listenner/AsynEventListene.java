package com.example.demo.listenner;

import com.example.demo.entity.event.AsynCustomEvent;
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
public class AsynEventListene {

    /** 
    *      @Async  指定异步执行
    */ 
    @EventListener(SynCustomEvent.class)
  //  @Async
    public void onApplicationEvent(AsynCustomEvent customEvent){
        System.out.println("异步 接收到的消息为："+customEvent.getMessage());
    }
}
