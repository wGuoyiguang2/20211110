package com.example.demo.controller;

import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:57
 **/
@Controller
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionService regionService ;

    @Autowired
    CacheManager cacheManager;

    @RequestMapping("/list")
    @ResponseBody
    public PageInfo<Region> getList(Integer pageNum , Integer pageSize){
        PageInfo<Region> list = regionService.getList(pageNum, pageSize);
        return list;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Region> getAll(){
        System.out.println(cacheManager);
        List<Region> list = regionService.getAll();
        return list;
    }

    @RequestMapping("/recursionRegion")
    @ResponseBody
    public List<Region> recursionRegion(){
        List<Region> list = regionService.recursionRegion();
        return list;
    }





    @RequestMapping("/pagePlugin")
    @ResponseBody
    public PageInfo<Region> pagePlugin(Integer pageNum , Integer pageSize){
//        PageHelperPlugin.startPage(1,10);
        PageInfo<Region> list = regionService.getList(pageNum, pageSize);
        return list;
    }

    @RequestMapping("/pagePlugin2")
    @ResponseBody
    public PageInfo<Region> pagePlugin2(Integer pageNum , Integer pageSize){
//        PageHelperPlugin.startPage(1,10);
        PageInfo<Region> list = regionService.getList(pageNum, pageSize);
        return list;
    }



    public static void main(String[] args) throws IllegalAccessException {
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for(;;) {
            int andIncrement = atomicInteger.getAndIncrement();
            System.out.println(andIncrement);
            map.put(andIncrement,andIncrement);

        }
    }




}
