package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.DeptEmp;

/**
 * @program:   此mapper  继承 BaseMapper 就 不需要写 crud 的方法（而且代码很简洁）
 * @description:
 * @author: guoyiguang
 * @create: 2021-08-14 11:11
 **/
public interface DeptEmpMapper extends BaseMapper<DeptEmp> {
}
