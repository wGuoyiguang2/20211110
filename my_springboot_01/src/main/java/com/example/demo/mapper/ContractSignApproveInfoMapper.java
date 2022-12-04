package com.example.demo.mapper;

import com.example.demo.entity.generatePackage.ContractSignApproveInfo;
import com.example.demo.entity.generatePackage.ContractSignApproveInfoExample;
import java.util.List;

/**
* Created by Mybatis Generator on 2021/05/17
*/
public interface ContractSignApproveInfoMapper {
    int insert(ContractSignApproveInfo record);

    int insertSelective(ContractSignApproveInfo record);

    List<ContractSignApproveInfo> selectByExample(ContractSignApproveInfoExample example);
}