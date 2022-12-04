package com.example.demo.service;

import com.example.demo.entity.CommodityOrder;
import com.example.demo.entity.Vo.CommodityOrderVo;

public interface CommodityOrderService {

    CommodityOrder getByOrderId(Integer id);
    int updateOrderAndDetails(CommodityOrderVo commodityOrderVo);
}
