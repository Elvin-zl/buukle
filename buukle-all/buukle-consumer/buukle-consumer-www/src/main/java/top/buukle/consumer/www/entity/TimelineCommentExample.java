package top.buukle.consumer.www.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimelineCommentExample {
    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    protected String orderByClause;

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    protected boolean distinct;

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineCommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineCommentExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineCommentExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public static Criteria newAndCreateCriteria() {
        TimelineCommentExample example = new TimelineCommentExample();
        return example.createCriteria();
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andIdEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andIdNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andIdGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andIdGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andIdLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andIdLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidTypeIsNull() {
            addCriterion("pid_type is null");
            return (Criteria) this;
        }

        public Criteria andPidTypeIsNotNull() {
            addCriterion("pid_type is not null");
            return (Criteria) this;
        }

        public Criteria andPidTypeEqualTo(Integer value) {
            addCriterion("pid_type =", value, "pidType");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidTypeEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid_type = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidTypeNotEqualTo(Integer value) {
            addCriterion("pid_type <>", value, "pidType");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidTypeNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid_type <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidTypeGreaterThan(Integer value) {
            addCriterion("pid_type >", value, "pidType");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidTypeGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid_type > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid_type >=", value, "pidType");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidTypeGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid_type >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidTypeLessThan(Integer value) {
            addCriterion("pid_type <", value, "pidType");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidTypeLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid_type < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pid_type <=", value, "pidType");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andPidTypeLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("pid_type <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPidTypeIn(List<Integer> values) {
            addCriterion("pid_type in", values, "pidType");
            return (Criteria) this;
        }

        public Criteria andPidTypeNotIn(List<Integer> values) {
            addCriterion("pid_type not in", values, "pidType");
            return (Criteria) this;
        }

        public Criteria andPidTypeBetween(Integer value1, Integer value2) {
            addCriterion("pid_type between", value1, value2, "pidType");
            return (Criteria) this;
        }

        public Criteria andPidTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pid_type not between", value1, value2, "pidType");
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdIsNull() {
            addCriterion("timeline_info_id is null");
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdIsNotNull() {
            addCriterion("timeline_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdEqualTo(Integer value) {
            addCriterion("timeline_info_id =", value, "timelineInfoId");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andTimelineInfoIdEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("timeline_info_id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdNotEqualTo(Integer value) {
            addCriterion("timeline_info_id <>", value, "timelineInfoId");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andTimelineInfoIdNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("timeline_info_id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdGreaterThan(Integer value) {
            addCriterion("timeline_info_id >", value, "timelineInfoId");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andTimelineInfoIdGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("timeline_info_id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeline_info_id >=", value, "timelineInfoId");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andTimelineInfoIdGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("timeline_info_id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdLessThan(Integer value) {
            addCriterion("timeline_info_id <", value, "timelineInfoId");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andTimelineInfoIdLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("timeline_info_id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("timeline_info_id <=", value, "timelineInfoId");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andTimelineInfoIdLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("timeline_info_id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdIn(List<Integer> values) {
            addCriterion("timeline_info_id in", values, "timelineInfoId");
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdNotIn(List<Integer> values) {
            addCriterion("timeline_info_id not in", values, "timelineInfoId");
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("timeline_info_id between", value1, value2, "timelineInfoId");
            return (Criteria) this;
        }

        public Criteria andTimelineInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("timeline_info_id not between", value1, value2, "timelineInfoId");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCommentEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("comment = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCommentNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("comment <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCommentGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("comment > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCommentGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("comment >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCommentLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("comment < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCommentLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("comment <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeIsNull() {
            addCriterion("creator_code is null");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeIsNotNull() {
            addCriterion("creator_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeEqualTo(String value) {
            addCriterion("creator_code =", value, "creatorCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorCodeEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator_code = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotEqualTo(String value) {
            addCriterion("creator_code <>", value, "creatorCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorCodeNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator_code <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorCodeGreaterThan(String value) {
            addCriterion("creator_code >", value, "creatorCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorCodeGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator_code > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("creator_code >=", value, "creatorCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorCodeGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator_code >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLessThan(String value) {
            addCriterion("creator_code <", value, "creatorCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorCodeLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator_code < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLessThanOrEqualTo(String value) {
            addCriterion("creator_code <=", value, "creatorCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andCreatorCodeLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("creator_code <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLike(String value) {
            addCriterion("creator_code like", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotLike(String value) {
            addCriterion("creator_code not like", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeIn(List<String> values) {
            addCriterion("creator_code in", values, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotIn(List<String> values) {
            addCriterion("creator_code not in", values, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeBetween(String value1, String value2) {
            addCriterion("creator_code between", value1, value2, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeNotBetween(String value1, String value2) {
            addCriterion("creator_code not between", value1, value2, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtCreatedEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_created = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtCreatedNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_created <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtCreatedGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_created > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtCreatedGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_created >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtCreatedLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_created < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtCreatedLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_created <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("modifier =", value, "modifier");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("modifier <=", value, "modifier");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierCodeIsNull() {
            addCriterion("modifier_code is null");
            return (Criteria) this;
        }

        public Criteria andModifierCodeIsNotNull() {
            addCriterion("modifier_code is not null");
            return (Criteria) this;
        }

        public Criteria andModifierCodeEqualTo(String value) {
            addCriterion("modifier_code =", value, "modifierCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierCodeEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier_code = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierCodeNotEqualTo(String value) {
            addCriterion("modifier_code <>", value, "modifierCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierCodeNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier_code <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierCodeGreaterThan(String value) {
            addCriterion("modifier_code >", value, "modifierCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierCodeGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier_code > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("modifier_code >=", value, "modifierCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierCodeGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier_code >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierCodeLessThan(String value) {
            addCriterion("modifier_code <", value, "modifierCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierCodeLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier_code < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierCodeLessThanOrEqualTo(String value) {
            addCriterion("modifier_code <=", value, "modifierCode");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andModifierCodeLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("modifier_code <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andModifierCodeLike(String value) {
            addCriterion("modifier_code like", value, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andModifierCodeNotLike(String value) {
            addCriterion("modifier_code not like", value, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andModifierCodeIn(List<String> values) {
            addCriterion("modifier_code in", values, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andModifierCodeNotIn(List<String> values) {
            addCriterion("modifier_code not in", values, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andModifierCodeBetween(String value1, String value2) {
            addCriterion("modifier_code between", value1, value2, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andModifierCodeNotBetween(String value1, String value2) {
            addCriterion("modifier_code not between", value1, value2, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtModifiedEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_modified = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtModifiedNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_modified <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtModifiedGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_modified > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtModifiedGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_modified >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtModifiedLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_modified < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andGmtModifiedLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("gmt_modified <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andStatusEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("status = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andStatusNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("status <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andStatusGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("status > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andStatusGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("status >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andStatusLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("status < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andStatusLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("status <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andRemarkEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("remark = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andRemarkNotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("remark <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andRemarkGreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("remark > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andRemarkGreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("remark >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andRemarkLessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("remark < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andRemarkLessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("remark <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBak01IsNull() {
            addCriterion("bak01 is null");
            return (Criteria) this;
        }

        public Criteria andBak01IsNotNull() {
            addCriterion("bak01 is not null");
            return (Criteria) this;
        }

        public Criteria andBak01EqualTo(String value) {
            addCriterion("bak01 =", value, "bak01");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak01EqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak01 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak01NotEqualTo(String value) {
            addCriterion("bak01 <>", value, "bak01");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak01NotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak01 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak01GreaterThan(String value) {
            addCriterion("bak01 >", value, "bak01");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak01GreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak01 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak01GreaterThanOrEqualTo(String value) {
            addCriterion("bak01 >=", value, "bak01");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak01GreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak01 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak01LessThan(String value) {
            addCriterion("bak01 <", value, "bak01");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak01LessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak01 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak01LessThanOrEqualTo(String value) {
            addCriterion("bak01 <=", value, "bak01");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak01LessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak01 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak01Like(String value) {
            addCriterion("bak01 like", value, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak01NotLike(String value) {
            addCriterion("bak01 not like", value, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak01In(List<String> values) {
            addCriterion("bak01 in", values, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak01NotIn(List<String> values) {
            addCriterion("bak01 not in", values, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak01Between(String value1, String value2) {
            addCriterion("bak01 between", value1, value2, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak01NotBetween(String value1, String value2) {
            addCriterion("bak01 not between", value1, value2, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak02IsNull() {
            addCriterion("bak02 is null");
            return (Criteria) this;
        }

        public Criteria andBak02IsNotNull() {
            addCriterion("bak02 is not null");
            return (Criteria) this;
        }

        public Criteria andBak02EqualTo(String value) {
            addCriterion("bak02 =", value, "bak02");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak02EqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak02 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak02NotEqualTo(String value) {
            addCriterion("bak02 <>", value, "bak02");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak02NotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak02 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak02GreaterThan(String value) {
            addCriterion("bak02 >", value, "bak02");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak02GreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak02 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak02GreaterThanOrEqualTo(String value) {
            addCriterion("bak02 >=", value, "bak02");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak02GreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak02 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak02LessThan(String value) {
            addCriterion("bak02 <", value, "bak02");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak02LessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak02 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak02LessThanOrEqualTo(String value) {
            addCriterion("bak02 <=", value, "bak02");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak02LessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak02 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak02Like(String value) {
            addCriterion("bak02 like", value, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak02NotLike(String value) {
            addCriterion("bak02 not like", value, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak02In(List<String> values) {
            addCriterion("bak02 in", values, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak02NotIn(List<String> values) {
            addCriterion("bak02 not in", values, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak02Between(String value1, String value2) {
            addCriterion("bak02 between", value1, value2, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak02NotBetween(String value1, String value2) {
            addCriterion("bak02 not between", value1, value2, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak03IsNull() {
            addCriterion("bak03 is null");
            return (Criteria) this;
        }

        public Criteria andBak03IsNotNull() {
            addCriterion("bak03 is not null");
            return (Criteria) this;
        }

        public Criteria andBak03EqualTo(String value) {
            addCriterion("bak03 =", value, "bak03");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak03EqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak03 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak03NotEqualTo(String value) {
            addCriterion("bak03 <>", value, "bak03");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak03NotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak03 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak03GreaterThan(String value) {
            addCriterion("bak03 >", value, "bak03");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak03GreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak03 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak03GreaterThanOrEqualTo(String value) {
            addCriterion("bak03 >=", value, "bak03");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak03GreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak03 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak03LessThan(String value) {
            addCriterion("bak03 <", value, "bak03");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak03LessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak03 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak03LessThanOrEqualTo(String value) {
            addCriterion("bak03 <=", value, "bak03");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak03LessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak03 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak03Like(String value) {
            addCriterion("bak03 like", value, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak03NotLike(String value) {
            addCriterion("bak03 not like", value, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak03In(List<String> values) {
            addCriterion("bak03 in", values, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak03NotIn(List<String> values) {
            addCriterion("bak03 not in", values, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak03Between(String value1, String value2) {
            addCriterion("bak03 between", value1, value2, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak03NotBetween(String value1, String value2) {
            addCriterion("bak03 not between", value1, value2, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak04IsNull() {
            addCriterion("bak04 is null");
            return (Criteria) this;
        }

        public Criteria andBak04IsNotNull() {
            addCriterion("bak04 is not null");
            return (Criteria) this;
        }

        public Criteria andBak04EqualTo(String value) {
            addCriterion("bak04 =", value, "bak04");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak04EqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak04 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak04NotEqualTo(String value) {
            addCriterion("bak04 <>", value, "bak04");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak04NotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak04 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak04GreaterThan(String value) {
            addCriterion("bak04 >", value, "bak04");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak04GreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak04 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak04GreaterThanOrEqualTo(String value) {
            addCriterion("bak04 >=", value, "bak04");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak04GreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak04 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak04LessThan(String value) {
            addCriterion("bak04 <", value, "bak04");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak04LessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak04 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak04LessThanOrEqualTo(String value) {
            addCriterion("bak04 <=", value, "bak04");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak04LessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak04 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak04Like(String value) {
            addCriterion("bak04 like", value, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak04NotLike(String value) {
            addCriterion("bak04 not like", value, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak04In(List<String> values) {
            addCriterion("bak04 in", values, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak04NotIn(List<String> values) {
            addCriterion("bak04 not in", values, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak04Between(String value1, String value2) {
            addCriterion("bak04 between", value1, value2, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak04NotBetween(String value1, String value2) {
            addCriterion("bak04 not between", value1, value2, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak05IsNull() {
            addCriterion("bak05 is null");
            return (Criteria) this;
        }

        public Criteria andBak05IsNotNull() {
            addCriterion("bak05 is not null");
            return (Criteria) this;
        }

        public Criteria andBak05EqualTo(String value) {
            addCriterion("bak05 =", value, "bak05");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak05EqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak05 = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak05NotEqualTo(String value) {
            addCriterion("bak05 <>", value, "bak05");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak05NotEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak05 <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak05GreaterThan(String value) {
            addCriterion("bak05 >", value, "bak05");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak05GreaterThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak05 > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak05GreaterThanOrEqualTo(String value) {
            addCriterion("bak05 >=", value, "bak05");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak05GreaterThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak05 >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak05LessThan(String value) {
            addCriterion("bak05 <", value, "bak05");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak05LessThanColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak05 < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak05LessThanOrEqualTo(String value) {
            addCriterion("bak05 <=", value, "bak05");
            return (Criteria) this;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andBak05LessThanOrEqualToColumn(TimelineComment.Column column) {
            addCriterion(new StringBuilder("bak05 <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andBak05Like(String value) {
            addCriterion("bak05 like", value, "bak05");
            return (Criteria) this;
        }

        public Criteria andBak05NotLike(String value) {
            addCriterion("bak05 not like", value, "bak05");
            return (Criteria) this;
        }

        public Criteria andBak05In(List<String> values) {
            addCriterion("bak05 in", values, "bak05");
            return (Criteria) this;
        }

        public Criteria andBak05NotIn(List<String> values) {
            addCriterion("bak05 not in", values, "bak05");
            return (Criteria) this;
        }

        public Criteria andBak05Between(String value1, String value2) {
            addCriterion("bak05 between", value1, value2, "bak05");
            return (Criteria) this;
        }

        public Criteria andBak05NotBetween(String value1, String value2) {
            addCriterion("bak05 not between", value1, value2, "bak05");
            return (Criteria) this;
        }

        public Criteria andCommentLikeInsensitive(String value) {
            addCriterion("upper(comment) like", value.toUpperCase(), "comment");
            return (Criteria) this;
        }

        public Criteria andCreatorLikeInsensitive(String value) {
            addCriterion("upper(creator) like", value.toUpperCase(), "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLikeInsensitive(String value) {
            addCriterion("upper(creator_code) like", value.toUpperCase(), "creatorCode");
            return (Criteria) this;
        }

        public Criteria andModifierLikeInsensitive(String value) {
            addCriterion("upper(modifier) like", value.toUpperCase(), "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierCodeLikeInsensitive(String value) {
            addCriterion("upper(modifier_code) like", value.toUpperCase(), "modifierCode");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andBak01LikeInsensitive(String value) {
            addCriterion("upper(bak01) like", value.toUpperCase(), "bak01");
            return (Criteria) this;
        }

        public Criteria andBak02LikeInsensitive(String value) {
            addCriterion("upper(bak02) like", value.toUpperCase(), "bak02");
            return (Criteria) this;
        }

        public Criteria andBak03LikeInsensitive(String value) {
            addCriterion("upper(bak03) like", value.toUpperCase(), "bak03");
            return (Criteria) this;
        }

        public Criteria andBak04LikeInsensitive(String value) {
            addCriterion("upper(bak04) like", value.toUpperCase(), "bak04");
            return (Criteria) this;
        }

        public Criteria andBak05LikeInsensitive(String value) {
            addCriterion("upper(bak05) like", value.toUpperCase(), "bak05");
            return (Criteria) this;
        }
    }

    /**
     *
     * @mbg.generated do_not_delete_during_merge Thu Jul 04 20:18:20 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {
        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        private TimelineCommentExample example;

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        protected Criteria(TimelineCommentExample example) {
            super();
            this.example = example;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public TimelineCommentExample example() {
            return this.example;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public interface ICriteriaAdd {
            /**
             *
             * @mbg.generated Thu Jul 04 20:18:20 CST 2019
             */
            Criteria add(Criteria add);
        }
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
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