package com.example.demo.onstart;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @program: springboot_01
 * @description: 事件监听 监听到  服务启动后触发的工作 ；可以触发spring默认的一些事件
 * @author: guoyiguang
 * @create: 2021-06-02 11:21
 **/
@Configuration
public class EventListenerRunner2  {

    @EventListener(classes = {SpringApplicationEvent.class})
    public void listen(SpringApplicationEvent event) {
        System.out.println(" 服务启动后 注解事件触发：" + event.getClass().getName());
    }
}
