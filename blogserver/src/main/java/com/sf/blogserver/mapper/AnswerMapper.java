package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Answer;
import com.sf.blogserver.bean.AnswerExample;
import java.util.List;

public interface AnswerMapper {
    long countByExample(AnswerExample example);

    int deleteByPrimaryKey(Integer answerId);

    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}