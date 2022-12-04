package com.example.demo.controller;
import cn.hutool.http.server.HttpServerRequest;
import com.example.demo.entity.xml2entity.User;
import com.example.demo.entity.xml2entity.UserOrder;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-16 13:16
 **/
//只用  Controller 有可能报 404
@RestController
public class Xml2EntityController {



    @RequestMapping(value = "/xml2entity/getUser",method = RequestMethod.GET, produces = "application/xml")
    @ResponseBody
    public User getUser(){

        UserOrder order1 = new UserOrder();
        order1.setId("1");
        order1.setOrderNum("1111111111");
        //order1.setOrderName("1111111111_充话费");

        UserOrder order2 = new UserOrder();
        order2.setId("2");
         order2.setOrderNum("22222222223");
        //order2.setOrderName("2222222222_充话费");

        User user1 = new User();
        user1.setId(1);
        user1.setName("张三");
        user1.setSex("男");
        user1.setPhone("15011133056");
        user1.setUrlList(Arrays.asList(order1,order2));

        return user1;
    }

    @PostMapping(value = "/xml2entity/submitA", consumes = "application/xml")
    public String submitA(@RequestBody User user){
        System.out.println("postman传过来的xml信息转换成实体类如下：==========");
        System.out.println(user.toString());
        return user.toString();
    }

    @RequestMapping(value = "/xml2entity/submitB")
    public String submitB(){
        return "success";
    }



    @RequestMapping(value = "/xml2entity/submitC")
    public String submitC(HttpServerRequest request){

        // new String(request.getBodyBytes())


        return "";

    }








}
