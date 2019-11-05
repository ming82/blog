package com.sf.blogserver.controller;

import com.sf.blogserver.service.UserService;
import com.sf.blogserver.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 92802
 * @date 2019/11/5
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{userId}")
    public ResponceUtil getUserById(@PathVariable Integer userId){
        return ResponceUtil.success("查询成功",userService.getUserById(userId));
    }
}
