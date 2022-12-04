package com.example.demo.mapper;

import com.example.demo.entity.CommodityOrder;
import com.example.demo.entity.CommodityOrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityOrderDetailMapper {

    int batchInsertDetails(List<CommodityOrderDetail> list);

    List<CommodityOrderDetail> selectListByOrderId(@Param("orderId") String orderId);


}
