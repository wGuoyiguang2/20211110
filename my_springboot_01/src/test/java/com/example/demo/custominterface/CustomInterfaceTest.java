//package com.example.demo.custominterface;
//
//
//import com.example.demo.customexception.BusinessException;
//import com.example.demo.entity.Employee;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import java.util.*;
//
///**
// * @program: springboot_01
// * @description:
// * @author: guoyiguang
// * @create: 2021-01-04 16:53
// **/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=CustomInterfaceTest.class)
//public class CustomInterfaceTest {
//    @Test
//    public void validateTest() {
//
//        Employee employee = new Employee();
//        //employee.setName("慕容皝");
//        //employee.setPhone("15011133054");
//        //employee.setDescription("慕容皝慕容皝");
//        List addressList = new ArrayList();
//        addressList.add("北京市海淀区");
//        addressList.add("北京市朝阳区");
//        addressList.add("北京市昌平区");
//        addressList.add("北京市大兴区");
//        //employee.setAddresses(addressList);
//        Set emergencySet = new TreeSet();
//        emergencySet.add("慕容皝");
//        employee.setEmergencyName(emergencySet);
//        boolean b(银行按揭付款) = false;
//        try {
//            b(银行按揭付款) =  ValidateUtil.validateIsNull(employee);
//        } catch (BusinessException e) {
//            System.out.println(e.getMsg());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
////        try {
////            Object o = ValidateUtil.cutString(employee);
////            employee = (Employee)o ;
////            System.out.println(employee);
////        } catch (IllegalAccessException e) {
////            e.printStackTrace();
////        }
//
//    }
//
//
//
//
//
//
//
//
//
//
//}
