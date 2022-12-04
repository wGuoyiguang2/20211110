package com.example.demo.entity.Vo;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-04-14 15:59
 **/
public class RoomDto {

    private String bldguid ;

    private Integer status ;


    public RoomDto() {

    }


    public RoomDto(String bldguid, Integer status) {
        this.bldguid = bldguid;
        this.status = status;
    }

    public String getBldguid() {
        return bldguid;
    }

    public void setBldguid(String bldguid) {
        this.bldguid = bldguid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
