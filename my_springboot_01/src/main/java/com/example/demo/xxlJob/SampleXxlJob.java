package com.example.demo.xxlJob;

import com.example.demo.entity.Refundset;
import com.example.demo.entity.SOrder;
import com.example.demo.mapper.OrderSOrderMapper;
import com.example.demo.mapper.RefundsetMapper;
import com.example.demo.service.order.OrderSOrderService;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * XxlJob开发示例（Bean模式）
 *
 * 开发步骤：
 *      1、任务开发：在Spring Bean实例中，开发Job方法；
 *      2、注解配置：为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 *      3、执行日志：需要通过 "XxlJobHelper.log" 打印执行日志；
 *      4、任务结果：默认任务结果为 "成功" 状态，不需要主动设置；如有诉求，比如设置任务结果为失败，可以通过 "XxlJobHelper.handleFail/handleSuccess" 自主设置任务结果；
 *
 * @author xuxueli 2019-12-11 21:52:51
 */
@Component
public class SampleXxlJob {
    private static Logger logger = LoggerFactory.getLogger(SampleXxlJob.class);
    
    @Autowired
    RefundsetMapper refundsetMapper;

    @Autowired
    OrderSOrderService orderSOrderService;



    @Autowired
    @Qualifier("orderSOrderMapper")
    OrderSOrderMapper sOrderMapper;







    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");

        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        // default success
    }



    /**
     * 1、简单任务示例 2（Bean模式）
     */
    @XxlJob("refundSetJobHandler")
    @Transactional(rollbackFor = Exception.class)
    public void refundSetJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");
        XxlJobHelper.log("XXL-JOB, main thread name" ,Thread.currentThread().getName());
        List<Refundset> refundSetList = refundsetMapper.getRefundSetList();


        // 不能用多线程
//        new Thread (()->new Runnable(){
//            @Override
//            public void run() {
//                System.out.println("hhhhh");
//
//            }
//
//        }).start();

        //第一个任务。
        refundSetList.forEach(e->{
            XxlJobHelper.log(" job  thread name  {} , 分期id  为 {} ",Thread.currentThread().getName(),e.getXProjguid());
        });

        // 为什么 要加 service 层，没有service ,事务不好控制， mapper 已经入库，但是走到一半抛了异常，数据也没有回滚
        LocalDateTime now = LocalDateTime.now();
        SOrder sOrder = new SOrder();
        sOrder.setCreatedGuid("000000000000");
        sOrder.setCreatedTime(now);
        sOrder.setUpdatedGuid("000000000000");
        sOrder.setUpdatedTime(now);
        sOrder.setDescription("嘿嘿");
        sOrder.setId(1);
        sOrder.setName("订单1");
        // 这个method 会正常入库
        int insertOrderCount = sOrderMapper.insert(sOrder);

        XxlJobHelper.log(" insert  s_order count {}   ",insertOrderCount);

        // s_order 表里插入数据 ，boy 表里插入数据，同时 这两个表的 insert 都加了事务，但是 boy的 insert 方法 有  /0 的异常，下面的method 不会正常入库
        //  orderSOrderService.insertOrder() 这个方法开启了事务
        // spring 的处理逻辑如下
//         try{
        //        orderSOrderService.insertOrder();
        //   正常提交事务
//         }catch(){
            // 手动回滚事务（手滚）

//         }
        // 所以下面这个方法回滚的事务是  orderSOrderService.insertOrder() 这个方法里  s_order 表 和  boy 相关的事物 ，并不能控制  上面sOrderMapper.insert 里的事务
        // spring 事务回滚之后 ，xxlJob catch 到这个异常，写入 异常信息
        orderSOrderService.insertOrder();









    }











}
