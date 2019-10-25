package com.sf.blogserver.service;


import com.sf.blogserver.bean.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getArticleById(Integer articleId);
}
