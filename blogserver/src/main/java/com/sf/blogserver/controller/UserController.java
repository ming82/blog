package com.sf.blogserver.controller;

import com.sf.blogserver.bean.User;
import com.sf.blogserver.query.UserQuery;
import com.sf.blogserver.service.UserService;
import com.sf.blogserver.util.ResponseUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Objects;

@RestController
@CrossOrigin
public class UserController {
    @Value("${upload-folder}")
    private String UPLOAD_FOLDER;

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

    @GetMapping("/user/getList")
    public ResponseUtil getList(UserQuery query){
        return ResponseUtil.success("查询成功",userService.getList(query));
    }

    @PutMapping("/user/")
    public ResponseUtil update(@RequestBody User user) {
        if (userService.update(user) == 1) {
            return ResponseUtil.success("修改成功");
        } else {
            return ResponseUtil.fail("修改失败");
        }
    }


    @PutMapping("/user/editPermit")
    public ResponseUtil updatePermit(@RequestBody UserQuery user) {
        if (userService.updatePermit(user) == 1) {
            return ResponseUtil.success("权限修改成功");
        } else {
            return ResponseUtil.fail("权限修改失败");
        }
    }

    @GetMapping("/user/nameCheck")
    public ResponseUtil checkName(@RequestParam("userName") String userName,@RequestParam("userNickname") String userNickname){
        int res = userService.nameCheck(userName,userNickname);
        if(res == 1){
            return ResponseUtil.fail("用户名重复");
        }else if(res == 2){
            return ResponseUtil.fail("用户昵称重复");
        }else
            return ResponseUtil.success("无重复");
    }
    @GetMapping("/user/nickNameCheck")
    public ResponseUtil nickNameCheck(@RequestParam("userNickname") String userNickname){
        int res = userService.nickNameCheck(userNickname);
        if(res == 0){
            return ResponseUtil.fail("用户昵称重复");
        }else
            return ResponseUtil.success("无重复");
    }

    @GetMapping("/userInfo/{userId}")
    public ResponseUtil getUserInfo(@PathVariable Integer userId) {
        return ResponseUtil.success("查询成功",userService.getUserInfo(userId));
    }

    @PostMapping("/uploadImage")
    public ResponseUtil imageUpload(MultipartFile file) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return ResponseUtil.fail("图片为空，请重新上传");
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            return ResponseUtil.success("上传成功",file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.fail("后端异常...");
        }
    }
}
