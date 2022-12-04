//package com.example.demo.filter;
//
//import com.example.demo.aop.LogAspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
///**
// * @program: springboot_01
// * @description:
// * @author: guoyiguang
// * @create: 2021-05-31 14:09
// **/
//// 使过滤器生效的第二种方法(不加 @Component   过滤器不生效)
//@Component
//@WebFilter(urlPatterns = "/*", filterName = "logFilter1")
//public class LogCostFilter2 implements Filter {
//
//
//    private final static Logger logger = LoggerFactory.getLogger(LogCostFilter2.class);
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//
//        //hostname hostString port
//        // host =10.237.200.107，hostString=10.237.200.107，port=49946
//        logger.info("利用filter 记录每次请求的有关信息，host ={}，hostString={}，port={}", request.getRemoteHost(), request.getRemoteAddr(), request.getRemotePort());
//
//        filterChain.doFilter(request,response);
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
