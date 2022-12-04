package com.example.demo.entity.xml2entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author zhouliang
 * @Date 2021/7/1 18:42
 */
//@ToString
@JacksonXmlRootElement
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY,getterVisibility= JsonAutoDetect.Visibility.NONE)
public class Url implements Serializable {


    private String type;



    private  String Url;

    @JacksonXmlProperty(isAttribute = true,localName = "stype")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @JacksonXmlText()
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "type='" + type + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }
}
