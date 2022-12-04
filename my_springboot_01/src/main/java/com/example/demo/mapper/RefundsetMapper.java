package com.example.demo.mapper;


import com.example.demo.entity.Refundset;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RefundsetMapper  {


    /**
     * 根据公司Guid查询退款设置列表
     *
     * @param buGuid
     * @return
     */
    List<Refundset> getRefundByBuGuid(@Param("buGuid") String buGuid);

    /**
     * 根据公司Guid查询退款设置列表
     *
     * @param
     * @return
     */
    List<Refundset> getRefundSetList();




}
