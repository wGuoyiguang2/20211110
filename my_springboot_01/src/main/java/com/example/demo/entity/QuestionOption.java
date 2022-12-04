package com.example.demo.entity;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-02-24 19:56
 **/
public class QuestionOption {
    //ID
    private	String id;
    //问题ID *** 问题选项表里需要有这个属性对应的字段
    private	String qid;
    //选项
    private	String content;
    //排序
    private	Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
