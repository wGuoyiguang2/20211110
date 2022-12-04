package com.example.demo.entity;

import java.util.Objects;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-16 12:39
 **/
public class CommodityOrderDetail {
    private Integer id ;
    private Integer orderId ;
    private String commodityName ;
    private String commodityId ;
    private Integer commodityCount ;
    private Integer isDelete;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCommodityCount() {
        return commodityCount;
    }

    public void setCommodityCount(Integer commodityCount) {
        this.commodityCount = commodityCount;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "CommodityOrderDetail{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", commodityCount=" + commodityCount +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommodityOrderDetail that = (CommodityOrderDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orderId);
    }
}
