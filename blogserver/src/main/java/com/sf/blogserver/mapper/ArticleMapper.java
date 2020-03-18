package com.sf.blogserver.mapper;

import com.sf.blogserver.query.ArticleQuery;
import com.sf.blogserver.bean.Article;
import com.sf.blogserver.vo.ArticleVo;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(ArticleVo record);

    int updateByPrimaryKeySelective(ArticleVo record);

    Article selectByPrimaryKey(Integer articleId);

    List<Article> selectAll();

    List<Article> selectByQuery(ArticleQuery query);

    List<Article> selectByUserId(Integer userId);

    List<Article> getDraft(Integer userId);

    List<Article> selectByCategoryId(Integer categoryId);

    int updateByPrimaryKey(Article record);

    int updateToDelete(Integer articleId);

    int increaseComment(Integer articleId);

    int increaseLike(Integer articleId);

    int increasePageview(Integer articleId);

    int increaseFavorite(Integer articleId);

    int decreaseFavorite(Integer articleId);

    List<Article> getHotArticles();

    List<Article> getNewArticles();
}
