package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@MapperScan({"com.example.demo.mapper","com.example.demo.mapper"})
// @MapperScan  代替 @Mapper的
@MapperScan("com.example.demo.mapper")
// 开启缓存
@EnableCaching
@EnableAsync // 开启异步任务
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }




    @Bean
     RestTemplate restTemplate(){
        return new RestTemplate();

     }

}
