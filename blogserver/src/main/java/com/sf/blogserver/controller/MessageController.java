package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Message;
import com.sf.blogserver.service.MessageService;
import com.sf.blogserver.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.controller
 * @create 2019/10/27 20:47
 * @Version: 1.0
 */
@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/selectByUserId")
    public List<Message> selectByUserId(Integer userId){
        return messageService.selectByUserId(userId);
    }

    @PostMapping("/deleteByPrimaryKey")
    public ResponceUtil deleteByPrimaryKey(Integer messageId){
        Integer result = messageService.deleteByPrimaryKey(messageId);
        if (result == 1) {
            return ResponceUtil.success("消息删除成功",null);
        } else {
            return ResponceUtil.fail("消息删除失败");
        }
    }
}
