package com.sf.blogserver.service;


import com.sf.blogserver.bean.Article;
import com.sf.blogserver.bean.Tag;
import com.sf.blogserver.vo.ArticleVo;

import java.util.List;

public interface ArticleService {
    List<ArticleVo> getAllArticle();

    List<ArticleVo> getArticlesByCategoryId(Integer categoryId);

    List<ArticleVo> getHotArticles();

    List<ArticleVo> getNewArticles();

    List<ArticleVo> getArticlesByUserId(Integer userId);

    ArticleVo getArticleById(Integer articleId);

    int likeArticle(Integer articleId,Integer userId);

    int addNewArticle(ArticleVo article);

    int updateArticle(Article article);

    int deleteArticle(Integer articleId);

    List<ArticleVo> getDraft(Integer userId);
}
