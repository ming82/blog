package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
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

    int updateToDelete(Integer commentId);
}
