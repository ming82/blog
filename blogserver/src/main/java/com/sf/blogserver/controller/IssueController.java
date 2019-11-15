package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.service.IssueService;
import com.sf.blogserver.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseUtil getAllIssue(){
        return ResponseUtil.success("查询成功",issueService.selectAllIssue());
    }
    @GetMapping("/getByUserId")
    public ResponseUtil getIssuesByUserId(Integer userId){
        return ResponseUtil.success("查询成功",issueService.getIssuesByUserId(userId));
    }
    @GetMapping("/getByCategoryId")
    public ResponseUtil getIssuesByCategoryId(Integer categoryId){
        return ResponseUtil.success("查询成功",issueService.getIssuesByCategoryId(categoryId));
    }
    @GetMapping("/getNoAnswers")
    public ResponseUtil getNoAnswers(){
        return ResponseUtil.success("查询成功",issueService.getNoAnswer());
    }
    @GetMapping("/getHotIssues")
    public ResponseUtil getHotIssues(){
        return ResponseUtil.success("查询成功",issueService.getHotIssues());
    }

    @GetMapping("/{issueId}")
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
