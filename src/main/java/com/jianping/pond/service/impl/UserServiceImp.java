package com.jianping.pond.service.impl;

import com.jianping.pond.dao.UserMapper;
import com.jianping.pond.entity.UserInfo;
import com.jianping.pond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImp implements UserService
{

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserInfo> getAllUser() {
        return userMapper.getAllUser();
    }


}
