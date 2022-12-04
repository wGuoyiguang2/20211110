package com.example.demo.mapper;

import com.example.demo.entity.generatePackage.SOrderDto;
import com.example.demo.entity.generatePackage.SOrderDtoExample;
import java.util.List;

/**
* Created by Mybatis Generator on 2021/03/21
*/
public interface SOrderDtoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SOrderDto record);

    int insertSelective(SOrderDto record);

    List<SOrderDto> selectByExampleWithBLOBs(SOrderDtoExample example);

    List<SOrderDto> selectByExample(SOrderDtoExample example);

    SOrderDto selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SOrderDto record);

    int updateByPrimaryKeyWithBLOBs(SOrderDto record);

    int updateByPrimaryKey(SOrderDto record);
}