package com.example.demo.config;

import cn.hutool.core.thread.RejectPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @description 线程池配置
 *
 */
@Configuration
public class ThreadPoolConfig {


    @Bean("deletePicThreadPoolExecutor")
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(10,
                10,
                300,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100000),
                RejectPolicy.CALLER_RUNS.getValue());
    }
}
