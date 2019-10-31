package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.service.IssueService;
import com.sf.blogserver.util.ResponceUtil;
import com.sf.blogserver.vo.IssueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Discription
 * @author Hh
 * @package com.sf.blogserver.controller
 * @create 2019/10/27 16:30
 * @Version: 1.0
 */
@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    IssueService issueService;

    @GetMapping("/getAll")
    public ResponceUtil getAllIssue(){
        return ResponceUtil.success("查询成功",issueService.selectAllIssue());
    }
    @GetMapping("/getByUserId")
    public ResponceUtil getIssuesByUserId(Integer userId){
        return ResponceUtil.success("查询成功",issueService.getIssuesByUserId(userId));
    }

    @GetMapping("/{issueId}")
    public ResponceUtil getIssueById(@PathVariable Integer issueId){
        return ResponceUtil.success("查询成功",issueService.selectIssueById(issueId));
    }

    @PostMapping("/")
    public ResponceUtil addNewIssue(Issue issue){
        int result = issueService.addNewIssue(issue);
        if (result == 1) {
            return ResponceUtil.success("提问发表成功",null);
        } else {
            return ResponceUtil.fail("提问发表失败");
        }
    }

    @DeleteMapping("/{issueId}")
    public ResponceUtil deleteIssue(@PathVariable Integer issueId){
        int result = issueService.deleteIssue(issueId);
        if (result == 1) {
            return ResponceUtil.success("提问删除成功",null);
        } else {
            return ResponceUtil.fail("提问删除失败");
        }
    }

}
