package com.sf.blogserver.service;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.vo.IssueVo;

import java.util.List;

public interface IssueService {
    public List<IssueVo> selectAllIssue();

    public IssueVo selectIssueByPrimaryKey(Integer issueId);

    public int addNewIssue(Issue issue);

    public int updateIssue(Issue issue);

    public int deleteIssue(Issue issue);
}
