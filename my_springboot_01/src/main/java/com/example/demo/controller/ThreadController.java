package com.example.demo.controller;


import com.example.demo.entity.Boy;
import com.example.demo.entity.ThreadResponse.ThreadResponse;
import com.example.demo.entity.exception.BizException;
import com.example.demo.service.AsyncService;
import com.example.demo.service.BoySerivce;
import com.example.demo.thread.MyTask;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @program: springboot_01
 * @description:  线程 控制器
 * @author: guoyiguang
 * @create: 2021-01-16 13:16
 **/
@RestController
@RequestMapping("/thread")
@Slf4j
public class ThreadController {




    /**
     * 创建线程池，并发量最大为5
     * LinkedBlockingDeque，表示执行任务或者放入队列
     */
    ThreadPoolExecutor excutor = new ThreadPoolExecutor(5, 10, 0,
            TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(),
            new ThreadPoolExecutor.CallerRunsPolicy());


    @Autowired
    AsyncService asyncService ;


    @Autowired
    BoySerivce boySerivce ;





    @Autowired
    private ThreadPoolExecutor deletePicThreadPoolExecutor;




    @PostMapping(value="a0" )
    @ResponseBody
    public String a0() throws ExecutionException, InterruptedException {
        System.out.println("hhhhhhh1 "+Thread.currentThread().getName());

        deletePicThreadPoolExecutor.execute(() -> {
            try {
                System.out.println("hhhhhhh2 "+Thread.currentThread().getName());
            } catch (Exception e) {
                log.error("异步处理调用其他模块失败，已忽略异常", e);
            }
        });
        return  "";
    }


    @PostMapping(value="a" )
    @ResponseBody
    public String a() throws ExecutionException, InterruptedException {

        log.info("request thread name-----{}",Thread.currentThread().getName());
        //存储线程的返回值
        List<Future<String>> results = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            Future<String> result = excutor.submit(task);
            // 收集返回值
            results.add(result);
        }

        //输出结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            // 获取返回值
            sb.append(results.get(i).get());
            sb.append(" ");
        }
        return  sb.toString();
    }


    @PostMapping(value="b" )
    public long b() throws ExecutionException, InterruptedException {
        log.info("request thread name-----{}",Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        asyncService.doNoReturn();
        long end = System.currentTimeMillis();
        return end - start;

    }


    @PostMapping(value="c" )
    public long c() throws ExecutionException, InterruptedException {
        log.info("request thread name-----{}",Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        doNoReturn2();
        long end = System.currentTimeMillis();
        return end - start;

    }

    @Async
    public void doNoReturn2() {
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






    @PostMapping(value="d" )
    public long d() throws ExecutionException, InterruptedException {
        long now = System.currentTimeMillis();
        log.info("threadName {}",Thread.currentThread().getName());

        // 执行任务
        ListenableFuture<Boy> execute01Result = asyncService.execute01AsyncWithListenableFuture();
        //  增加成功的回调
        execute01Result.addCallback(new SuccessCallback<Boy>() {

            @Override
            public void onSuccess(Boy result) {
                log.info("[onSuccess] threadName {} , result: {} ", Thread.currentThread().getName(),result);
            }

            //  增加失败的回调
        }, new FailureCallback() {

            @Override
            public void onFailure(Throwable ex) {
                log.info("[onFailure][发生异常]", ex);
            }

        });


        // <2.2> 增加成功和失败的统一回调
        execute01Result.addCallback(new ListenableFutureCallback<Boy>() {

            @Override
            public void onSuccess(Boy result) {
                log.info("[onSuccess] threadName {} , result: {} ", Thread.currentThread().getName(),result);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.info("[onFailure][发生异常]", ex);
            }

        });
        // <3> 阻塞等待结果
        // execute01Result.get();

        log.info("任务执行，消耗时长 {} 毫秒]", System.currentTimeMillis() - now);
        return System.currentTimeMillis() - now;

    }




    // 子线程可以获取父线程的私有变量，但是 是 copy ，子线程修改是修改 自己的，修改不了父线程的
    // private InheritableThreadLocal<ThreadResponse> exThreadLocal = new InheritableThreadLocal();

    private Map<Long,ThreadResponse> exThreadMap = new ConcurrentHashMap<>();


    
    /** 
    * @Description:  ① 手动创建线程池
    * @Param:  
    * @return:  
    * @Author: guoyiguang
    * @Date:  
    */ 
    @PostMapping(value="f")
    public void f() throws ExecutionException, InterruptedException {


        ThreadResponse tr  = new ThreadResponse("0", "正在开始");
        exThreadMap.put(Thread.currentThread().getId(),tr);
        long mainThreadId = Thread.currentThread().getId();
        new Thread(() -> {
            try {
                Thread.currentThread().setName("insert boy Runnable Thread");
                System.out.println("run start ...，,thread name "+Thread.currentThread().getName());
                Long i = 0L;
                while(i<=500){
                    if (i==500L){
                        // 内部异常会 回滚事务
                        boySerivce.insertBoy();
                    }

                    // 返回执行结果
                    i++;
                }
                System.out.println("run end ...");
                exThreadMap.put(mainThreadId,new ThreadResponse("1","成功"));
                long id = Thread.currentThread().getId();


            } catch (Exception e) {
                System.out.println(e.getMessage());
                exThreadMap.put(mainThreadId,new ThreadResponse("2",e.getMessage()));
                // 说明： 子线程  抛出异常了，主线程 是没法处理的
                // throw BizException.wrap("更新数据失败，请稍后重试~");
                System.out.println(e.getMessage());


            }
        }).start();


        System.out.println("main  thread name "+Thread.currentThread().getName());

        // 阻塞
        while(exThreadMap.get(mainThreadId).getStatus().equals("0")){
            System.out.println("hhhhhhh");
        }
        // 子线程 异常了
        ThreadResponse threadResponse = exThreadMap.get(mainThreadId);
        if (threadResponse.getStatus().equals("2")){
            throw BizException.wrap(threadResponse.getMessage());
        }


    }






    /** 
    * @Description: ②  ExecutorService  线程池
    * @Param:  
    * @return:  
    * @Author: guoyiguang
    * @Date:  
    */ 
    ExecutorService executor = Executors.newCachedThreadPool();
    @SneakyThrows
    @PostMapping(value="g")
    public void g() throws IOException, ExecutionException, InterruptedException, IllegalAccessException, InstantiationException {
        // executor
        System.out.println("main  thread ......"+Thread.currentThread().getName());
        ThreadResponse tr  = new ThreadResponse("0", "正在开始");
        long mainThreadId = Thread.currentThread().getId();
        exThreadMap.put(mainThreadId,tr);

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                // 以异步方式在新的线程中执行耗时的操作
                Long i = null;
                try {
                    System.out.println("run start ...");
                    i = 0L;
                    while(i<500L){
                        throw BizException.wrap("更细失败,请稍后重试~");
                    }
                    System.out.println("run end ...");
                    exThreadMap.put(mainThreadId,new ThreadResponse("1","成功"));
                } catch (Exception e) {
                    exThreadMap.put(mainThreadId,new ThreadResponse("2",e.getMessage()));
                    return 0 ;
                }

                // 返回执行结果
                i++;
                return 1;
            }
        });

        // main thread do  something  else


        // then
        Integer result = future.get(1, TimeUnit.SECONDS);
        if (result == 0){
            ThreadResponse threadResponse = exThreadMap.get(mainThreadId);
            throw BizException.wrap(threadResponse.getMessage());
        }


    }



    /**
     * @Description:  给出的错误提示不友好
     * @Param:
     * @return:
     * @Author: guoyiguang
     * @Date:
     */

    @SneakyThrows
    @PostMapping(value="h")
    public void h() throws IOException, ExecutionException, InterruptedException {
        System.out.println("main  thread ......"+Thread.currentThread().getName());
        String  token = "token123456789" ;
        CompletableFuture<Integer> future =   CompletableFuture.supplyAsync(() -> {
            System.out.println("run start ...");
            Long i = 0L;
            while(i<500L){
                throw BizException.wrap("更新失败，请稍后重试~");
            }
            System.out.println(token);
            System.out.println("run end ...");

            // 返回执行结果
            i++;
            return 1;
        });


        try {
            Integer integer = future.get();
            // 获取异常信息
        }catch (ExecutionException  e) {
            // BizException [message=更新失败，请稍后重试~, code=-1, extraCode=-1, extraMsg=-1]
            System.out.println(e.getMessage());

        } catch (BizException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

    /**
    * @Description:  ③ 解决方案
    * @Param:
    * @return:
    * @Author: guoyiguang
    * @Date:
    */
    @PostMapping(value="i")
    public void i() throws IOException, ExecutionException, InterruptedException, IllegalAccessException, InstantiationException {
        // executor
        System.out.println("main  thread ......" + Thread.currentThread().getName());
        String token = "token123456789";
        long mainThreadId = Thread.currentThread().getId();
        ThreadResponse tr  = new ThreadResponse("0", "正在开始");
        exThreadMap.put(mainThreadId,tr);


        CompletableFuture<Integer> future =   CompletableFuture.supplyAsync(() -> {
            System.out.println("run start ...");
            Long i = 0L;
            try {
                while(i<500L){
                    throw BizException.wrap("更细失败,请稍后重试~");
                }

                System.out.println("run end ...");
                exThreadMap.put(mainThreadId,new ThreadResponse("1","成功"));
            } catch (Exception e) {
                exThreadMap.put(mainThreadId,new ThreadResponse("2",e.getMessage()));
                return 0;
            }

            // 返回执行结果
            i++;
            return 1;
        });


        // main thread do  something  else


        // then
        // 阻塞
        Integer integer = future.get();
        boolean completedExceptionally = future.isCompletedExceptionally();
        // false ：原因 异常被捕获了
        System.out.println(completedExceptionally);
        if (integer == 0){
            ThreadResponse threadResponse = exThreadMap.get(mainThreadId);
            throw BizException.wrap(threadResponse.getMessage());
        }




    }












}
