package com.example.demo.onstart;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_01
 * @description: 服务启动后执行的操作
 * 注意：一定要有@Component这个注解。要不然SpringBoot扫描不到这个类,是不会执行。
 * @author: guoyiguang
 * @create: 2021-06-02 11:08
 **/
@Order(4)
@Component
public class ApplicationRunnerImpl2 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println("服务启动后执行的操作----------ApplicationRunnerImpl2-----order  4-----start------");
        if (null != applicationArguments) {
            for ( String s:applicationArguments.getNonOptionArgs()){
                System.out.println("服务启动后执行的操作----------ApplicationRunnerImpl2---rder  4--"+s);
            }
        }
        System.out.println("服务启动后执行的操作----------ApplicationRunnerImpl2------rder  4----start------");

    }
}
