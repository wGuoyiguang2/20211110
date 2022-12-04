package com.example.demo.mapper;

import com.example.demo.entity.generatePackage.STradeEntity;
import com.example.demo.entity.generatePackage.STradeEntityExample;
import org.apache.ibatis.annotations.Param;

public interface STradeEntityMapper {
    STradeEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") STradeEntity record, @Param("example") STradeEntityExample example);

    int updateByExampleWithBLOBs(@Param("record") STradeEntity record, @Param("example") STradeEntityExample example);

    int updateByExample(@Param("record") STradeEntity record, @Param("example") STradeEntityExample example);
}