package com.sf.blogserver.controller;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.service.IssueService;
import com.sf.blogserver.util.ResponceUtil;
import com.sf.blogserver.vo.IssueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.controller
 * @create 2019/10/27 16:30
 * @Version: 1.0
 */
@RestController
public class IssueController {
    @Autowired
    IssueService issueService;

    @GetMapping("/selectAllIssue")
    public List<IssueVo> selectAllIssue(){
        return issueService.selectAllIssue();
    }

    @PostMapping("/addNewIssue")
    public ResponceUtil addNewIssue(Issue issue){
        int result = issueService.addNewIssue(issue);
        if (result == 1) {
            return ResponceUtil.success("问题发表成功",null);
        } else {
            return ResponceUtil.fail("问题发表失败");
        }
    }

    @PostMapping("/deleteIssue")
    public ResponceUtil deleteIssue(Integer issueId){
        int result = issueService.deleteIssue(issueId);
        if (result == 1) {
            return ResponceUtil.success("问题删除成功",null);
        } else {
            return ResponceUtil.fail("问题删除失败");
        }
    }

}
