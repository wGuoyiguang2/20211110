package com.example.demo.entity.Vo;

import java.util.Objects;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 16:25
 **/
public class Province {
    private String name;
    private String code;
    private String parentCode;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return Objects.equals(name, province.name) &&
                Objects.equals(code, province.code) &&
                Objects.equals(parentCode, province.parentCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, code, parentCode);
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentCode='" + parentCode + '\'' +
                '}';
    }


}
