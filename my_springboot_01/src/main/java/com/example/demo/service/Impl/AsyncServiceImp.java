package com.example.demo.service.Impl;

import com.example.demo.entity.Boy;
import com.example.demo.service.AsyncService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalDateTime;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-07-11 13:24
 **/
@Service
@Slf4j
public class AsyncServiceImp implements AsyncService {

    @Async
    @Override
    public void doNoReturn() {
        try {
            long start = System.currentTimeMillis();
            log.info(" thread name ------>  {} ; 方法执行开始 ------>  {}",Thread.currentThread().getName(),LocalDateTime.now());
            // 这个方法执行需要三秒
            Thread.sleep(3000);
            long end = System.currentTimeMillis();
            log.info(" thread name ------>  {} ; 方法执行结束 ------>  {}",Thread.currentThread().getName(),LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    @Async
    @Override
    public ListenableFuture<Boy> execute01AsyncWithListenableFuture() {
        try {
            log.info("进入了执行任务 thread ...... threadName {}",Thread.currentThread().getName());
            return AsyncResult.forValue(getBoy());
        } catch (Throwable ex) {
            return AsyncResult.forExecutionException(ex);
        }
    }


    @SneakyThrows
    public Boy getBoy(){
        Thread.sleep(6000L);
        Boy boy = new Boy();
        boy.setName(String.valueOf(Math.random()));
        boy.setSex(1);
        boy.setChaodai("汉朝");
        return boy;

    }
}
