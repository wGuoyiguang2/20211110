package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Boy;
import com.example.demo.mapper.BoyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-07 13:14
 **/

@Controller
@RequestMapping("/boy")
public class BoyController {



    @Resource
    BoyMapper boyMapper;

    // org.springframework.core.env.Environment
    @Autowired
    Environment environment;







    @RequestMapping("/getBoyList")
    @ResponseBody
    public List<Boy> getBoyList(){
        return  boyMapper.getList();
    }


    @RequestMapping("/getBoyList2")
    @ResponseBody
    public List<Boy> getBoyList2(){
        return  boyMapper.getList2();
    }



    @RequestMapping("/getBoyList3")
    @ResponseBody
    public String  getBoyList3(){
        Map<String,String> para = new HashMap<String,String>();
        para.put("defaultProfiles",environment.getDefaultProfiles().toString()) ;
        para.put("env",environment.getProperty("server.port"));
        return JSON.toJSONString(para);
    }












}
