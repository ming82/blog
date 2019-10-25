package com.sf.blogserver.bean;

import lombok.ToString;

import java.util.Date;

@ToString
public class Article {
    private Integer articleId;

    private String articleTitle;

    private String mdcontent;

    private String htmlcontent;

    private String articleSummary;

    private Integer categoryId;

    private Integer userId;

    private Date publishdate;

    private Date edittime;

    private Integer articleState;

    private Integer articlePageviews;

    private Integer articleLikes;

    private Integer articleComments;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getMdcontent() {
        return mdcontent;
    }

    public void setMdcontent(String mdcontent) {
        this.mdcontent = mdcontent == null ? null : mdcontent.trim();
    }

    public String getHtmlcontent() {
        return htmlcontent;
    }

    public void setHtmlcontent(String htmlcontent) {
        this.htmlcontent = htmlcontent == null ? null : htmlcontent.trim();
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary == null ? null : articleSummary.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Date edittime) {
        this.edittime = edittime;
    }

    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    public Integer getArticlePageviews() {
        return articlePageviews;
    }

    public void setArticlePageviews(Integer articlePageviews) {
        this.articlePageviews = articlePageviews;
    }

    public Integer getArticleLikes() {
        return articleLikes;
    }

    public void setArticleLikes(Integer articleLikes) {
        this.articleLikes = articleLikes;
    }

    public Integer getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(Integer articleComments) {
        this.articleComments = articleComments;
    }
}
