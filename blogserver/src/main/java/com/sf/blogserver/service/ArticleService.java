package com.sf.blogserver.service;


import com.sf.blogserver.bean.Article;
import com.sf.blogserver.vo.ArticleVo;

import java.util.List;

public interface ArticleService {
    List<ArticleVo> selectAllArticle();

    List<Article> selectArticlesByCategoryId(Integer categoryId);

    Article selectArticleByPrimaryKey(Integer articleId);

    int addNewArticle(Article article);

    int updateArticle(Article article);

    int deleteArticle(Integer articleId);


}
