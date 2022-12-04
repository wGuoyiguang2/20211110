package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-08-14 11:07
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("dept_emp_59")
public class DeptEmp {

@TableId(type=IdType.NONE )
private String id;
private String empNo;
private String deptNo;
private LocalDate fromDate;
private LocalDate toDate;
private String description;
}
