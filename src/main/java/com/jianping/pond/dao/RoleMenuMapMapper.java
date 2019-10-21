package com.jianping.pond.dao;

import com.jianping.pond.entity.RoleMenuMap;

public interface RoleMenuMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleMenuMap record);

    int insertSelective(RoleMenuMap record);

    RoleMenuMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleMenuMap record);

    int updateByPrimaryKey(RoleMenuMap record);
}