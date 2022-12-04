package com.example.demo.utils;


import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

   public boolean setValue(String key,Object obj,Long time){
        return true;
    }

    public Object getValue(String key){
        return new String("admin");
    }


   public long ttl(String key){
       return 60*10*3;
   }


    public boolean expire(String key,long time){
        return true;
    }




}
