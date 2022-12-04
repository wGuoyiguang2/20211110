package com.example.demo.service;

import com.example.demo.entity.CommodityOrderDetail;

import java.util.List;

public interface CommodityOrderDetailService {
    int batchInsertDetails(List<CommodityOrderDetail> list);
    List<CommodityOrderDetail> selectListByOrderId(String orderId);
}
