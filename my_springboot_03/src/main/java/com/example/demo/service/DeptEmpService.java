package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.DeptEmp;

/**
* @Description: 写 DeptEmp 业务方法，同时 继承 mybatisplus 的 IService ，此接口就不需要扩展 通用的 crud 方法
* @Param:  
* @return:  
* @Author: guoyiguang
* @Date:  
*/ 
public interface DeptEmpService extends IService<DeptEmp> {
}
