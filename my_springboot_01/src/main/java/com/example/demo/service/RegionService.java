package com.example.demo.service;

import com.example.demo.entity.Region;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:46
 **/
public interface RegionService {
    PageInfo<Region> getList(Integer pageNum,Integer pageSize);
    List<Region>getAll() ;


    List<Region> recursionRegion();
}
