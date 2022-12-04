package com.example.demo.controller;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.entity.*;
import com.example.demo.entity.Vo.Person;
import com.example.demo.entity.annotation.Validate;
import com.example.demo.service.CommodityOrderService;
import com.example.demo.service.UserService;
import com.example.demo.utils.BarCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-16 13:16
 **/
@RestController
@RequestMapping("/aa")
public class TestController {

    @Autowired
    CommodityOrderService commodityOrderService ;

    @Autowired
    UserService userService ;

//    @RequestMapping(value="/a" ,method=RequestMethod.POST , produces = "application/json;charset=UTF-8")
//    public String a(@RequestBody User user,BindingResult br){
//        if (br.hasErrors()){
//            List<ObjectError> allErrors = br.getAllErrors();
//            ObjectError objectError = allErrors.get(0);
//            System.out.println(objectError.getDefaultMessage());
//            System.out.println(objectError.getObjectName());
//            System.out.println(allErrors);
//            return objectError.getDefaultMessage() ;
//        }
//        return  "成功";
//    }
//

    @PostMapping(value="a" ,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User a(@Valid @RequestBody User user ,BindingResult br){
        if (br.hasErrors()){
            List<ObjectError> allErrors = br.getAllErrors();
            ObjectError objectError = allErrors.get(0);
            System.out.println(objectError.getDefaultMessage());
            System.out.println(objectError.getObjectName());
            System.out.println(allErrors);
            //return objectError.getDefaultMessage() ;
        }

        return  user;
    }

    @PostMapping("/b")
    @ResponseBody
    public String b(@Valid @RequestBody List<Order> orderList , BindingResult br){
        if (br.hasErrors()){
            List<ObjectError> allErrors = br.getAllErrors();
            ObjectError objectError = allErrors.get(0);
            System.out.println(objectError.getDefaultMessage());
            System.out.println(objectError.getObjectName());
            System.out.println(allErrors);
            return objectError.getDefaultMessage() ;
        }
        return  "成功";
    }


    /**
     * @Description:  登录   loginName password
     */
    @GetMapping(value = "/loginSubmit")
    @ResponseBody
    public String loginSubmit( String loginName ,String  password) {
        return "[ECHO:" + "] " + loginName;
    }


    /**
     * @Description:  登录   loginName password
     */
    @GetMapping(value = "/add")
    @ResponseBody
    public String add( String loginName ,String  password) {
        return "[ECHO: + /admin/add  ] " + loginName;
    }

    /**
     * @Description:  登录   loginName password
     */
    @GetMapping(value = "/addBatch")
    @ResponseBody
    public String addBatch( String loginName ,String  password) {
        return "[ECHO: /admin/addBatch" + "] " + loginName;
    }

  /** 
  * @Description:  参数校验AOP
  */ 
    @GetMapping(value = "/transParams/{message}")
    public String echo(@PathVariable String message) {

        return "[ECHO:" + "] " + message;
    }


    @RequestMapping("/nulltest1")
    @ResponseBody
    public String nulltest(String id){
        // postMan  传 "" ,后台会接受 ""
        System.out.println(id);
        return  id;
    }

//    @PostMapping("/aaa")
//    @ResponseBody
//    public String aaa(@RequestBody TestEntity entity ){
//        //return  entity.getTime().toLocalDate().toString();
//        return  entity.getTime();
//    }


    @PostMapping("/aaa")
    @ResponseBody
    public List<Order> aaa(@RequestBody  List<Order> orderList){

        Map<String, Map<String, Integer>> hsNums = getHsNums(orderList);

        for (Order order :orderList){
            String orderDetailsStr = order.getOrderDetailsTypeStr();
            String[] split = orderDetailsStr.split(",");
            List<OrderDetail> detailsList = new ArrayList<>(orderDetailsStr.split(",").length);
            for (int i = 0 ;i < split.length ;i++){
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderType(split[i]);
                orderDetail.setOrderGUID(order.getOrderGUID());
                orderDetail.setOrdernum(hsNums.get(order.getOrderGUID()).get(split[i]));

                detailsList.add(orderDetail);

            }
            order.setOrderDetailChildren(detailsList);
        }


         return orderList;

    }


    public Map<String, Map<String,Integer>> getHsNums(List<Order> orderList){

        Map<String,Map<String,Integer>> resultMap =  new HashMap<>();
        for (Order order: orderList){

            Map<String, Integer>  hsMap =  new HashMap<>();
            if (!StringUtils.isEmpty(order.getOrderDetailsTypeStr())){
                String orderDetailsStr = order.getOrderDetailsTypeStr();
                String[] split = orderDetailsStr.split(",");
                for(int i = 0; i<split.length ;i++){
                    // 内键  汉字（能不能存汉字） ；值  汉字的 顺序
                    hsMap.put(split[i],i+1);
                }
            }
            // 外键 订单guid
            resultMap.put(order.getOrderGUID(),hsMap);
        }
        return resultMap ;
    }


    @GetMapping("testLocalDateTime")
    public Person testLocalDateTime() {

        Person person = new Person();

        person.setCreatedDate(new Date());
        person.setCreatedTime(LocalDateTime.now());

        return person;

    }




    @PostMapping("testLocalDateTime2")
    public Person testLocalDateTime2(Person person) {
        System.out.println(person.toString());
        return person;

    }



















}
