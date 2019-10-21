package com.jianping.pond.dao;

import com.jianping.pond.entity.UserRoleMap;

public interface UserRoleMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRoleMap record);

    int insertSelective(UserRoleMap record);

    UserRoleMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRoleMap record);

    int updateByPrimaryKey(UserRoleMap record);
}