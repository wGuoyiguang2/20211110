package com.example.demo.service.salechange;

import com.example.demo.entity.SOrder;

public interface OrderSaleChangeService {


    SOrder selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(SOrder record);


}
