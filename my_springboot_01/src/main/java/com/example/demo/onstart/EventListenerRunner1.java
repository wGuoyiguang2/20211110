package com.example.demo.onstart;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_01  说明： 这个没有生效
 * @description: 事件监听 监听到  服务启动后触发的工作 ；可以触发spring默认的一些事件
 * @author: guoyiguang
 * @create: 2021-06-02 11:21
 **/
@Component
public class EventListenerRunner1  implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println(" 服务启动后 监听检测到了 EventListenerRunner1");
    }
}
