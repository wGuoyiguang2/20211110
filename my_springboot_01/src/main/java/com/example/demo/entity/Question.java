package com.example.demo.entity;

import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-02-24 19:56
 **/
public class Question {
    //ID
    private	String id;
    //问题
    private	String content;
    //问题类型 1:单选,2:多选,3:问答
    private	String type;
    //排序
    private	Integer sort;
    //问题选项 *** 问题表里不需要有这个属性对应的字段
    private List<QuestionOption> options;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<QuestionOption> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOption> options) {
        this.options = options;
    }
}
