package com.example.demo.entity;


import com.example.demo.entity.Vo.PermissionVo;
import lombok.Data;

import java.util.List;

public class Role {
    private String id;
    private String name;
    private List<PermissionVo> permissions;


    public Role() {
    }
    public Role(String id, String name,List<PermissionVo> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionVo> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionVo> permissions) {
        this.permissions = permissions;
    }
}
