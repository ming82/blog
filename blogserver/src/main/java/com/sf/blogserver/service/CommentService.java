package com.sf.blogserver.service;

import com.sf.blogserver.bean.Comment;
import com.sf.blogserver.vo.CommentVo;

import java.util.List;

public interface CommentService {

    List<CommentVo> getCommentByArticleId(Integer articleId);

    List<CommentVo> getCommentByAnswerId(Integer answerId);

    int deleteComment(Integer commentId);

    int addNewComment(Comment comment);
}
