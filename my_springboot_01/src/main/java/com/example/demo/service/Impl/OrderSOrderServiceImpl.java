package com.example.demo.service.Impl;

import com.example.demo.entity.Boy;
import com.example.demo.entity.SOrder;
import com.example.demo.mapper.BoyMapper;
import com.example.demo.mapper.OrderSOrderMapper;
import com.example.demo.service.BoySerivce;
import com.example.demo.service.order.OrderSOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-07 13:11
 **/

@Service
@Slf4j
public class OrderSOrderServiceImpl implements OrderSOrderService {

    @Autowired
    @Qualifier("orderSOrderMapper")
    OrderSOrderMapper sOrderMapper;

    @Autowired
    BoySerivce boySerivce;

    @Autowired
    BoyMapper boyMapper;






    @Override
    public SOrder selectByPrimaryKey(Integer id) {
        return sOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    //    // @Transactional(propagation = Propagation.REQUIRED)
    public int updateByPrimaryKey(SOrder record) {
        return sOrderMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String insertOrder() {
        LocalDateTime now = LocalDateTime.now();
        SOrder sOrder = new SOrder();
        sOrder.setCreatedGuid("000000000000");
        sOrder.setCreatedTime(now);
        sOrder.setUpdatedGuid("000000000000");
        sOrder.setUpdatedTime(now);
        sOrder.setDescription("嘿嘿");
        sOrder.setId(1);
        sOrder.setName("订单1");
        int insertOrderCount = sOrderMapper.insert(sOrder);
        log.info("insert  s_order count {}",insertOrderCount);

        insertBoy();
        return "成功";
    }

    @Override
    @Transactional
    public String insertBoy()  {
        Boy boy = new Boy();
        boy.setName("苏梅");
        int insertBoyCount = boyMapper.insert(boy);
        log.info("insert  boy count {}",insertBoyCount);
        int a =   10/0;
        return "成功！";
    }

    @Override
    public void insertOrder2(){

        try {
            insertOrder();
            insertBoy();
        } catch (Exception e) {
            System.out.println("报错了,这个异常被吃了......");
        }


    };
}
