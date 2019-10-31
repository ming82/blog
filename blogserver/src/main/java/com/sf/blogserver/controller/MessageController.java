package com.sf.blogserver.controller;

import com.sf.blogserver.service.MessageService;
import com.sf.blogserver.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Discription
 * @author Hh
 * @package com.sf.blogserver.controller
 * @create 2019/10/27 20:47
 * @Version: 1.0
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/getAllByUserId")
    public ResponceUtil getAllByUserId(Integer userId){
        return ResponceUtil.success("查询成功",messageService.getAllByUserId(userId));
    }

    @GetMapping("/getNoreadByUserId")
    public ResponceUtil getNoreadByUserId(Integer userId){
        return ResponceUtil.success("查询成功",messageService.getNoreadByUserId(userId));
    }
}
