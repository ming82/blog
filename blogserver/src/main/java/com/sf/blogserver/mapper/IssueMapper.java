package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.bean.IssueExample;
import java.util.List;

public interface IssueMapper {
    int deleteByPrimaryKey(Integer issueId);

    int insert(Issue record);

    int insertSelective(Issue record);

    List<Issue> selectByExample(IssueExample example);

    Issue selectByPrimaryKey(Integer issueId);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);
}