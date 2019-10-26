package com.sf.blogserver.service;

import com.sf.blogserver.vo.CommentVo;

import java.util.List;

public interface CommentService {

    List<CommentVo> getCommentByArticleId(Integer articleId);
}
