package com.example.demo.controller;

import com.example.demo.service.CommodityOrderService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-16 13:16
 **/
@Controller
@RequestMapping("/bbbb")
public class ScheduleController {

    ScheduledExecutorService scheduledThreadPoolExecutor= Executors.newScheduledThreadPool(1);


    /**
     * @Description: 周期性执行任务
     * scheduleAtFixedRate方法的作用是预定在初始的延迟结束后，周期性地执行给定的任务，周期长度为period，
     * 其中initialDelay为初始延迟。
     */
    @GetMapping(value = "/bb")
    public void bb() {
        System.out.println("定时任务要开始了");

        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, World------!");
            }
            //0表示首次执行任务的延迟时间，1 示每次执行任务的间隔时间，TimeUnit.MILLISECONDS执行的时间间隔数值单位
        }, 0,1, TimeUnit.SECONDS);

    }





    /**
     * @Description: 延迟指定时间才开始执行schedule
     *
     * 常用的有TimeUnit.MILLISECONDS(毫秒)，TimeUnit.SECONDS(秒)以及TimeUnit.MINUTES(分钟)等
     */
    @GetMapping(value = "/cc")
    public void cc() {
        System.out.println("延迟要开始了");
        scheduledThreadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, World!");
            }
            //2000表示延后的时间，TimeUnit.MILLISECONDS执行的时间间隔数值单位
        }, 2000, TimeUnit.MILLISECONDS);

    }


}
