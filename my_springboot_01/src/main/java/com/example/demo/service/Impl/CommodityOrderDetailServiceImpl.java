package com.example.demo.service.Impl;

import com.example.demo.entity.CommodityOrderDetail;
import com.example.demo.mapper.CommodityOrderDetailMapper;
import com.example.demo.service.CommodityOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-16 13:10
 **/
@Service
public class CommodityOrderDetailServiceImpl implements CommodityOrderDetailService {

    @Autowired
    CommodityOrderDetailMapper commodityOrderDetailMapper;
    @Override
    public int batchInsertDetails(List<CommodityOrderDetail> list) {
        return commodityOrderDetailMapper.batchInsertDetails(list);
    }

    @Override
    public List<CommodityOrderDetail> selectListByOrderId(String orderId) {
        // 暂时不实现 ，因为目前是通过 主订单来操作 子表的
        return null;
    }
}
