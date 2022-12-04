package com.example.demo.mapper;

import com.example.demo.entity.generatePackage.ContractSignStatus;
import com.example.demo.entity.generatePackage.ContractSignStatusExample;
import java.util.List;

/**
* Created by Mybatis Generator on 2021/05/10
*/
public interface ContractSignStatusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContractSignStatus record);

    int insertSelective(ContractSignStatus record);

    List<ContractSignStatus> selectByExampleWithBLOBs(ContractSignStatusExample example);

    List<ContractSignStatus> selectByExample(ContractSignStatusExample example);

    ContractSignStatus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContractSignStatus record);

    int updateByPrimaryKeyWithBLOBs(ContractSignStatus record);

    int updateByPrimaryKey(ContractSignStatus record);
}