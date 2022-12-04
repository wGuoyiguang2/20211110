package com.example.demo.entity;

import com.example.demo.entity.annotation.AttributeName;
import com.example.demo.entity.annotation.ValidAttribute;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:43
 **/
public class Region {

    private Integer id;

    @AttributeName("区域名称")
    private String name;
    private String code;
    private String parentCode;


    private Region parentRegion;




    private String isEnd;

    public Region() {
    }

    public Region(Integer id, String name, String code, String parentCode, String isEnd) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentCode = parentCode;
        this.isEnd = isEnd;
    }


    private String orderCode;

    public List<String> getSonNameList() {
        return sonNameList;
    }

    public void setSonNameList(List<String> sonNameList) {
        this.sonNameList = sonNameList;
    }

    @AttributeName("区域描述信息")
    private String description;
    // -------------------------------以下为 测试反射 字段------------------------
    private LocalDateTime createdTime;
    private String creator;

    /**
    * 是否有效（测试数字转汉字）
    */
    @AttributeName("是否有效")
    @ValidAttribute(isDeleted = 0)
    private Integer isDeteted;


    private Integer level;


    private List<String> sonNameList;


    private  List<Region> children;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getIsDeteted() {
        return isDeteted;
    }

    public void setIsDeteted(Integer isDeteted) {
        this.isDeteted = isDeteted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(id, region.id) &&
                Objects.equals(name, region.name) &&
                Objects.equals(code, region.code) &&
                Objects.equals(parentCode, region.parentCode);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Region> getChildren() {
        return children;
    }

    public void setChildren(List<Region> children) {
        this.children = children;
    }


    @Override
    public int hashCode() {

        return Objects.hash(id, name, code, parentCode, isEnd, orderCode);
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", orderCode=" + orderCode +
                ", description='" + description + '\'' +
                ", createdTime=" + createdTime +
                ", creator='" + creator + '\'' +
                ", isDeteted=" + isDeteted +
                ", level=" + level +
                ", sonNameList=" + sonNameList +
                '}';
    }

    public String getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(String isEnd) {
        this.isEnd = isEnd;
    }


    public Region getParentRegion() {
        return parentRegion;
    }

    public void setParentRegion(Region parentRegion) {
        this.parentRegion = parentRegion;
    }
}
