package com.example.demo.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-06-18 13:48
 **/
public class BeanUtils {
    
    

    /** 
    *将一个对象集合转成另一个对象集合
    *目标类::new(eg: UserVO::new)
    */ 
    public static <S, T> List<T> of(List<S> sources, Supplier<T> supplier) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = supplier.get();
            org.springframework.beans.BeanUtils.copyProperties(source, t);
            list.add(t);
        }
        return list;
    }

    /**
     * Bean属性复制工具方法。
     *
     * @param source    目标对象
     * @param supplier: 目标类::new(eg: UserVO::new)
     *     返回新的对象
     */
    public static <T> T of(Object source, Supplier<T> supplier) {
        T t = supplier.get();
        org.springframework.beans.BeanUtils.copyProperties(source, t);
        return t;
    }


    /**
     * Bean属性复制工具方法。
     * @param sources   原始集合
     * @param supplier: 目标类::new(eg: UserVO::new)
     */
    public static <S, T> List<T> of2(List<S> sources, Supplier<T> supplier) {
        List<T> list = new ArrayList<>(sources.size());
        BeanCopier beanCopier = null;
        for (S source : sources) {
            T t = supplier.get();
            if (beanCopier == null) {
                 beanCopier  = BeanCopier.create(source.getClass(), t.getClass(), false);
            }
            beanCopier.copy(source, t, null);
            list.add(t);
        }
        return list;
    }

    /**
     * Bean属性复制工具方法。
     * @param source    目标对象
     * @param supplier: 目标类::new(eg: UserVO::new)
     */
    public static <T> T of2(Object source, Supplier<T> supplier) {
        T t = supplier.get();
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), t.getClass(), false);
        beanCopier.copy(source, t, null);
        return t;
    }


}
