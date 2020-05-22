package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.User;
import com.sf.blogserver.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectByQuery(UserQuery query);

    User selectByUsername(String userName);

    User selectByUserNickname(String userNickname);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByPrimaryKey(Integer userId);
}
