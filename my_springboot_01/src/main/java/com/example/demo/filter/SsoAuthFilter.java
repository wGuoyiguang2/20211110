package com.example.demo.filter;


import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;

import static cn.hutool.core.util.StrUtil.EMPTY;


@Slf4j
@Component
@WebFilter(urlPatterns = "/*", filterName = "ssoAuthFilter")
public class SsoAuthFilter implements Filter, Ordered {


    /**
     * 随机数.
     */
    private static final Random RANDOM = new Random();


    @Override
    public int getOrder() {
        return 0;
    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {


        String traceId = new UUID(RANDOM.nextLong(), RANDOM.nextLong()).toString().replace("-", "");

        MDC.put("TRACE_ID", traceId);
        traceId = traceId == null ? EMPTY : traceId;
        Thread.currentThread().setName(traceId);

        log.info("prepare to execute filter");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        // 登录认证(调用其他服务获取)


        // 权限授权 (token：{用户所具有的权限})   和当前 uri比较

        // 认证通过
        Object pass = request.getParameter("pass");
        // if (null != pass && pass.toString().equals("pass")){
        if (true){
            // 往header 添加 token ，系统组访问 其他组的话，是需要携带这个token的，告知其他服务我已经登录了
            HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);
            requestWrapper.addHeader("x-user-guid","test");
            chain.doFilter(requestWrapper, servletResponse);
        }else{
            // 直接返回错误信息
            // {"code":0,"errMsg":"对不起，你没有权限!"}
            // writeFailure(response);

            // 思路二：请求转发(需要定义一个 /401 的映射器)
            // 将错误信息封装在request中
             request.setAttribute("errorMessage", "没有权限");
             request.getRequestDispatcher("/filterException/401").forward(servletRequest, servletResponse);
            // 直接抛出异常很不友好
            //   {
            //    "timestamp": "2021-10-12 15:00:39",
            //    "status": 500,
            //    "error": "Internal Server Error",
            //    "message": "没权限",
            //    "path": "/region/newRequest"
            //   }
           //   throw new RuntimeException("没权限");
            // No message available


        }

        MDC.remove("TRACE_ID");


    }

    @Override
    public void destroy() {

    }

    private void writeFailure(HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        result.put("code",0);
        result.put("errMsg","对不起，你没有权限!");


         response.setCharacterEncoding("UTF-8");
         PrintWriter writer = response.getWriter();

        writer.write(result.toString());
        writer.flush();
        writer.close();

    }



}
