package com.example.demo.entity;

import com.example.demo.entity.annotation.Must;
import lombok.Data;

import java.io.Serializable;


@Data
public class TestForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Must
    private int age;

    @Must
    private String name;

    private String[] pics;

    private long goodsIds;
}
