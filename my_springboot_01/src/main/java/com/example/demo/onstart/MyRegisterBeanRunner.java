package com.example.demo.onstart;

import com.example.demo.controller.BoyController;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @program: 所有bean 在实例化之后 执行的操作 ，必须加  @Component 让 spring 管理,因为 需要 spring 获取 SmartInitializingSingleton 类型的bean
 *          然后调用  被重写的  afterSingletonsInstantiated  method
 * @description:
 * @author: guoyiguang
 * @create: 2021-08-22 12:04
 **/
@Component
public class MyRegisterBeanRunner implements SmartInitializingSingleton {


    private ListableBeanFactory beanFactory;

    public MyRegisterBeanRunner(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterSingletonsInstantiated() {

        String[] beanNames = beanFactory.getBeanNamesForType(BoyController.class);
        for (String s : beanNames) {
            System.out.println(s);
        }

    }
}
