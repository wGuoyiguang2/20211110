package com.example.demo.service.Impl;

import com.example.demo.entity.SOrder;
import com.example.demo.mapper.OrderSOrderMapper;
import com.example.demo.service.order.OrderSOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-07 13:11
 **/

@Service
public class OrderSOrderServiceImpl implements OrderSOrderService {

    @Autowired
    @Qualifier("orderSOrderMapper")
    OrderSOrderMapper sOrderMapper;

    @Override
    public SOrder selectByPrimaryKey(Integer id) {
        return sOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(SOrder record) {
        return sOrderMapper.updateByPrimaryKey(record);
    }
}
