package com.sf.blogserver.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 文章实体类
 * @author SM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    /**
     * 文章ID
     */
    private Integer articleId;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章内容
     */
    private String mdcontent;
    /**
     * HTML内容
     */
    private String htmlcontent;
    /**
     * 文章摘要
     */
    private String articleSummary;
    /**
     * 文章所属栏目ID
     */
    private Integer categoryId;
    /**
     * 文章作者ID
     */
    private Integer userId;
    /**
     * 文章发布日期
     */
    private Date publishdate;
    /**
     * 文章最近编辑日期
     */
    private Date edittime;
    /**
     * 文章状态 0：删除 1：已发表 2：草稿箱
     */
    private Integer articleStatus;
    /**
     * 文章浏览量
     */
    private Integer articlePageviews;
    /**
     * 文章点赞数
     */
    private Integer articleLikes;
    /**
     * 文章评论数
     */
    private Integer articleComments;
    /**
     * 文章收藏数
     */
    private Integer articleFavorites;
}
