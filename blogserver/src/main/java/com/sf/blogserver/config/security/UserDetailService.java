package com.sf.blogserver.config.security;

import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 92802
 * @date 2019/11/5
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetail user = userService.getUserByUsername(s);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}
