package com.example.demo.controller;

import com.example.demo.entity.CommodityOrder;
import com.example.demo.entity.CommodityOrderDetail;
import com.example.demo.entity.Region;
import com.example.demo.entity.Vo.CommodityOrderVo;
import com.example.demo.service.CommodityOrderService;
import com.example.demo.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-16 13:16
 **/
@Controller
@RequestMapping("/commodityOrder")
public class CommodityOrderController {

    @Autowired
    CommodityOrderService commodityOrderService ;

    @RequestMapping("/get")
    @ResponseBody
    public CommodityOrder getByOrderId(Integer id){
        return  commodityOrderService.getByOrderId(id);
    }

    /**
    * @Description: 说明 不加 @RequestBody   前面的json 串 是不会去 CommodityOrderVo 给对应属性赋值的
    * @Date:
    */
    @RequestMapping("/update")
    @ResponseBody
    public CommodityOrder update(@RequestBody  CommodityOrderVo  commodityOrderVo){
         int count=  commodityOrderService.updateOrderAndDetails(commodityOrderVo);
        System.out.println("  修改数据条数 ------------------------->"+count);
        // 将刚修改的数据返回，方便查看
        return  commodityOrderService.getByOrderId(commodityOrderVo.getId());
    }

    /**
     * @Description: 说明 不加 @RequestBody   前面的json 串 是不会去 CommodityOrderVo 给对应属性赋值的
     * @Date:
     */
    @RequestMapping("/testHashCodeAndEquals")
    public void testHashCodeAndEquals(){
        CommodityOrderDetail cod1 = new CommodityOrderDetail();
        cod1.setId(1);
        cod1.setOrderId(1);
        cod1.setCommodityId("1");
        cod1.setCommodityName("苹果");
        cod1.setCommodityCount(1);
        cod1.setIsDelete(0);

        CommodityOrderDetail cod2 = new CommodityOrderDetail();
        cod2.setId(1);
        cod2.setOrderId(1);
        cod2.setCommodityId("1");
        cod2.setCommodityName("苹果");
        cod2.setCommodityCount(1);
        cod2.setIsDelete(0);

        CommodityOrderDetail cod3 = new CommodityOrderDetail();
        cod3.setId(1);
        cod3.setOrderId(1);
        cod3.setCommodityId("1");
        cod3.setCommodityName("苹果苹果");
        cod3.setCommodityCount(10000);
        cod3.setIsDelete(1);
        System.out.println("----------------------");
        // false
        System.out.println(cod1 == cod2);
        // true
        System.out.println(cod1.equals(cod2));
        System.out.println("----------------------");
        // false
        System.out.println(cod1 == cod3);
        System.out.println("----------------------");
        // true
        System.out.println(cod1.equals(cod3));



    }



}
