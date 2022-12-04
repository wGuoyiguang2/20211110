package com.example.demo.controller;

import com.example.demo.entity.Boy;
import com.example.demo.entity.Order;
import com.example.demo.entity.TestForm;
import com.example.demo.entity.User;
import com.example.demo.entity.annotation.Validate;
import com.example.demo.service.CommodityOrderService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-16 13:16
 **/
@Controller
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

    @PostMapping("/nulltest2")
    @ResponseBody
    public Integer nulltest2(@RequestBody Boy boy){
        // postMan 传 {"sex":""} 打印 null
        // postMan 传 {"sex":1}  打印 1
        System.out.println(boy.getSex());
        return  boy.getSex();
    }





}
