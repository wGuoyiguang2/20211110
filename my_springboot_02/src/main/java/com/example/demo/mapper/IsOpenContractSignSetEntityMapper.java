package com.example.demo.mapper;

import com.example.demo.entity.generatePackage.IsOpenContractSignSetEntity;
import com.example.demo.entity.generatePackage.IsOpenContractSignSetEntityExample;
import java.util.List;

/**
* Created by Mybatis Generator on 2021/05/21
*/
public interface IsOpenContractSignSetEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IsOpenContractSignSetEntity record);

    int insertSelective(IsOpenContractSignSetEntity record);

    List<IsOpenContractSignSetEntity> selectByExample(IsOpenContractSignSetEntityExample example);

    IsOpenContractSignSetEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IsOpenContractSignSetEntity record);

    int updateByPrimaryKey(IsOpenContractSignSetEntity record);
}