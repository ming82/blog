package com.sf.blogserver.service;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.vo.IssueVo;

import java.util.List;

public interface IssueService {
    public List<IssueVo> selectAllIssue();

    public Issue selectIssueById(Integer issueId);

    public List<IssueVo> getIssuesByUserId(Integer userId);

    public int addNewIssue(Issue issue);

    public int deleteIssue(Integer issueId);
}
