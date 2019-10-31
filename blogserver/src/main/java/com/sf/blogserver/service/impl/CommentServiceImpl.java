package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Comment;
import com.sf.blogserver.mapper.CommentMapper;
import com.sf.blogserver.mapper.UserMapper;
import com.sf.blogserver.service.CommentService;
import com.sf.blogserver.vo.CommentAnswerVo;
import com.sf.blogserver.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<CommentVo> getCommentByArticleId(Integer articleId) {
        List<CommentVo> commentVos = new ArrayList<>();//返回给界面的评论集合
        List<Comment> comments = commentMapper.selectByArticleId(articleId);
        for (Comment comment:comments){
            CommentVo commentVo = new CommentVo();
            commentVo.setAnswerId(comment.getAnswerId());
            commentVo.setArticleId(comment.getArticleId());
            commentVo.setCommentBody(comment.getCommentBody());
            commentVo.setCommentId(comment.getCommentId());
            commentVo.setPublishdate(comment.getPublishdate());
            commentVo.setUserId(comment.getUserId());
            //获取用户名
            commentVo.setUserNickname(userMapper.selectByPrimaryKey(comment.getUserId()).getUserNickname());
            //获取评论回复
            List<CommentAnswerVo> commentAnswerVos = new ArrayList<>();//为commentVos中的commentAnswers赋值
            List<Comment> commentAnswers = commentMapper.selectByParentId(comment.getCommentId());//获取comment_parentId为该commentId的评论集合
            for (Comment commentAnswer:commentAnswers){
                CommentAnswerVo commentAnswerVo = new CommentAnswerVo();

                commentAnswerVo.setCommentBody(commentAnswer.getCommentBody());
                commentAnswerVo.setPublishdate(commentAnswer.getPublishdate());
                commentAnswerVo.setUserNickname(userMapper.selectByPrimaryKey(commentAnswer.getUserId()).getUserNickname());
                commentAnswerVo.setCommentParentUserNickname(userMapper.selectByPrimaryKey(
                        commentMapper.selectByPrimaryKey(commentAnswer.getCommentParentid()).getUserId()).getUserNickname());

                commentAnswerVos.add(commentAnswerVo);
            }
            commentVo.setCommentAnswers(commentAnswerVos);

            commentVos.add(commentVo);
        }
        return commentVos;
    }

    @Override
    public int deleteComment(Integer commentId) {
        return commentMapper.updateToDelete(commentId);
    }

    @Override
    public int addNewComment(Comment comment) {
        return commentMapper.insertSelective(comment);
    }
}
