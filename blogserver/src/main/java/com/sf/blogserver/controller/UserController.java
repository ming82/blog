package com.sf.blogserver.controller;

import com.sf.blogserver.bean.User;
import com.sf.blogserver.service.UserService;
import com.sf.blogserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 92802
 * @date 2019/11/5
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/tologin")
    public ResponseUtil toLogin(){
        return ResponseUtil.fail("请先登录");
    }

    @GetMapping("/user/{userId}")
    public ResponseUtil getUserById(@PathVariable Integer userId) {
        return ResponseUtil.success("查询成功", userService.getUserById(userId));
    }

    @PostMapping("/user/")
    public ResponseUtil register(@RequestBody User user) {
        if (userService.register(user) == 2) {
            return ResponseUtil.success("注册成功，请登录");
        } else {
            return ResponseUtil.fail("注册失败,请重试");
        }
    }

    @GetMapping("/user/nameCheck")
    public ResponseUtil checkName(String userName){
        int res = userService.nameCheck(userName);
        if(res == 1){
            return ResponseUtil.success("无重复");
        }else {
            return ResponseUtil.fail("用户名重复");
        }
    }
}
