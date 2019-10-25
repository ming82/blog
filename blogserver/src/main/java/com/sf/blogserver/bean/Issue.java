package com.sf.blogserver.bean;

import java.util.Date;

public class Issue {
    private Integer issueId;

    private String issueTitle;

    private String mdcontent;

    private String htmlcontent;

    private Integer categoryId;

    private Integer userId;

    private Date publishdate;

    private Integer issueState;

    private Integer issuePageview;

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle == null ? null : issueTitle.trim();
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

    public Integer getIssueState() {
        return issueState;
    }

    public void setIssueState(Integer issueState) {
        this.issueState = issueState;
    }

    public Integer getIssuePageview() {
        return issuePageview;
    }

    public void setIssuePageview(Integer issuePageview) {
        this.issuePageview = issuePageview;
    }
}