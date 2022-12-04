package com.example.demo.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
* 全局异常捕捉处理
* */
@RestController
@org.springframework.web.bind.annotation.ControllerAdvice
@Slf4j
public class MyControllerAdvice {



    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map exceptionHandle0(HttpServletRequest request, Exception ex){
        log.info("Business exception handler  " + ex.getMessage() );
        Map map = new HashMap();

        //判断异常的类型,返回不一样的返回值
        if(ex instanceof BusinessException){
            map.put("code", 302);
            map.put("msg",((BusinessException) ex).getMessage());
        } else if (ex instanceof AopException) {
            map.put("code", 303);
            map.put("msg",((AopException) ex).getMessage());

        } else {
            map.put("code", 500);
            map.put("msg",ex.getMessage());
        }
        return map;
    }


    @ExceptionHandler(AopException.class)
    @ResponseBody
    public void businessExceptionHandle0(HttpServletRequest request, HttpServletResponse response, Exception ex){
        log.info("Business exception handler  " + ex.getMessage() );
        //判断异常的类型,返回不一样的返回值
        if(ex instanceof AopException){
            ResponseUtil.responseContent(response, ((AopException) ex).getCode(),((AopException) ex).getMessage());
        }else{
            ResponseUtil.responseContent(response, "500","系统异常");
        }

    }


}
