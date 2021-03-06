package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Answer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerMapper {
    int deleteByPrimaryKey(Integer answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer answerId);

    List<Answer> selectByIssueId(Integer issueId);

    List<Answer> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    int updateToDelete(Integer answerId);

    int increaseComment(Integer answerId);
}
