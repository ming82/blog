package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Comment;
import com.sf.blogserver.bean.CommentExample;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}