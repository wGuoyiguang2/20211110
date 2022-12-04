//package com.example.demo.controller;
//
//import com.example.demo.entity.DeptEmp;
//import com.example.demo.service.DeptEmpService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @program: pring-boot-mybatis-plus
// * @description:
// * @author: guoyiguang
// * @create: 2021-08-14 15:14
// **/
//@RestController("/deptEmpMapperController")
//public class DeptEmpMapperApiController {
//
//    @Autowired
//    DeptEmpService deptEmpService;
//
//
//    /**
//     *
//     * * * * * * * * * * * * * * * * * * * * * * * *  * *     Mapper CRUD 接口 * * * * * * * * * * * *  * * * * * * * * * * * * * *
//     *
//     */
//
//
//    /**
//     *
//     *  只更新空串，不会更新null
//     *sql：
//     * UPDATE dept_emp_59 SET description=''
//     *  WHERE id='5';
//     *
//    */
//    @PostMapping(value = "/updateById")
//    public boolean updateById() {
//        // 用实体更新
//        DeptEmp deptEmp = new DeptEmp();
//        deptEmp.setId("5");
//        deptEmp.setDescription("");
//        deptEmp.setFromDate(null);
//        deptEmp.setToDate(null);
//
//        boolean result = deptEmpService.updateById(deptEmp);
//        return result;
//    }
//
//}
