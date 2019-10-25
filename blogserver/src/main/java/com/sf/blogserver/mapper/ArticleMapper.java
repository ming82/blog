package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    List<Article> selectAll();

    List<Article> selectByUserId(Integer userId);

    List<Article> selectByCategoryId(Integer categoryId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}
