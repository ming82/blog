package com.sf.blogserver.service;

import com.github.pagehelper.PageInfo;
import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.query.IssueQuery;
import com.sf.blogserver.vo.IssueVo;

import java.util.List;

public interface IssueService {

    public IssueVo selectIssueById(Integer issueId);

    public List<IssueVo> getNoAnswer();

    public List<IssueVo> getHotIssues();

    public List<IssueVo> getIssuesByUserId(Integer userId);

    public int addNewIssue(Issue issue);

    public int deleteIssue(Integer issueId);

    PageInfo getIssues(IssueQuery query);

    int updateIssue(IssueVo issue);
}
