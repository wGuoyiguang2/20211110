package com.example.demo.controller;

import com.example.demo.entity.Boy;
import com.example.demo.entity.SOrder;
import com.example.demo.mapper.BoyMapper;
import com.example.demo.service.order.OrderSOrderService;
import com.example.demo.service.salechange.OrderSaleChangeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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










}
