package com.sf.blogserver.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IssueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IssueExample() {
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

        public Criteria andIssueIdIsNull() {
            addCriterion("issue_id is null");
            return (Criteria) this;
        }

        public Criteria andIssueIdIsNotNull() {
            addCriterion("issue_id is not null");
            return (Criteria) this;
        }

        public Criteria andIssueIdEqualTo(Integer value) {
            addCriterion("issue_id =", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotEqualTo(Integer value) {
            addCriterion("issue_id <>", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdGreaterThan(Integer value) {
            addCriterion("issue_id >", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_id >=", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdLessThan(Integer value) {
            addCriterion("issue_id <", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdLessThanOrEqualTo(Integer value) {
            addCriterion("issue_id <=", value, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdIn(List<Integer> values) {
            addCriterion("issue_id in", values, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotIn(List<Integer> values) {
            addCriterion("issue_id not in", values, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdBetween(Integer value1, Integer value2) {
            addCriterion("issue_id between", value1, value2, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_id not between", value1, value2, "issueId");
            return (Criteria) this;
        }

        public Criteria andIssueTitleIsNull() {
            addCriterion("issue_title is null");
            return (Criteria) this;
        }

        public Criteria andIssueTitleIsNotNull() {
            addCriterion("issue_title is not null");
            return (Criteria) this;
        }

        public Criteria andIssueTitleEqualTo(String value) {
            addCriterion("issue_title =", value, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleNotEqualTo(String value) {
            addCriterion("issue_title <>", value, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleGreaterThan(String value) {
            addCriterion("issue_title >", value, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleGreaterThanOrEqualTo(String value) {
            addCriterion("issue_title >=", value, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleLessThan(String value) {
            addCriterion("issue_title <", value, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleLessThanOrEqualTo(String value) {
            addCriterion("issue_title <=", value, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleLike(String value) {
            addCriterion("issue_title like", value, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleNotLike(String value) {
            addCriterion("issue_title not like", value, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleIn(List<String> values) {
            addCriterion("issue_title in", values, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleNotIn(List<String> values) {
            addCriterion("issue_title not in", values, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleBetween(String value1, String value2) {
            addCriterion("issue_title between", value1, value2, "issueTitle");
            return (Criteria) this;
        }

        public Criteria andIssueTitleNotBetween(String value1, String value2) {
            addCriterion("issue_title not between", value1, value2, "issueTitle");
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

        public Criteria andIssueStateIsNull() {
            addCriterion("issue_state is null");
            return (Criteria) this;
        }

        public Criteria andIssueStateIsNotNull() {
            addCriterion("issue_state is not null");
            return (Criteria) this;
        }

        public Criteria andIssueStateEqualTo(Integer value) {
            addCriterion("issue_state =", value, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssueStateNotEqualTo(Integer value) {
            addCriterion("issue_state <>", value, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssueStateGreaterThan(Integer value) {
            addCriterion("issue_state >", value, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssueStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_state >=", value, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssueStateLessThan(Integer value) {
            addCriterion("issue_state <", value, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssueStateLessThanOrEqualTo(Integer value) {
            addCriterion("issue_state <=", value, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssueStateIn(List<Integer> values) {
            addCriterion("issue_state in", values, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssueStateNotIn(List<Integer> values) {
            addCriterion("issue_state not in", values, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssueStateBetween(Integer value1, Integer value2) {
            addCriterion("issue_state between", value1, value2, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssueStateNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_state not between", value1, value2, "issueState");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewIsNull() {
            addCriterion("issue_pageview is null");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewIsNotNull() {
            addCriterion("issue_pageview is not null");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewEqualTo(Integer value) {
            addCriterion("issue_pageview =", value, "issuePageview");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewNotEqualTo(Integer value) {
            addCriterion("issue_pageview <>", value, "issuePageview");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewGreaterThan(Integer value) {
            addCriterion("issue_pageview >", value, "issuePageview");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewGreaterThanOrEqualTo(Integer value) {
            addCriterion("issue_pageview >=", value, "issuePageview");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewLessThan(Integer value) {
            addCriterion("issue_pageview <", value, "issuePageview");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewLessThanOrEqualTo(Integer value) {
            addCriterion("issue_pageview <=", value, "issuePageview");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewIn(List<Integer> values) {
            addCriterion("issue_pageview in", values, "issuePageview");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewNotIn(List<Integer> values) {
            addCriterion("issue_pageview not in", values, "issuePageview");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewBetween(Integer value1, Integer value2) {
            addCriterion("issue_pageview between", value1, value2, "issuePageview");
            return (Criteria) this;
        }

        public Criteria andIssuePageviewNotBetween(Integer value1, Integer value2) {
            addCriterion("issue_pageview not between", value1, value2, "issuePageview");
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