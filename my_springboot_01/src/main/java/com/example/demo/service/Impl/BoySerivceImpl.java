package com.example.demo.service.Impl;

import com.example.demo.entity.Boy;
import com.example.demo.entity.exception.BizException;
import com.example.demo.mapper.BoyMapper;
import com.example.demo.service.BoySerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: springboot_01
 * @description:   int a =   10/0;
 * @author: guoyiguang  @Transactional(propagation = Propagation.NOT_SUPPORTED)
 * @create: 2021-06-28 14:26
 **/
@Service
@Slf4j
public class BoySerivceImpl implements BoySerivce {

    @Resource
    BoyMapper boyMapper;

    @Override
    @Transactional
    public String insertBoy()  {
        Boy boy = new Boy();
        boy.setName("苏苏");
        int insertBoyCount = boyMapper.insert(boy);
        log.info("insert  boy count {}",insertBoyCount);
        throw BizException.wrap("更新数据失败，请稍后重试~");
    }
}
