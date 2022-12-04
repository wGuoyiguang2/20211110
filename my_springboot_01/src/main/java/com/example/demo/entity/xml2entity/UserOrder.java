package com.example.demo.entity.xml2entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * @program: springboot_01
 * @description: 用户订单
 * @author: guoyiguang  并添加xml和和bean转换的注解（注意，注解要写在get方法上）
 * @create: 2021-07-01 15:45
 **/
@JacksonXmlRootElement
public class UserOrder {

    private String id;
    private String orderNum;


    @JacksonXmlProperty(isAttribute = true,localName = "stype")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @JacksonXmlText()
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

}
