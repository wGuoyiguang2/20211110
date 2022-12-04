package com.example.demo.onstart;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: springboot_01
 * @description: 服务启动后执行的操作  2
 * 注意：一定要有@Component这个注解。要不然SpringBoot扫描不到这个类,是不会执行。
 * @author: guoyiguang
 * @create: 2021-06-02 11:08
 **/
@Order(3)
@Component
public class CommandLineRunnerImpl2 implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {

        System.out.println("服务启动后执行的操作----------CommandLineRunnerImpl2------order  3-----start------");
        if (null != strings) {
            for ( String s:strings){
                System.out.println("服务启动后执行的操作----------CommandLineRunnerImpl2--order  3----"+s);
            }
        }
        System.out.println("服务启动后执行的操作----------CommandLineRunnerImpl2--------order  3---start------");

    }
}
