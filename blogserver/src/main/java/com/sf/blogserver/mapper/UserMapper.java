package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    User selectByUsername(String userName);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
