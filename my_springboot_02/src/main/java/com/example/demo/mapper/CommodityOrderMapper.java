package com.example.demo.mapper;

import com.example.demo.entity.CommodityOrder;
import com.example.demo.entity.Vo.CommodityOrderVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CommodityOrderMapper {
   CommodityOrder getByOrderId(@Param("id") Integer id);

   int updateOrderAndDetails(CommodityOrderVo commodityOrderVo);
}
