package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Answer;
import com.sf.blogserver.bean.User;
import com.sf.blogserver.mapper.AnswerMapper;
import com.sf.blogserver.mapper.ArticleMapper;
import com.sf.blogserver.mapper.IssueMapper;
import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.service.AnswerService;
import com.sf.blogserver.vo.AnswerVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AnswerMapper answerMapper;

    @Autowired
    IssueMapper issueMapper;
    @Value("${image_url}")
    String IMAGE_URL;

    @Override
    public List<AnswerVo> getAnswersByIssueId(Integer issueId) {
        return answerToVo(answerMapper.selectByIssueId(issueId));
    }

    @Override
    public List<AnswerVo> getAnswersByUserId(Integer userId) {
        return answerToVo(answerMapper.selectByUserId(userId));
    }

    @Transactional
    @Override
    public int addAnswer(Answer answer) {
        answer.setPublishdate(new Date());
        // 回答数加一
        if(answer.getIssueId() != null){
            issueMapper.increaseAnswers(answer.getIssueId());
        }
        return answerMapper.insertSelective(answer);
    }

    @Override
    public int deleteAnswer(Integer answerId) {
        return answerMapper.updateToDelete(answerId);
    }

    @Override
    public Answer getAnswerById(Integer answerId) {
        return answerMapper.selectByPrimaryKey(answerId);
    }

    List<AnswerVo> answerToVo(List<Answer> answers){
        List<AnswerVo> answerVos = new ArrayList<>();
        for(Answer answer:answers){
            AnswerVo answerVo = new AnswerVo();
            BeanUtils.copyProperties(answer,answerVo);
            //注入用户名,头像
            User user = userMapper.selectByPrimaryKey(answer.getUserId());
            answerVo.setUserNickname(user.getUserNickname());
            answerVo.setUserPicture(IMAGE_URL+user.getUserPicture());

            answerVos.add(answerVo);
        }

        return answerVos;
    }
}
