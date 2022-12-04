package com.example.demo.service;


import com.example.demo.entity.Vo.UserVo;

public interface UserService {

    public UserVo getUserFromDataBase(String loginName);

    public boolean updateUserFromDataBase(String loginName);

    public UserVo getUserFromRedis(String loginName);

    public UserVo getUserFromRedisByToken(String token);
}
