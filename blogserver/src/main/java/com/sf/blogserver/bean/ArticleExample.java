package com.sf.blogserver.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andMdcontentIsNull() {
            addCriterion("mdContent is null");
            return (Criteria) this;
        }

        public Criteria andMdcontentIsNotNull() {
            addCriterion("mdContent is not null");
            return (Criteria) this;
        }

        public Criteria andMdcontentEqualTo(String value) {
            addCriterion("mdContent =", value, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentNotEqualTo(String value) {
            addCriterion("mdContent <>", value, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentGreaterThan(String value) {
            addCriterion("mdContent >", value, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentGreaterThanOrEqualTo(String value) {
            addCriterion("mdContent >=", value, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentLessThan(String value) {
            addCriterion("mdContent <", value, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentLessThanOrEqualTo(String value) {
            addCriterion("mdContent <=", value, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentLike(String value) {
            addCriterion("mdContent like", value, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentNotLike(String value) {
            addCriterion("mdContent not like", value, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentIn(List<String> values) {
            addCriterion("mdContent in", values, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentNotIn(List<String> values) {
            addCriterion("mdContent not in", values, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentBetween(String value1, String value2) {
            addCriterion("mdContent between", value1, value2, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andMdcontentNotBetween(String value1, String value2) {
            addCriterion("mdContent not between", value1, value2, "mdcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentIsNull() {
            addCriterion("htmlContent is null");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentIsNotNull() {
            addCriterion("htmlContent is not null");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentEqualTo(String value) {
            addCriterion("htmlContent =", value, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentNotEqualTo(String value) {
            addCriterion("htmlContent <>", value, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentGreaterThan(String value) {
            addCriterion("htmlContent >", value, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentGreaterThanOrEqualTo(String value) {
            addCriterion("htmlContent >=", value, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentLessThan(String value) {
            addCriterion("htmlContent <", value, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentLessThanOrEqualTo(String value) {
            addCriterion("htmlContent <=", value, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentLike(String value) {
            addCriterion("htmlContent like", value, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentNotLike(String value) {
            addCriterion("htmlContent not like", value, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentIn(List<String> values) {
            addCriterion("htmlContent in", values, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentNotIn(List<String> values) {
            addCriterion("htmlContent not in", values, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentBetween(String value1, String value2) {
            addCriterion("htmlContent between", value1, value2, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andHtmlcontentNotBetween(String value1, String value2) {
            addCriterion("htmlContent not between", value1, value2, "htmlcontent");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryIsNull() {
            addCriterion("article_summary is null");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryIsNotNull() {
            addCriterion("article_summary is not null");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryEqualTo(String value) {
            addCriterion("article_summary =", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryNotEqualTo(String value) {
            addCriterion("article_summary <>", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryGreaterThan(String value) {
            addCriterion("article_summary >", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("article_summary >=", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryLessThan(String value) {
            addCriterion("article_summary <", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryLessThanOrEqualTo(String value) {
            addCriterion("article_summary <=", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryLike(String value) {
            addCriterion("article_summary like", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryNotLike(String value) {
            addCriterion("article_summary not like", value, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryIn(List<String> values) {
            addCriterion("article_summary in", values, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryNotIn(List<String> values) {
            addCriterion("article_summary not in", values, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryBetween(String value1, String value2) {
            addCriterion("article_summary between", value1, value2, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andArticleSummaryNotBetween(String value1, String value2) {
            addCriterion("article_summary not between", value1, value2, "articleSummary");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPublishdateIsNull() {
            addCriterion("publishDate is null");
            return (Criteria) this;
        }

        public Criteria andPublishdateIsNotNull() {
            addCriterion("publishDate is not null");
            return (Criteria) this;
        }

        public Criteria andPublishdateEqualTo(Date value) {
            addCriterion("publishDate =", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateNotEqualTo(Date value) {
            addCriterion("publishDate <>", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateGreaterThan(Date value) {
            addCriterion("publishDate >", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateGreaterThanOrEqualTo(Date value) {
            addCriterion("publishDate >=", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateLessThan(Date value) {
            addCriterion("publishDate <", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateLessThanOrEqualTo(Date value) {
            addCriterion("publishDate <=", value, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateIn(List<Date> values) {
            addCriterion("publishDate in", values, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateNotIn(List<Date> values) {
            addCriterion("publishDate not in", values, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateBetween(Date value1, Date value2) {
            addCriterion("publishDate between", value1, value2, "publishdate");
            return (Criteria) this;
        }

        public Criteria andPublishdateNotBetween(Date value1, Date value2) {
            addCriterion("publishDate not between", value1, value2, "publishdate");
            return (Criteria) this;
        }

        public Criteria andEdittimeIsNull() {
            addCriterion("editTime is null");
            return (Criteria) this;
        }

        public Criteria andEdittimeIsNotNull() {
            addCriterion("editTime is not null");
            return (Criteria) this;
        }

        public Criteria andEdittimeEqualTo(Date value) {
            addCriterion("editTime =", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeNotEqualTo(Date value) {
            addCriterion("editTime <>", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeGreaterThan(Date value) {
            addCriterion("editTime >", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("editTime >=", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeLessThan(Date value) {
            addCriterion("editTime <", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeLessThanOrEqualTo(Date value) {
            addCriterion("editTime <=", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeIn(List<Date> values) {
            addCriterion("editTime in", values, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeNotIn(List<Date> values) {
            addCriterion("editTime not in", values, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeBetween(Date value1, Date value2) {
            addCriterion("editTime between", value1, value2, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeNotBetween(Date value1, Date value2) {
            addCriterion("editTime not between", value1, value2, "edittime");
            return (Criteria) this;
        }

        public Criteria andArticleStateIsNull() {
            addCriterion("article_state is null");
            return (Criteria) this;
        }

        public Criteria andArticleStateIsNotNull() {
            addCriterion("article_state is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStateEqualTo(Integer value) {
            addCriterion("article_state =", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotEqualTo(Integer value) {
            addCriterion("article_state <>", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateGreaterThan(Integer value) {
            addCriterion("article_state >", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_state >=", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateLessThan(Integer value) {
            addCriterion("article_state <", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateLessThanOrEqualTo(Integer value) {
            addCriterion("article_state <=", value, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateIn(List<Integer> values) {
            addCriterion("article_state in", values, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotIn(List<Integer> values) {
            addCriterion("article_state not in", values, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateBetween(Integer value1, Integer value2) {
            addCriterion("article_state between", value1, value2, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticleStateNotBetween(Integer value1, Integer value2) {
            addCriterion("article_state not between", value1, value2, "articleState");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsIsNull() {
            addCriterion("article_pageviews is null");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsIsNotNull() {
            addCriterion("article_pageviews is not null");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsEqualTo(Integer value) {
            addCriterion("article_pageviews =", value, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsNotEqualTo(Integer value) {
            addCriterion("article_pageviews <>", value, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsGreaterThan(Integer value) {
            addCriterion("article_pageviews >", value, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_pageviews >=", value, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsLessThan(Integer value) {
            addCriterion("article_pageviews <", value, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsLessThanOrEqualTo(Integer value) {
            addCriterion("article_pageviews <=", value, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsIn(List<Integer> values) {
            addCriterion("article_pageviews in", values, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsNotIn(List<Integer> values) {
            addCriterion("article_pageviews not in", values, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsBetween(Integer value1, Integer value2) {
            addCriterion("article_pageviews between", value1, value2, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticlePageviewsNotBetween(Integer value1, Integer value2) {
            addCriterion("article_pageviews not between", value1, value2, "articlePageviews");
            return (Criteria) this;
        }

        public Criteria andArticleLikesIsNull() {
            addCriterion("article_likes is null");
            return (Criteria) this;
        }

        public Criteria andArticleLikesIsNotNull() {
            addCriterion("article_likes is not null");
            return (Criteria) this;
        }

        public Criteria andArticleLikesEqualTo(Integer value) {
            addCriterion("article_likes =", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesNotEqualTo(Integer value) {
            addCriterion("article_likes <>", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesGreaterThan(Integer value) {
            addCriterion("article_likes >", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_likes >=", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesLessThan(Integer value) {
            addCriterion("article_likes <", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesLessThanOrEqualTo(Integer value) {
            addCriterion("article_likes <=", value, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesIn(List<Integer> values) {
            addCriterion("article_likes in", values, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesNotIn(List<Integer> values) {
            addCriterion("article_likes not in", values, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesBetween(Integer value1, Integer value2) {
            addCriterion("article_likes between", value1, value2, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleLikesNotBetween(Integer value1, Integer value2) {
            addCriterion("article_likes not between", value1, value2, "articleLikes");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsIsNull() {
            addCriterion("article_comments is null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsIsNotNull() {
            addCriterion("article_comments is not null");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsEqualTo(Integer value) {
            addCriterion("article_comments =", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsNotEqualTo(Integer value) {
            addCriterion("article_comments <>", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsGreaterThan(Integer value) {
            addCriterion("article_comments >", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_comments >=", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsLessThan(Integer value) {
            addCriterion("article_comments <", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsLessThanOrEqualTo(Integer value) {
            addCriterion("article_comments <=", value, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsIn(List<Integer> values) {
            addCriterion("article_comments in", values, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsNotIn(List<Integer> values) {
            addCriterion("article_comments not in", values, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsBetween(Integer value1, Integer value2) {
            addCriterion("article_comments between", value1, value2, "articleComments");
            return (Criteria) this;
        }

        public Criteria andArticleCommentsNotBetween(Integer value1, Integer value2) {
            addCriterion("article_comments not between", value1, value2, "articleComments");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}