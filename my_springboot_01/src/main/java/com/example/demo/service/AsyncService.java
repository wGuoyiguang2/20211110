package com.example.demo.service;

import com.example.demo.entity.Boy;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-07-11 13:24
 **/
public interface AsyncService {

    void doNoReturn();

     ListenableFuture<Boy> execute01AsyncWithListenableFuture();
}
