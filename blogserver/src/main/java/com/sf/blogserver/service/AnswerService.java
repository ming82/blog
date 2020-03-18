package com.sf.blogserver.service;

import com.sf.blogserver.bean.Answer;
import com.sf.blogserver.vo.AnswerVo;

import java.util.List;

public interface AnswerService {
    List<AnswerVo> getAnswersByIssueId(Integer issueId);

    List<AnswerVo> getAnswersByUserId(Integer userId);

    int addAnswer(Answer answer);

    int deleteAnswer(Integer answerId);

    Answer getAnswerById(Integer answerId);
}
