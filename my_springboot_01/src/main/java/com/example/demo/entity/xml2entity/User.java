package com.example.demo.entity.xml2entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-07-01 15:45
 **/
@JacksonXmlRootElement(localName ="USER_MESSAGE")
public class User {
    private Integer id;
    private String name;
    private String sex;
    private String phone;
    private List<UserOrder> UrlList;


    @JacksonXmlProperty(localName = "USER_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JacksonXmlProperty(localName = "USER_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JacksonXmlProperty(localName = "USER_SEX")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @JacksonXmlProperty(localName = "USER_PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    //集合的话必须添加这个注解
    @JacksonXmlElementWrapper(localName ="UrlList")
    //集合内部的元素
    @JacksonXmlProperty(localName = "Url")
    public List<UserOrder> getUrlList() {
        return UrlList;
    }

    public void setUrlList(List<UserOrder> orderList) {
        this.UrlList = orderList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", orderList=" + UrlList +
                '}';
    }
}
