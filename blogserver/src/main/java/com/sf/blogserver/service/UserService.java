package com.sf.blogserver.service;

import com.sf.blogserver.bean.User;
import com.sf.blogserver.config.security.UserDetail;

public interface UserService {

    UserDetail getUserByUsername(String userName);

    User getUserById(Integer userId);

    int register(User user);

    int nameCheck(String userName);
}
