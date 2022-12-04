package com.example.demo.entity;

/**
 * @program: springboot_01
 * @description: 日志记录
 * @author: guoyiguang
 * @create: 2021-02-21 09:38
 **/
public class Log {

    // 属性名称
    private String name;
    private String column;
    private String oldValue;
    private String lastValue;
    private Integer isDeleted;

    public Log() {}

    public Log(String oldValue, String lastValue, String name,String column) {
        this.name = name;
        this.column = column;
        this.oldValue = oldValue;
        this.lastValue = lastValue;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getOldValue() {
        return oldValue;
    }
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }
    public String getLastValue() {
        return lastValue;
    }
    public void setLastValue(String lastValue) {
        this.lastValue = lastValue;
    }

    @Override
    public String toString() {
        return "Log{" +
                "name='" + name + '\'' +
                ", column='" + column + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", lastValue='" + lastValue + '\'' +
                '}';
    }
}
