package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectByAnswerId(Integer answerId);

    List<Comment> selectByArticleId(Integer articleId);

    List<Comment> selectByParentId(Integer parentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}
