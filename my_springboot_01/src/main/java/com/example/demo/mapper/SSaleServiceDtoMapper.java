package com.example.demo.mapper;

import com.example.demo.entity.generatePackage.SSaleServiceDto;
import com.example.demo.entity.generatePackage.SSaleServiceDtoExample;
import org.apache.ibatis.annotations.Param;

public interface SSaleServiceDtoMapper {
    SSaleServiceDto selectByPrimaryKey(String sSaleserviceguid);

    int updateByExampleSelective(@Param("record") SSaleServiceDto record, @Param("example") SSaleServiceDtoExample example);

    int updateByExampleWithBLOBs(@Param("record") SSaleServiceDto record, @Param("example") SSaleServiceDtoExample example);

    int updateByExample(@Param("record") SSaleServiceDto record, @Param("example") SSaleServiceDtoExample example);
}