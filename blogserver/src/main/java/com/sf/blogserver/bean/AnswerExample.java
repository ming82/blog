package com.sf.blogserver.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnswerExample() {
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

        public Criteria andAnswerIdIsNull() {
            addCriterion("answer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("answer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(Integer value) {
            addCriterion("answer_id =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(Integer value) {
            addCriterion("answer_id <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(Integer value) {
            addCriterion("answer_id >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_id >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(Integer value) {
            addCriterion("answer_id <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(Integer value) {
            addCriterion("answer_id <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<Integer> values) {
            addCriterion("answer_id in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<Integer> values) {
            addCriterion("answer_id not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(Integer value1, Integer value2) {
            addCriterion("answer_id between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_id not between", value1, value2, "answerId");
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

        public Criteria andAnswerStateIsNull() {
            addCriterion("answer_state is null");
            return (Criteria) this;
        }

        public Criteria andAnswerStateIsNotNull() {
            addCriterion("answer_state is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerStateEqualTo(Integer value) {
            addCriterion("answer_state =", value, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerStateNotEqualTo(Integer value) {
            addCriterion("answer_state <>", value, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerStateGreaterThan(Integer value) {
            addCriterion("answer_state >", value, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_state >=", value, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerStateLessThan(Integer value) {
            addCriterion("answer_state <", value, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerStateLessThanOrEqualTo(Integer value) {
            addCriterion("answer_state <=", value, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerStateIn(List<Integer> values) {
            addCriterion("answer_state in", values, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerStateNotIn(List<Integer> values) {
            addCriterion("answer_state not in", values, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerStateBetween(Integer value1, Integer value2) {
            addCriterion("answer_state between", value1, value2, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerStateNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_state not between", value1, value2, "answerState");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesIsNull() {
            addCriterion("answer_likes is null");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesIsNotNull() {
            addCriterion("answer_likes is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesEqualTo(Integer value) {
            addCriterion("answer_likes =", value, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesNotEqualTo(Integer value) {
            addCriterion("answer_likes <>", value, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesGreaterThan(Integer value) {
            addCriterion("answer_likes >", value, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_likes >=", value, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesLessThan(Integer value) {
            addCriterion("answer_likes <", value, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesLessThanOrEqualTo(Integer value) {
            addCriterion("answer_likes <=", value, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesIn(List<Integer> values) {
            addCriterion("answer_likes in", values, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesNotIn(List<Integer> values) {
            addCriterion("answer_likes not in", values, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesBetween(Integer value1, Integer value2) {
            addCriterion("answer_likes between", value1, value2, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerLikesNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_likes not between", value1, value2, "answerLikes");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsIsNull() {
            addCriterion("answer_comments is null");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsIsNotNull() {
            addCriterion("answer_comments is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsEqualTo(Integer value) {
            addCriterion("answer_comments =", value, "answerComments");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsNotEqualTo(Integer value) {
            addCriterion("answer_comments <>", value, "answerComments");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsGreaterThan(Integer value) {
            addCriterion("answer_comments >", value, "answerComments");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_comments >=", value, "answerComments");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsLessThan(Integer value) {
            addCriterion("answer_comments <", value, "answerComments");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsLessThanOrEqualTo(Integer value) {
            addCriterion("answer_comments <=", value, "answerComments");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsIn(List<Integer> values) {
            addCriterion("answer_comments in", values, "answerComments");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsNotIn(List<Integer> values) {
            addCriterion("answer_comments not in", values, "answerComments");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsBetween(Integer value1, Integer value2) {
            addCriterion("answer_comments between", value1, value2, "answerComments");
            return (Criteria) this;
        }

        public Criteria andAnswerCommentsNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_comments not between", value1, value2, "answerComments");
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