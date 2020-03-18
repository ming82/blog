package com.sf.blogserver.controller;

import com.sf.blogserver.service.MessageService;
import com.sf.blogserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    @GetMapping("/getRead")
    public ResponseUtil getReadByUserId(Integer userId){
        return ResponseUtil.success("查询成功",messageService.getReadByUserId(userId));
    }

    @GetMapping("/getNoread")
    public ResponseUtil getNoreadByUserId(Integer userId){
        return ResponseUtil.success("查询成功",messageService.getNoreadByUserId(userId));
    }

    @PostMapping("/markRead")
    public ResponseUtil markRead(@RequestBody Map<String,List<Integer>> list){
        if(messageService.markRead(list.get("list")) == 1){
            return ResponseUtil.success("标记成功");
        }else {
            return ResponseUtil.fail("标记失败");
        }
    }

    @GetMapping("/countNoRead")
    public ResponseUtil countNoread(Integer userId){
        return ResponseUtil.success("查询成功",messageService.countNoRead(userId));
    }
}
