package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.query.ArticleQuery;
import com.sf.blogserver.query.IssueQuery;
import com.sf.blogserver.service.IssueService;
import com.sf.blogserver.util.ResponseUtil;
import com.sf.blogserver.vo.ArticleVo;
import com.sf.blogserver.vo.IssueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    IssueService issueService;

    @GetMapping("/common/getList")
    public ResponseUtil getIssuesList(IssueQuery query){
        return ResponseUtil.success("查询成功",issueService.getIssues(query));
    }

    @GetMapping("/common/getByUserId")
    public ResponseUtil getIssuesByUserId(Integer userId){
        return ResponseUtil.success("查询成功",issueService.getIssuesByUserId(userId));
    }
    @GetMapping("/common/getNoAnswers")
    public ResponseUtil getNoAnswers(){
        return ResponseUtil.success("查询成功",issueService.getNoAnswer());
    }

    @GetMapping("/common/getHotIssues")
    public ResponseUtil getHotIssues(){
        return ResponseUtil.success("查询成功",issueService.getHotIssues());
    }

    @GetMapping("/common/{issueId}")
    public ResponseUtil getIssueById(@PathVariable Integer issueId){
        return ResponseUtil.success("查询成功",issueService.selectIssueById(issueId));
    }

    @PostMapping("/")
    public ResponseUtil addNewIssue(@RequestBody Issue issue){
        int result = issueService.addNewIssue(issue);
        if (result == 1) {
            return ResponseUtil.success("提问发表成功",null);
        } else {
            return ResponseUtil.fail("提问发表失败");
        }
    }

    @PutMapping("/")
    public ResponseUtil editIssue(@RequestBody IssueVo issue){
        int result = issueService.updateIssue(issue);
        if (result == 1) {
            return ResponseUtil.success("提问更新成功");
        } else {
            return ResponseUtil.fail("提问更新失败");
        }
    }

    @DeleteMapping("/{issueId}")
    public ResponseUtil deleteIssue(@PathVariable Integer issueId){
        int result = issueService.deleteIssue(issueId);
        if (result == 1) {
            return ResponseUtil.success("提问删除成功",null);
        } else {
            return ResponseUtil.fail("提问删除失败");
        }
    }

}
