package com.sf.blogserver.service.impl;

import com.sf.blogserver.bean.Article;
import com.sf.blogserver.mapper.ArticleMapper;
import com.sf.blogserver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Discription
 * @auther Hh
 * @package com.sf.blogserver.service.impl
 * @create 2019/10/25 16:14
 * @Version: 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> selectAllArticle() {

        return articleMapper.selectAll();
    }

    @Override
    public Article selectArticleByPrimaryKey(Integer articleId) {

        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public int addNewArticle(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateByPrimaryKey(article);
    }

    @Override
    public int deleteArticle(Integer articleId) {

        return articleMapper.deleteByPrimaryKey(articleId);
    }
}
