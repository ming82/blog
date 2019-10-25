package com.sf.blogserver.mapper;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.bean.ArticleExample;
import java.util.List;

public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}