package com.example.demo.controller;

import com.example.demo.entity.Region;
import com.example.demo.service.RegionService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:57
 **/
@RestController
@RequestMapping("/region")
public class RegionController {


    private final static Logger logger = LoggerFactory.getLogger(RegionController.class);

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


    @GetMapping("/newRequest")
    public String   newRequest(@RequestHeader("x-user-guid") String header,String pass){
        System.out.println(header);
        System.out.println(header);
        System.out.println(pass);
        logger.info("x-user-guid 的值为 {}" ,header);

        try {
            int i = 1 / 0;
        } catch (Exception e) {
            logger.error("异常了，异常原因为 {}" ,e.getMessage());
        }

        return header ;
    }






    public static void main(String[] args) throws IllegalAccessException {
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for(;;) {
            int andIncrement = atomicInteger.getAndIncrement();
            extracted(andIncrement);
            map.put(andIncrement,andIncrement);

        }
    }

    public static void extracted(int andIncrement) {
        System.out.println(andIncrement);
    }


}
