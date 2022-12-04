package com.example.demo.service.order;

import com.example.demo.entity.SOrder;

public interface OrderSOrderService {


    SOrder selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(SOrder record);


    String insertOrder();

    public String insertBoy();

    void insertOrder2();
}
