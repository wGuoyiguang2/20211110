package com.example.demo.service.Impl;

import com.example.demo.entity.SOrder;
import com.example.demo.mapper.SaleChangeSOrderMapper;
import com.example.demo.service.salechange.OrderSaleChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-07 13:13
 **/
@Service
public class OrderSaleChangeServiceImpl implements OrderSaleChangeService {


    @Autowired
    @Qualifier("salechangeSOrderMapper")
    SaleChangeSOrderMapper sOrderMapper;



    @Override
    public SOrder selectByPrimaryKey(Integer id) {
        return sOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(SOrder record) {
        return sOrderMapper.updateByPrimaryKey(record);
    }
}
