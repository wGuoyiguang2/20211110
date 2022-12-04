package com.example.demo.entity.xml2entity;

import java.util.Objects;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-07-26 15:49
 **/
public class StudentNoOverwrite {

    private  String name ;
    private  String sex ;
    private  String address;



    public StudentNoOverwrite() {

    }

    public StudentNoOverwrite(String name, String sex, String address) {
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
        StudentNoOverwrite student = (StudentNoOverwrite) o;
        return equalsIgnoreCase(name, student.name) && equalsIgnoreCase(sex, student.sex) && equalsIgnoreCase(address, student.address);
    }
    public static boolean equalsIgnoreCase(String a, String b) {
        return (a == b) || (a != null && a.equalsIgnoreCase(b));
    }
}
