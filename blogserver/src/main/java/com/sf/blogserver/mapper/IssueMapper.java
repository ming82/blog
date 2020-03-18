package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Issue;
import com.sf.blogserver.query.IssueQuery;

import java.util.List;

public interface IssueMapper {
    int deleteByPrimaryKey(Integer issueId);

    int insert(Issue record);

    int insertSelective(Issue record);

    Issue selectByPrimaryKey(Integer issueId);

    List<Issue> selectAll();

    List<Issue> selectNoAnswer();

    List<Issue> selectHotIssues();

    int increaseAnswers(Integer issueId);

    int increaseFavorites(Integer issueId);

    List<Issue> selectByCategoryId(Integer categoryId);

    List<Issue> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);

    int updateToDelete(Integer issueId);

    List<Issue> selectByQuery(IssueQuery query);
}
