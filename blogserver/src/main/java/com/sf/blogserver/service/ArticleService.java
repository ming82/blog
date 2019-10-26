package com.sf.blogserver.service;


import com.sf.blogserver.bean.Article;

import java.util.List;

public interface ArticleService {
    List<Article> selectAllArticle();

    Article selectArticleByPrimaryKey(Integer articleId);

    int addNewArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(Integer articleId);


}
