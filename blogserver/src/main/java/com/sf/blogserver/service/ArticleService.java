package com.sf.blogserver.service;


import com.github.pagehelper.PageInfo;
import com.sf.blogserver.query.ArticleQuery;
import com.sf.blogserver.vo.ArticleVo;

import java.util.List;

public interface ArticleService {
    PageInfo getArticles(ArticleQuery query);

    List<ArticleVo> getArticlesByCategoryId(Integer categoryId);

    List<ArticleVo> getHotArticles();

    List<ArticleVo> getNewArticles();

    List<ArticleVo> getArticlesByUserId(Integer userId);

    ArticleVo getArticleById(Integer articleId);

    int likeArticle(Integer articleId,Integer userId);

    int addNewArticle(ArticleVo article);

    int updateArticle(ArticleVo article);

    int deleteArticle(Integer articleId);

    List<ArticleVo> getDraft(Integer userId);

    List<ArticleVo> searchArticle(String keyword);
}
