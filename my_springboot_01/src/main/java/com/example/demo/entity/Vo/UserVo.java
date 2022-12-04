package com.example.demo.entity.Vo;

import com.example.demo.entity.Role;
import lombok.Data;

import java.util.List;

public class UserVo {

    private String name;

    private String password;

    private List<Role> rolesList;

    public UserVo() {
    }

    public UserVo(String name, String password,List<Role> rolesList) {
        this.name = name;
        this.password = password;
        this.rolesList = rolesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Role> rolesList) {
        this.rolesList = rolesList;
    }

}
