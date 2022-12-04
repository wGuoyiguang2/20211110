//package com.example.demo.filter;
//
//import javax.servlet.*;
//import java.io.IOException;
//
///**
// * @program: springboot_01
// * @description:
// * @author: guoyiguang
// * @create: 2021-05-31 14:09
// **/
//public class LogCostFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        long start = System.currentTimeMillis();
//        filterChain.doFilter(servletRequest,servletResponse);
//        System.out.println("Execute cost2="+(System.currentTimeMillis()-start));
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
