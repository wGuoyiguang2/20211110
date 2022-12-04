package com.example.demo.utils;

import com.example.demo.entity.Param;
import org.springframework.util.StringUtils;
import java.lang.annotation.Annotation;
import java.util.List;


/**
* @Description:   判断为空的工具类
* @Param:
* @return:
* @Author: guoyiguang
* @Date:
*/
public class Check {


/** 
* @Description:  判断list集合非空，有值 返回false
*/ 
 public static boolean  NuNList(List<Param> params){
     if(null == params){
         return true;
     }

     if(params.size() == 0){
         return true;
     }
     return false;


    }


    /**
     * @Description:   字符串有值 返回false
     */
    public static boolean  NuNString(String validRes){
        if(StringUtils.isEmpty(validRes)){
            return true;
        }
        return false;
    }


    /**
     * @Description:       判断对象为空
     */
    public static boolean  NuNObject(Object object){
        if(null == object){
            return true;
        }
        return false;
    }


    /**
     * @Description:       判断Object数组为空
     */
    public static boolean  NuNArray(Object[] arr){
        if(null == arr ){
            return true;
        }
        if(arr.length == 0 ){
            return true;
        }
        return false;
    }


    /**
     * 判断数组为空
     */
    public static boolean  NuNArray(Annotation[] annos){
        if(null == annos){
            return true;
        }

        if(annos.length == 0 ){
            return true;
        }
        return false;
    }



}
