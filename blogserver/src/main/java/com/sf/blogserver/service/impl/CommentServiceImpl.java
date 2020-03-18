package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Comment;
import com.sf.blogserver.bean.Message;
import com.sf.blogserver.bean.User;
import com.sf.blogserver.mapper.*;
import com.sf.blogserver.service.CommentService;
import com.sf.blogserver.vo.CommentAnswerVo;
import com.sf.blogserver.vo.CommentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    AnswerMapper answerMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MessageMapper messageMapper;

    @Value("${image_url}")
    String IMAGE_URL;

    @Override
    public List<CommentVo> getCommentByArticleId(Integer articleId) {
        return commentToVo(commentMapper.selectByArticleId(articleId));
    }

    @Override
    public List<CommentVo> getCommentByAnswerId(Integer answerId) {
        return commentToVo(commentMapper.selectByAnswerId(answerId));
    }

    @Override
    public int deleteComment(Integer commentId) {
        return commentMapper.updateToDelete(commentId);
    }

    @Transactional
    @Override
    public int addNewComment(Comment comment) {
        Message message = new Message();
        if (comment.getArticleId() != null) {
            message.setArticleId(comment.getArticleId());
            //评论数加一
            articleMapper.increaseComment(comment.getArticleId());
        }
        if (comment.getAnswerId() != null) {
            message.setAnswerId(comment.getAnswerId());
            //评论数加一
            answerMapper.increaseComment(comment.getAnswerId());
        }
        message.setCommentuserid(comment.getUserId());
        if (comment.getCommentTo() != null && comment.getCommentTo() != "") {
            //设置成回复
            message.setMessageType(2);
            message.setUserId(userMapper.selectByUserNickname(comment.getCommentTo()).getUserId());
            //设置回复的articleId或answerId,用于跳转
            Comment commentArAn = commentMapper.selectByPrimaryKey(comment.getCommentParentid());
            if (commentArAn.getArticleId() != null) {
                message.setArticleId(commentArAn.getArticleId());
            }
            if (commentArAn.getAnswerId() != null) {
                message.setAnswerId(commentArAn.getAnswerId());
            }
        } else {
            if (comment.getArticleId() != null) {
                message.setUserId(articleMapper.selectByPrimaryKey(comment.getArticleId()).getUserId());
            }
            if (comment.getAnswerId() != null) {
                message.setUserId(answerMapper.selectByPrimaryKey(comment.getAnswerId()).getUserId());
            }
        }
        comment.setPublishdate(new Date());
        commentMapper.insertSelective(comment);
        message.setPublishdate(new Date());
        message.setCommentId(comment.getCommentId());
        return messageMapper.insertSelective(message);
    }


    List<CommentVo> commentToVo(List<Comment> comments) {
        //返回给界面的评论集合
        List<CommentVo> commentVos = new ArrayList<>();

        for (Comment comment : comments) {
            CommentVo commentVo = new CommentVo();
            BeanUtils.copyProperties(comment, commentVo);
            //获取用户名,头像
            User user1 = userMapper.selectByPrimaryKey(comment.getUserId());
            commentVo.setUserNickname(user1.getUserNickname());
            commentVo.setUserPicture(IMAGE_URL+user1.getUserPicture());
            //获取评论回复
            //为commentVos中的commentAnswers赋值
            List<CommentAnswerVo> commentAnswerVos = new ArrayList<>();
            //获取comment_parentId为该commentId的评论集合
            List<Comment> commentAnswers = commentMapper.selectByParentId(comment.getCommentId());
            for (Comment commentAnswer : commentAnswers) {
                CommentAnswerVo commentAnswerVo = new CommentAnswerVo();
                BeanUtils.copyProperties(commentAnswer, commentAnswerVo);
                User user = userMapper.selectByPrimaryKey(commentAnswer.getUserId());
                commentAnswerVo.setUserNickname(user.getUserNickname());
                commentAnswerVo.setUserPicture(IMAGE_URL+user.getUserPicture());
                //获取被回复人id
                commentAnswerVo.setCommentToUserId(userMapper.selectByUserNickname(commentAnswer.getCommentTo()).getUserId());

                commentAnswerVos.add(commentAnswerVo);
            }
            commentVo.setCommentAnswers(commentAnswerVos);

            commentVos.add(commentVo);
        }
        return commentVos;
    }
}
