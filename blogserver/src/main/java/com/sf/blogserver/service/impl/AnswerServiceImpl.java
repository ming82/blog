package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Answer;
import com.sf.blogserver.mapper.AnswerMapper;
import com.sf.blogserver.mapper.ArticleMapper;
import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.service.AnswerService;
import com.sf.blogserver.vo.AnswerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 92802
 * @date 2019/11/4
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AnswerMapper answerMapper;

    @Override
    public List<AnswerVo> getAnswersByIssueId(Integer issueId) {
        return answerToVo(answerMapper.selectByIssueId(issueId));
    }

    @Override
    public List<AnswerVo> getAnswersByUserId(Integer userId) {
        return answerToVo(answerMapper.selectByUserId(userId));
    }

    @Override
    public int addAnswer(Answer answer) {
        return answerMapper.insertSelective(answer);
    }

    @Override
    public int deleteAnswer(Integer answerId) {
        return answerMapper.updateToDelete(answerId);
    }

    List<AnswerVo> answerToVo(List<Answer> answers){
        List<AnswerVo> answerVos = new ArrayList<>();
        for(Answer answer:answers){
            AnswerVo answerVo = new AnswerVo();
            answerVo.setAnswerId(answer.getAnswerId());
            answerVo.setHtmlcontent(answer.getHtmlcontent());
            answerVo.setIssueId(answer.getIssueId());
            answerVo.setMdcontent(answer.getMdcontent());
            answerVo.setPublishdate(answer.getPublishdate());
            answerVo.setUserId(answer.getUserId());
            //注入用户名
            answerVo.setUserNickname(userMapper.selectByPrimaryKey(answer.getUserId()).getUserNickname());

            answerVos.add(answerVo);
        }

        return answerVos;
    }
}
