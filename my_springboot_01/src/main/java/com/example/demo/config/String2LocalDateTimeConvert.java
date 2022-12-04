package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @program: springboot_01
 * @description: 将 字符串 2021-07-31 转为 LocalDateTime 类型的
 *
 * @author: guoyiguang
 * @create: 2021-07-31 16:44
 * 将转换器注册为容器bean后，可自动注册，不需要使用WebMvcConfigurer
 **/
@Component
@Slf4j
public class String2LocalDateTimeConvert implements Converter<String, LocalDateTime>{


    @Override
    public LocalDateTime convert(String source) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = null;
        try {
            //2020-01-01 00:00:00
            switch (source.length()){
                case 10:
                    log.debug("传过来的是日期格式：{}",source);
                    source=source+" 00:00:00";
                    break;
                case 13:
                    log.debug("传过来的是日期 小时格式：{}",source);
                    source=source+":00:00";
                    break;
                case 16:
                    log.debug("传过来的是日期 小时:分钟格式：{}",source);
                    source=source+":00";
                    break;
            }
            dateTime = LocalDateTime.parse(source, df);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return dateTime;
    }
}
