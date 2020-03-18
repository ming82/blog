package com.sf.blogserver.config.security;

import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        if(user.getUserStatus()==0){
            throw new BadCredentialsException("用户已被冻结");
        }
        return user;
    }
}
