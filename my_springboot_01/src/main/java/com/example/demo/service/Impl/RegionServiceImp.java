package com.example.demo.service.Impl;

import com.example.demo.entity.Region;
import com.example.demo.mapper.RegionMapper;
import com.example.demo.service.RegionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:46
 **/
@Service
public class RegionServiceImp implements RegionService {

    @Autowired
    RegionMapper  regionMapper ;

    @Autowired
    CacheManager cacheManager;
    @Override
    public  PageInfo<Region>getList(Integer pageNum,Integer pageSize) {
        System.out.println("service ......getList......");
        PageHelper.startPage(pageNum,pageSize);
        // 不需要分页 ，pageSize  设置为 0
        //PageHelper.startPage(pageNum,0);
        List<Region> list = regionMapper.list();
        PageInfo<Region> pageInfo = new PageInfo<Region>(list);
        return pageInfo;
    }

    @Override
    @Cacheable(value = "list", key = "'region_all'")
    public  List<Region>getAll() {
        System.out.println("service ......getAll......");
        System.out.println(cacheManager.toString());
        List<Region> list = regionMapper.list();
        System.out.println(cacheManager.toString());
        return list;
    }

    @Override
    public List<Region> recursionRegion() {
        List<Region> regionListFromDb = regionMapper.list();
        // 获取根
        List<Region> rootList =  regionListFromDb.stream()
                .filter(root -> null == root.getParentCode())
                .collect(Collectors.toList());

        for (Region root: rootList) {
            recursionRegion(root, regionListFromDb);
        }
        return rootList;
    }

    /** 
    * @Description:
    * @Param:   target 非最后一层；regionListFromDb 源数据
    * @return: target 的下一级
    * @Date:  
    */ 
    private List<Region> recursionRegion(Region target ,List<Region> regionListFromDb){
       if (target.getLevel() == 4) {
            return  new ArrayList<>() ;
        }
        // 获取下一级
        List<Region> cityList =  regionListFromDb.stream()
                .filter(son -> null != son.getParentCode() && son.getParentCode().equalsIgnoreCase(target.getCode()))
                .collect(Collectors.toList());
        target.setChildren(cityList);
        for (Region city2 : cityList) {
            List<Region> city3List = recursionRegion(city2, regionListFromDb);
            city2.setChildren(city3List);
        }
          return cityList;
    }
}
