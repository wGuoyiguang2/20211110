package com.example.demo.entity.xml2entity;

import java.util.Locale;
import java.util.Objects;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-07-26 15:49
 **/
public class Student {

    private  String name ;
    private  String sex ;
    private  String address;



    public Student() {
   
    }

    public Student(String name, String sex, String address) {
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return equalsIgnoreCase(name, student.name) && equalsIgnoreCase(sex, student.sex) && equalsIgnoreCase(address, student.address);
    }

    @Override
    public int hashCode() {
       // System.out.println("调用了  hashCode 方法 ，value 为 "+Objects.hash(name, sex, address));
        // 这个是区分大小写的
      //  return Objects.hash(name, sex, address);

        System.out.println("调用了  hashCode 方法 ，value 为 "+Objects.hash(name, sex, address));
        return Objects.hash(name.toUpperCase(), sex.toUpperCase(), address.toUpperCase());

    }


    public static boolean equalsIgnoreCase(String a, String b) {
        return (a == b) || (a != null && a.equalsIgnoreCase(b));
    }
}
