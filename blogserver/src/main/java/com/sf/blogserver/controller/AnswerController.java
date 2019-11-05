package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Answer;
import com.sf.blogserver.service.AnswerService;
import com.sf.blogserver.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 92802
 * @date 2019/11/4
 */
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @GetMapping("/getAnswersByIssueId")
    public ResponceUtil getAnswersByIssueId(Integer issueId) {
        return ResponceUtil.success("查询成功", answerService.getAnswersByIssueId(issueId));
    }

    @GetMapping("/getAnswerByUserId")
    public ResponceUtil getAnswerByUserId(Integer userId) {
        return ResponceUtil.success("查询成功", answerService.getAnswersByUserId(userId));
    }

    @PostMapping("/")
    public ResponceUtil addAnswer(Answer answer) {
        int result = answerService.addAnswer(answer);
        if (result == 1) {
            return ResponceUtil.success("回答发表成功");
        } else {
            return ResponceUtil.fail("回答发表失败");
        }
    }

    @DeleteMapping("/{answerId}")
    public ResponceUtil deleteAnswer(@PathVariable Integer answerId) {
        if (answerService.deleteAnswer(answerId) == 1) {
            return ResponceUtil.success("删除成功");
        } else {
            return ResponceUtil.fail("删除失败");
        }
    }
}
