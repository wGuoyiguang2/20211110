//package com.example.demo.controller;
//
//import cn.hutool.http.HttpResponse;
//import cn.hutool.json.JSONObject;
//import com.example.demo.entity.es.SysUser;
//import org.springframework.http.HttpRequest;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * @program: springboot_01
// * @description:
// * @author: guoyiguang
// * @create: 2021-10-12 15:40
// **/
//@RestController
//@RequestMapping("/filterException")
//public class FilterController {
//
//
//    @GetMapping("/401")
//    public void error(HttpServletRequest  request,HttpServletResponse response) throws IOException {
//
//        JSONObject result = new JSONObject();
//        result.put("code",0);
//        result.put("errMsg",request.getAttribute("errorMessage").toString());
//        response.setCharacterEncoding("UTF-8");
//        PrintWriter writer = response.getWriter();
//        writer.write(result.toString());
//        writer.flush();
//        writer.close();
//
//    }
//}
