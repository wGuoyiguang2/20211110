package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.DeptEmp;
import com.example.demo.mapper.DeptEmpMapper;
import com.example.demo.service.DeptEmpService;
import org.springframework.stereotype.Service;

/**
 * @program: 实现 DeptEmpService 接口 是为了写通用方法 ,
 *           继承  ServiceImpl 是为了 不写 重复的 （通用的）crud 方法
 * @description:
 * @author: guoyiguang
 * @create: 2021-08-14 11:13
 **/
@Service
public class DeptEmpServiceImpl extends ServiceImpl<DeptEmpMapper,DeptEmp> implements DeptEmpService {
}
