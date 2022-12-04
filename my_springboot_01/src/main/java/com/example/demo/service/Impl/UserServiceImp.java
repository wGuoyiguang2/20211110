package com.example.demo.service.Impl;

import com.example.demo.entity.Role;
import com.example.demo.entity.Vo.PermissionVo;
import com.example.demo.entity.Vo.UserVo;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImp implements UserService {

    @Override
    public UserVo getUserFromDataBase(String loginName) {
        if (null != loginName && "admin".equals(loginName)) {
            // 权限
            List<PermissionVo> userPermissions = new ArrayList<PermissionVo>();

            PermissionVo permissionVo1 = new PermissionVo("p1", "增加", "/admin/add");
            PermissionVo permissionVo2 = new PermissionVo("p2", "删除", "/admin/delete");
            PermissionVo permissionVo3 = new PermissionVo("p3", "修改", "/admin/update");
            PermissionVo permissionVo4 = new PermissionVo("p4", "查询", "/admin/get");

            userPermissions.add(permissionVo1);
            userPermissions.add(permissionVo2);
            userPermissions.add(permissionVo3);
            userPermissions.add(permissionVo4);
            //角色
            Role userRole = new Role("r1", "用户角色r1", userPermissions);
            List<Role> userRoles = new ArrayList<Role>();
            userRoles.add(userRole);
            //用户
            UserVo user = new UserVo("admin", "123456", userRoles);
            return user;
        } else {
            return null;
        }

    }

    @Override
    public boolean updateUserFromDataBase(String loginName) {

        return true;
    }

    @Override
    public UserVo getUserFromRedis(String loginName) {
        if (null != loginName && "admin".equals(loginName)) {
            // 权限
            PermissionVo permissionVo1 = new PermissionVo("p1", "增加", "/admin/add");
            PermissionVo permissionVo2 = new PermissionVo("p2", "删除", "/admin/delete");
            PermissionVo permissionVo3 = new PermissionVo("p3", "修改", "/admin/update");
            PermissionVo permissionVo4 = new PermissionVo("p4", "查询", "/admin/get");
            List<PermissionVo> userPermissions = new ArrayList<PermissionVo>();
            userPermissions.add(permissionVo1);
            userPermissions.add(permissionVo2);
            userPermissions.add(permissionVo3);
            userPermissions.add(permissionVo4);
            //角色
            Role userRole = new Role("r1", "用户角色r1", userPermissions);
            List<Role> userRoles = new ArrayList<Role>();
            userRoles.add(userRole);
            //用户
            UserVo user = new UserVo("admin", "123456", userRoles);
            return user;
        } else {
            return null;
        }
    }


    @Override
    public UserVo getUserFromRedisByToken(String token) {
        if ("admin".equals(token)) {
            // 权限
            List<PermissionVo> userPermissions = new ArrayList<PermissionVo>();
            PermissionVo permissionVo1 = new PermissionVo("p1", "增加", "/admin/add");
            PermissionVo permissionVo2 = new PermissionVo("p2", "删除", "/admin/delete");
            PermissionVo permissionVo3 = new PermissionVo("p3", "修改", "/admin/update");
            PermissionVo permissionVo4 = new PermissionVo("p4", "查询", "/admin/get");

            userPermissions.add(permissionVo1);
            userPermissions.add(permissionVo2);
            userPermissions.add(permissionVo3);
            userPermissions.add(permissionVo4);
            //角色
            Role userRole = new Role("r1", "用户角色r1", userPermissions);
            List<Role> userRoles = new ArrayList<Role>();
            userRoles.add(userRole);
            //用户
            UserVo user = new UserVo("admin", "123456", userRoles);
            return user;
        } else {
            return null;
        }
    }
}
