package com.example.demo.entity.Vo;

import java.util.Objects;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 16:27
 **/
public class Street {
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
        Street city = (Street) o;
        return Objects.equals(name, city.name) &&
                Objects.equals(code, city.code) &&
                Objects.equals(parentCode, city.parentCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, code, parentCode);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentCode='" + parentCode + '\'' +
                '}';
    }
}
