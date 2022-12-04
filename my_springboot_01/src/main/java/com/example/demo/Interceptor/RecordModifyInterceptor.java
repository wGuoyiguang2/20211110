//package com.example.demo.Interceptor;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.StreamUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @program: springboot_01
// * @description:
// * @author: guoyiguang
// * @create: 2021-03-07 14:42
// **/
//@Slf4j
//public class RecordModifyInterceptor  implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        //获取请求参数
//        String queryString = request.getQueryString();
//        log.info("请求参数:{}", queryString);
//
//        //获取请求body
//        byte[] bodyBytes = StreamUtils.copyToByteArray(request.getInputStream());
//        String body = new String(bodyBytes, request.getCharacterEncoding());
//
//        log.info("请求体：{}", body);
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("执行了TestInterceptor的postHandle方法");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//
//    }
//}
