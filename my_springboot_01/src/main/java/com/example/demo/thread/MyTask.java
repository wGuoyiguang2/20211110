package com.example.demo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @program: springboot_01
 * @description:  程序中使用的是Callable接口，可以获取线程的返回值
 *                  没有返回值的  用 Runnable 接口
 * @author: guoyiguang
 * @create: 2021-07-11 11:01
 **/
@Slf4j
public class MyTask implements Callable {

    private String filename;

    public MyTask(String filename) {
        this.filename = filename;
    }


    @Override
    public Object call() throws Exception {
        // 要执行的任务

        log.info("callable  call() method thread name-----{} ,mission value----{}",Thread.currentThread().getName(),filename);
        return "返回值" + filename;
    }
}
