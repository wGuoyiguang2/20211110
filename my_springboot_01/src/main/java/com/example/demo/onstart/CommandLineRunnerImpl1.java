package com.example.demo.onstart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_01
 * @description: 服务启动后执行的操作
 * 注意：一定要有@Component这个注解。要不然SpringBoot扫描不到这个类,是不会执行。
 * @author: guoyiguang
 * @create: 2021-06-02 11:08
 **/
@Order(1)
@Component
public class CommandLineRunnerImpl1 implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {

        System.out.println("服务启动后执行的操作----------CommandLineRunnerImpl1-----order  1------start------");
        if (null != strings) {
            for ( String s:strings){
                System.out.println("服务启动后执行的操作----------CommandLineRunnerImpl1--order  1---"+s);
            }
        }

        System.out.println("服务启动后执行的操作----------CommandLineRunnerImpl1-------order  1---start------");


    }
}
