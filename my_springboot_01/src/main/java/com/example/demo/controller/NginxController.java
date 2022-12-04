package com.example.demo.controller;

import com.example.demo.service.NginxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springboot_01
 * @description: nginx 测试
 * @author: guoyiguang
 * @create: 2021-06-02 11:56
 **/

@RestController
public class NginxController {

    @Autowired
    Environment environment;

    @Autowired
    NginxService nginxService;





    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("/nginx/hello")
    public String hello(){
        String port = environment.getProperty("server.port");
        System.out.println(port);
        return port;
    }


    @RequestMapping("/nginx/list")
    public String list(){
        nginxService.deal();
        return "success" ;
    }


    @RequestMapping("/nginx/map")
    public String map(){
        nginxService.dealMap();
       return "success";
    }

}
