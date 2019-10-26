package com.sf.blogserver.service;


import com.sf.blogserver.bean.Article;

import java.util.List;

public interface ArticleService {
    List<Article> selectAllArticle();
    Article selectArticleByPrimaryKey(Integer articleId);
    void addNewArticle(Article article);
    void updateArticle(Article article);
    int deleteArticle(Integer articleId);







}
