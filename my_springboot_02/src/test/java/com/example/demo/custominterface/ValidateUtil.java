package com.example.demo.custominterface;

import com.example.demo.customexception.BusinessException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: springboot_01  问题 ：  Object 和  T的区别是什么？
 * @description:
 **/
public class ValidateUtil {
    public static boolean  validateIsNull(Object object) throws IllegalAccessException, BusinessException {
        Class<?> clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(NotNull.class)) {
              // 要访问private 类型的，需要强制访问
                field.setAccessible(true);
                // 当前属性的值
                Object oldValue = field.get(object);
                //System.out.println(o);
                // 当前属性的属性名 eg: name
                String name = field.getName();
                //System.out.println(name);
                Class<?> type = field.getType();
                // 当前属性的属性类型 eg: java.lang.String
                //String name1 = type.getName();
                NotNull annotation = field.getAnnotation(NotNull.class);
                String annotationValue = annotation.value();
                // 为空 , 直接返回 (测试先暂时注释掉)
//                if (null == oldValue) {
//                    throw new BusinessException(500,annotationValue+" 不可为空");
//                }
                //String annotationDescription = annotation.description();
                if (type == String.class) {
                    if (null == oldValue || oldValue.toString().equals("")) {
                     throw new BusinessException(500,"数据不合法 "+annotationValue+"不可为空");
                    }
                }else if(type == Integer.class) {


                }else if(type == Double.class) {

                }else if (type ==  List.class) {
                    Class<?> aClass = oldValue.getClass();
                    if ("java.util.ArrayList".equals(aClass.getName())) {
                       List aList = (ArrayList)oldValue;
                       if (aList.size() <= 0) {
                           throw new BusinessException(500,annotationValue+" 不可为空");
                       }
                    }
                } else if(type ==  Set.class) {
                    Class<?> setClass = oldValue.getClass();
                    if ("java.util.TreeSet".equals(setClass.getName())) {
                        TreeSet oldValueTreeSet = (TreeSet) oldValue;
                        if (oldValueTreeSet.isEmpty()) {
                            throw new BusinessException(500,annotationValue+" 不可为空");
                        }
                    }


                }
            }
        }



        return true;
    }

    /**
    * @Description: 截取字段值过长的字段
    * @Param:
    * @return:
    * @Date:
    */
    public static Object  cutString(Object object) throws IllegalAccessException, BusinessException {
        Class<?> clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(CutString.class)) {
                // 要访问private 类型的，需要强制访问
                field.setAccessible(true);
                Object o = field.get(object);
                Class<?> type = field.getType();
                CutString annotation = field.getAnnotation(CutString.class);
                int maxAnnotationValue = annotation.maxLength();
                int minAnnotationValue = annotation.minLength();
                //String annotationDescription = annotation.description();
                if (type == String.class) {
                    if (null != o && !o.toString().equals("")) {
                        if (o.toString().length() >= maxAnnotationValue) {
                            String value = o.toString().substring(0,maxAnnotationValue);
                            field.set(object,value);
                        }
                    }
                }
            }
        }

        return object;
    }
}
