package com.sf.blogserver.bean;

import java.util.Date;

public class Answer {
    private Integer answerId;

    private String mdcontent;

    private String htmlcontent;

    private Integer issueId;

    private Integer userId;

    private Date publishdate;

    private Integer answerStatus;

    private Integer answerLikes;

    private Integer answerComments;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
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

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
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

    public Integer getAnswerStatus() {
        return answerStatus;
    }

    public void setAnswerStatus(Integer answerStatus) {
        this.answerStatus = answerStatus;
    }

    public Integer getAnswerLikes() {
        return answerLikes;
    }

    public void setAnswerLikes(Integer answerLikes) {
        this.answerLikes = answerLikes;
    }

    public Integer getAnswerComments() {
        return answerComments;
    }

    public void setAnswerComments(Integer answerComments) {
        this.answerComments = answerComments;
    }
}