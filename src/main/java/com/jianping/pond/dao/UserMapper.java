package com.jianping.pond.dao;

import com.jianping.pond.entity.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<UserInfo> getAllUser();
}
