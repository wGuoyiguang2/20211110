package com.example.demo.mapper;

import com.example.demo.entity.generatePackage.IsOpenContractSignSet;
import com.example.demo.entity.generatePackage.IsOpenContractSignSetExample;
import java.util.List;

/**
* Created by Mybatis Generator on 2021/05/21
*/
public interface IsOpenContractSignSetMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IsOpenContractSignSet record);

    int insertSelective(IsOpenContractSignSet record);

    List<IsOpenContractSignSet> selectByExample(IsOpenContractSignSetExample example);

    IsOpenContractSignSet selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IsOpenContractSignSet record);

    int updateByPrimaryKey(IsOpenContractSignSet record);
}