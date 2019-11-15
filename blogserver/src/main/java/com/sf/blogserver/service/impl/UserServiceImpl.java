package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Role;
import com.sf.blogserver.bean.User;
import com.sf.blogserver.bean.UserRole;
import com.sf.blogserver.config.security.UserDetail;
import com.sf.blogserver.mapper.RoleMapper;
import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.mapper.UserRoleMapper;
import com.sf.blogserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 92802
 * @date 2019/11/5
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetail getUserByUsername(String userName) {
        User user = userMapper.selectByUsername(userName);
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(user.getUserId());
        userDetail.setUserName(user.getUserName());
        userDetail.setUserPassword(user.getUserPassword());
        userDetail.setUserEmail(user.getUserEmail());
        userDetail.setUserNickname(user.getUserNickname());
        userDetail.setUserPicture(user.getUserPicture());
        userDetail.setUserRegistetime(user.getUserRegistetime());
        userDetail.setUserStatus(user.getUserStatus());
        //注入用户角色
        List<Integer> roleIds = userRoleMapper.selectByUserId(user.getUserId());
        List<Role> roles = new ArrayList<>();
        for(Integer roleId:roleIds){
            roles.add(roleMapper.selectByPrimaryKey(roleId));
        }
        userDetail.setRoles(roles);
        return userDetail;
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int register(User user) {
        user.setUserRegistetime(new Date());
        int ret1 = userMapper.insertSelective(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getUserId());
        int ret2 = userRoleMapper.insertSelective(userRole);
        return ret1+ret2;
    }

    @Override
    public int nameCheck(String userName) {
        User user = userMapper.selectByUsername(userName);
        if(user == null){
            return 1;
        }
        else {
            return 0;
        }
    }
}
