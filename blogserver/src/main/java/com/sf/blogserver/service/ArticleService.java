package com.sf.blogserver.service;


import com.github.pagehelper.PageInfo;
import com.sf.blogserver.query.ArticleQuery;
import com.sf.blogserver.vo.ArticleVo;

import java.util.List;

public interface ArticleService {
    /**
     * 分页查询文章
     * @param query 查询主体
     * @return
     */
    PageInfo getArticles(ArticleQuery query);

    /**
     * 获取热门文章
     * @return
     */
    List<ArticleVo> getHotArticles();

    /**
     * 获取最新文章
     * @return
     */
    List<ArticleVo> getNewArticles();

    /**
     * 根据文章ID获取文章
     * @param articleId 文章ID
     * @return
     */
    ArticleVo getArticleById(Integer articleId);

    /**
     * 给文章点赞
     * @param articleId 文章ID
     * @param userId 用户ID
     * @return
     */
    int likeArticle(Integer articleId,Integer userId);

    /**
     * 发布文章
     * @param article 文章实体
     * @return
     */
    int addNewArticle(ArticleVo article);

    /**
     * 修改文章
     * @param article 文章实体
     * @return
     */
    int updateArticle(ArticleVo article);

    /**
     * 删除文章
     * @param articleId 文章ID
     * @return
     */
    int deleteArticle(Integer articleId);

    /**
     * 获取用户草稿
     * @param userId 用户ID
     * @return
     */
    List<ArticleVo> getDraft(Integer userId);
}
