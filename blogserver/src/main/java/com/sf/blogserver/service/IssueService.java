package com.sf.blogserver.service;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.vo.IssueVo;

import java.util.List;

public interface IssueService {
    public List<IssueVo> selectAllIssue();

    public IssueVo selectIssueById(Integer issueId);

    public List<IssueVo> getIssuesByCategoryId(Integer categoryId);

    public List<IssueVo> getNoAnswer();

    public List<IssueVo> getHotIssues();

    public List<IssueVo> getIssuesByUserId(Integer userId);

    public int addNewIssue(Issue issue);

    public int deleteIssue(Integer issueId);
}
