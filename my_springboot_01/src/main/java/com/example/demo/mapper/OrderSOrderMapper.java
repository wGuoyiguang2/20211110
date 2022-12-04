package com.example.demo.mapper;

import com.example.demo.entity.SOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



@Repository("orderSOrderMapper")
public interface OrderSOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SOrder record);

    int insertSelective(SOrder record);

    int updateByExampleSelective(SOrder record);

    SOrder selectByPrimaryKey(@Param("id") Integer id);


    int updateByPrimaryKey(SOrder record);
}