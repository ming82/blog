package com.sf.blogserver.service;

import com.github.pagehelper.PageInfo;
import com.sf.blogserver.bean.User;
import com.sf.blogserver.config.security.UserDetail;
import com.sf.blogserver.query.UserQuery;
import com.sf.blogserver.vo.UserVo;

public interface UserService {

    UserDetail getUserByUsername(String userName);

    User getUserById(Integer userId);

    int register(User user);

    int nameCheck(String userName,String userNickname);

    UserVo getUserInfo(Integer userId);

    int update(User user);

    int nickNameCheck(String userNickname);

    PageInfo getList(UserQuery query);

    int updatePermit(UserQuery user);
}
