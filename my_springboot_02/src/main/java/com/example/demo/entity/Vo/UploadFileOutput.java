package com.example.demo.entity.Vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UploadFileOutput implements Serializable {
    /**
     * 文件名
     */
    private String name;
    /**
     * 主键
     */
    private String guid;

    public UploadFileOutput() {

    }


    public UploadFileOutput(String name, String guid) {
        this.name = name;
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "UploadFileOutput{" +
                "name='" + name + '\'' +
                ", guid='" + guid + '\'' +
                '}';
    }
}
