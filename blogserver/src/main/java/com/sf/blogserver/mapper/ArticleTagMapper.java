package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.ArticleTag;

import java.util.List;

public interface ArticleTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);

    ArticleTag selectByPrimaryKey(Integer id);

    List<Integer> selectTagIdByArticleId(Integer articleId);

    int updateByPrimaryKeySelective(ArticleTag record);

    int updateByPrimaryKey(ArticleTag record);
}
