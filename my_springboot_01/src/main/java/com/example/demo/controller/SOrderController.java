package com.example.demo.controller;

import com.example.demo.entity.Region;
import com.example.demo.entity.SOrder;
import com.example.demo.service.order.OrderSOrderService;
import com.example.demo.service.salechange.OrderSaleChangeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-03-07 13:14
 **/

@RestController("/order")
public class SOrderController {



    @Resource
    OrderSOrderService orderSOrderService;
    @Resource
    OrderSaleChangeService orderSaleChangeService;


    @RequestMapping("/getOneFromOrderNameSpace")
    @ResponseBody
    public SOrder getOneFromOrderNameSpace(Integer id){
        return  orderSOrderService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateOneToOrderNameSpace",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int updateOneToOrderNameSpace(@RequestBody SOrder sOrder){
        return  orderSOrderService.updateByPrimaryKey(sOrder);
    }


    @RequestMapping("/getOneFromSaleChangeNameSpace")
    @ResponseBody
    public SOrder getOneFromSaleChangeNameSpace(Integer id){
        return  orderSaleChangeService.selectByPrimaryKey(id);
    }



    @RequestMapping(value = "/updateOneToSaleChangeNameSpace",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int updateOneToSaleChangeNameSpace(@RequestBody SOrder sOrder){
        return  orderSaleChangeService.updateByPrimaryKey(sOrder);
    }



    @RequestMapping(value = "/insertOrder",  method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String insertOrder(){

        try {
            return  orderSOrderService.insertOrder();
        } catch (Exception e) {
            System.out.println("报错了");
        }
        return "";
    }


    @GetMapping(value = "/insertOrder2")
    public String insertOrder2(){

        try {
            return  orderSOrderService.insertOrder();
        } catch (Exception e) {
            System.out.println("报错了");
        }
        return "";
    }










}
