package com.example.demo.entity.Vo;

import com.example.demo.entity.CommodityOrderDetail;
import java.util.List;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-16 12:37
 **/
public class CommodityOrderVo {
    private Integer id ;
    private String name ;
    private Integer isDelete;

    private List<CommodityOrderDetail> toEditDetailsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public List<CommodityOrderDetail> getDetailsList() {
        return toEditDetailsList;
    }

    public void setDetailsList(List<CommodityOrderDetail> detailsList) {
        this.toEditDetailsList = detailsList;
    }

    @Override
    public String toString() {
        return "CommodityOrder{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isDelete=" + isDelete +
                ", toEditDetailsList=" + toEditDetailsList +
                '}';
    }
}
