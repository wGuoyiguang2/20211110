package com.example.demo.mapper;

import com.example.demo.entity.generatePackage.SSaleModiApplyEntity;
import com.example.demo.entity.generatePackage.SSaleModiApplyEntityExample;
import java.util.List;

/**
* Created by Mybatis Generator on 2021/03/21
*/
public interface SSaleModiApplyEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SSaleModiApplyEntity record);

    int insertSelective(SSaleModiApplyEntity record);

    List<SSaleModiApplyEntity> selectByExampleWithBLOBs(SSaleModiApplyEntityExample example);

    List<SSaleModiApplyEntity> selectByExample(SSaleModiApplyEntityExample example);

    SSaleModiApplyEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SSaleModiApplyEntity record);

    int updateByPrimaryKeyWithBLOBs(SSaleModiApplyEntity record);

    int updateByPrimaryKey(SSaleModiApplyEntity record);
}