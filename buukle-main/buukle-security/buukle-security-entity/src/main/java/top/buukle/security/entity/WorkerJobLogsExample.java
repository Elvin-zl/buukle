package top.buukle.security.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkerJobLogsExample {
    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    protected String orderByClause;

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    protected boolean distinct;

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public WorkerJobLogsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public WorkerJobLogsExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public WorkerJobLogsExample orderBy(String ... orderByClauses) {
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
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
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
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
     */
    public static Criteria newAndCreateCriteria() {
        WorkerJobLogsExample example = new WorkerJobLogsExample();
        return example.createCriteria();
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
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

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameIsNull() {
            addCriterion("bean_reference_name is null");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameIsNotNull() {
            addCriterion("bean_reference_name is not null");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameEqualTo(String value) {
            addCriterion("bean_reference_name =", value, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameNotEqualTo(String value) {
            addCriterion("bean_reference_name <>", value, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameGreaterThan(String value) {
            addCriterion("bean_reference_name >", value, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameGreaterThanOrEqualTo(String value) {
            addCriterion("bean_reference_name >=", value, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameLessThan(String value) {
            addCriterion("bean_reference_name <", value, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameLessThanOrEqualTo(String value) {
            addCriterion("bean_reference_name <=", value, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameLike(String value) {
            addCriterion("bean_reference_name like", value, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameNotLike(String value) {
            addCriterion("bean_reference_name not like", value, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameIn(List<String> values) {
            addCriterion("bean_reference_name in", values, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameNotIn(List<String> values) {
            addCriterion("bean_reference_name not in", values, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameBetween(String value1, String value2) {
            addCriterion("bean_reference_name between", value1, value2, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameNotBetween(String value1, String value2) {
            addCriterion("bean_reference_name not between", value1, value2, "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("params is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("params is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("params =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("params <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("params >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("params >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("params <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("params <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("params like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("params not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("params in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("params not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("params between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("params not between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNull() {
            addCriterion("cron_expression is null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIsNotNull() {
            addCriterion("cron_expression is not null");
            return (Criteria) this;
        }

        public Criteria andCronExpressionEqualTo(String value) {
            addCriterion("cron_expression =", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotEqualTo(String value) {
            addCriterion("cron_expression <>", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThan(String value) {
            addCriterion("cron_expression >", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionGreaterThanOrEqualTo(String value) {
            addCriterion("cron_expression >=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThan(String value) {
            addCriterion("cron_expression <", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLessThanOrEqualTo(String value) {
            addCriterion("cron_expression <=", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLike(String value) {
            addCriterion("cron_expression like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotLike(String value) {
            addCriterion("cron_expression not like", value, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionIn(List<String> values) {
            addCriterion("cron_expression in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotIn(List<String> values) {
            addCriterion("cron_expression not in", values, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionBetween(String value1, String value2) {
            addCriterion("cron_expression between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andCronExpressionNotBetween(String value1, String value2) {
            addCriterion("cron_expression not between", value1, value2, "cronExpression");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNull() {
            addCriterion("lock_status is null");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNotNull() {
            addCriterion("lock_status is not null");
            return (Criteria) this;
        }

        public Criteria andLockStatusEqualTo(Byte value) {
            addCriterion("lock_status =", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotEqualTo(Byte value) {
            addCriterion("lock_status <>", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThan(Byte value) {
            addCriterion("lock_status >", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("lock_status >=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThan(Byte value) {
            addCriterion("lock_status <", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThanOrEqualTo(Byte value) {
            addCriterion("lock_status <=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusIn(List<Byte> values) {
            addCriterion("lock_status in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotIn(List<Byte> values) {
            addCriterion("lock_status not in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusBetween(Byte value1, Byte value2) {
            addCriterion("lock_status between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("lock_status not between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andResultMsgIsNull() {
            addCriterion("result_msg is null");
            return (Criteria) this;
        }

        public Criteria andResultMsgIsNotNull() {
            addCriterion("result_msg is not null");
            return (Criteria) this;
        }

        public Criteria andResultMsgEqualTo(String value) {
            addCriterion("result_msg =", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgNotEqualTo(String value) {
            addCriterion("result_msg <>", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgGreaterThan(String value) {
            addCriterion("result_msg >", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgGreaterThanOrEqualTo(String value) {
            addCriterion("result_msg >=", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgLessThan(String value) {
            addCriterion("result_msg <", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgLessThanOrEqualTo(String value) {
            addCriterion("result_msg <=", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgLike(String value) {
            addCriterion("result_msg like", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgNotLike(String value) {
            addCriterion("result_msg not like", value, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgIn(List<String> values) {
            addCriterion("result_msg in", values, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgNotIn(List<String> values) {
            addCriterion("result_msg not in", values, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgBetween(String value1, String value2) {
            addCriterion("result_msg between", value1, value2, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andResultMsgNotBetween(String value1, String value2) {
            addCriterion("result_msg not between", value1, value2, "resultMsg");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeIsNull() {
            addCriterion("execute_type is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeIsNotNull() {
            addCriterion("execute_type is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeEqualTo(Byte value) {
            addCriterion("execute_type =", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeNotEqualTo(Byte value) {
            addCriterion("execute_type <>", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeGreaterThan(Byte value) {
            addCriterion("execute_type >", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("execute_type >=", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeLessThan(Byte value) {
            addCriterion("execute_type <", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeLessThanOrEqualTo(Byte value) {
            addCriterion("execute_type <=", value, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeIn(List<Byte> values) {
            addCriterion("execute_type in", values, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeNotIn(List<Byte> values) {
            addCriterion("execute_type not in", values, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeBetween(Byte value1, Byte value2) {
            addCriterion("execute_type between", value1, value2, "executeType");
            return (Criteria) this;
        }

        public Criteria andExecuteTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("execute_type not between", value1, value2, "executeType");
            return (Criteria) this;
        }

        public Criteria andIpGroupIsNull() {
            addCriterion("ip_group is null");
            return (Criteria) this;
        }

        public Criteria andIpGroupIsNotNull() {
            addCriterion("ip_group is not null");
            return (Criteria) this;
        }

        public Criteria andIpGroupEqualTo(String value) {
            addCriterion("ip_group =", value, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupNotEqualTo(String value) {
            addCriterion("ip_group <>", value, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupGreaterThan(String value) {
            addCriterion("ip_group >", value, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupGreaterThanOrEqualTo(String value) {
            addCriterion("ip_group >=", value, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupLessThan(String value) {
            addCriterion("ip_group <", value, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupLessThanOrEqualTo(String value) {
            addCriterion("ip_group <=", value, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupLike(String value) {
            addCriterion("ip_group like", value, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupNotLike(String value) {
            addCriterion("ip_group not like", value, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupIn(List<String> values) {
            addCriterion("ip_group in", values, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupNotIn(List<String> values) {
            addCriterion("ip_group not in", values, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupBetween(String value1, String value2) {
            addCriterion("ip_group between", value1, value2, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andIpGroupNotBetween(String value1, String value2) {
            addCriterion("ip_group not between", value1, value2, "ipGroup");
            return (Criteria) this;
        }

        public Criteria andTimeOutIsNull() {
            addCriterion("time_out is null");
            return (Criteria) this;
        }

        public Criteria andTimeOutIsNotNull() {
            addCriterion("time_out is not null");
            return (Criteria) this;
        }

        public Criteria andTimeOutEqualTo(Integer value) {
            addCriterion("time_out =", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotEqualTo(Integer value) {
            addCriterion("time_out <>", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutGreaterThan(Integer value) {
            addCriterion("time_out >", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_out >=", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutLessThan(Integer value) {
            addCriterion("time_out <", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutLessThanOrEqualTo(Integer value) {
            addCriterion("time_out <=", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutIn(List<Integer> values) {
            addCriterion("time_out in", values, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotIn(List<Integer> values) {
            addCriterion("time_out not in", values, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutBetween(Integer value1, Integer value2) {
            addCriterion("time_out between", value1, value2, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotBetween(Integer value1, Integer value2) {
            addCriterion("time_out not between", value1, value2, "timeOut");
            return (Criteria) this;
        }

        public Criteria andFailStrategyIsNull() {
            addCriterion("fail_strategy is null");
            return (Criteria) this;
        }

        public Criteria andFailStrategyIsNotNull() {
            addCriterion("fail_strategy is not null");
            return (Criteria) this;
        }

        public Criteria andFailStrategyEqualTo(String value) {
            addCriterion("fail_strategy =", value, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyNotEqualTo(String value) {
            addCriterion("fail_strategy <>", value, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyGreaterThan(String value) {
            addCriterion("fail_strategy >", value, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyGreaterThanOrEqualTo(String value) {
            addCriterion("fail_strategy >=", value, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyLessThan(String value) {
            addCriterion("fail_strategy <", value, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyLessThanOrEqualTo(String value) {
            addCriterion("fail_strategy <=", value, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyLike(String value) {
            addCriterion("fail_strategy like", value, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyNotLike(String value) {
            addCriterion("fail_strategy not like", value, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyIn(List<String> values) {
            addCriterion("fail_strategy in", values, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyNotIn(List<String> values) {
            addCriterion("fail_strategy not in", values, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyBetween(String value1, String value2) {
            addCriterion("fail_strategy between", value1, value2, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andFailStrategyNotBetween(String value1, String value2) {
            addCriterion("fail_strategy not between", value1, value2, "failStrategy");
            return (Criteria) this;
        }

        public Criteria andRetryCountIsNull() {
            addCriterion("retry_count is null");
            return (Criteria) this;
        }

        public Criteria andRetryCountIsNotNull() {
            addCriterion("retry_count is not null");
            return (Criteria) this;
        }

        public Criteria andRetryCountEqualTo(Integer value) {
            addCriterion("retry_count =", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotEqualTo(Integer value) {
            addCriterion("retry_count <>", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountGreaterThan(Integer value) {
            addCriterion("retry_count >", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("retry_count >=", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountLessThan(Integer value) {
            addCriterion("retry_count <", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountLessThanOrEqualTo(Integer value) {
            addCriterion("retry_count <=", value, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountIn(List<Integer> values) {
            addCriterion("retry_count in", values, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotIn(List<Integer> values) {
            addCriterion("retry_count not in", values, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountBetween(Integer value1, Integer value2) {
            addCriterion("retry_count between", value1, value2, "retryCount");
            return (Criteria) this;
        }

        public Criteria andRetryCountNotBetween(Integer value1, Integer value2) {
            addCriterion("retry_count not between", value1, value2, "retryCount");
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

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
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

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
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

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
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

        public Criteria andCreatorRoleIdIsNull() {
            addCriterion("creator_role_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdIsNotNull() {
            addCriterion("creator_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdEqualTo(Integer value) {
            addCriterion("creator_role_id =", value, "creatorRoleId");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdNotEqualTo(Integer value) {
            addCriterion("creator_role_id <>", value, "creatorRoleId");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdGreaterThan(Integer value) {
            addCriterion("creator_role_id >", value, "creatorRoleId");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator_role_id >=", value, "creatorRoleId");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdLessThan(Integer value) {
            addCriterion("creator_role_id <", value, "creatorRoleId");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("creator_role_id <=", value, "creatorRoleId");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdIn(List<Integer> values) {
            addCriterion("creator_role_id in", values, "creatorRoleId");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdNotIn(List<Integer> values) {
            addCriterion("creator_role_id not in", values, "creatorRoleId");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("creator_role_id between", value1, value2, "creatorRoleId");
            return (Criteria) this;
        }

        public Criteria andCreatorRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("creator_role_id not between", value1, value2, "creatorRoleId");
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

        public Criteria andCreatorCodeNotEqualTo(String value) {
            addCriterion("creator_code <>", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeGreaterThan(String value) {
            addCriterion("creator_code >", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("creator_code >=", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLessThan(String value) {
            addCriterion("creator_code <", value, "creatorCode");
            return (Criteria) this;
        }

        public Criteria andCreatorCodeLessThanOrEqualTo(String value) {
            addCriterion("creator_code <=", value, "creatorCode");
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

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
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

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("modifier <=", value, "modifier");
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

        public Criteria andModifierCodeNotEqualTo(String value) {
            addCriterion("modifier_code <>", value, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andModifierCodeGreaterThan(String value) {
            addCriterion("modifier_code >", value, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andModifierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("modifier_code >=", value, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andModifierCodeLessThan(String value) {
            addCriterion("modifier_code <", value, "modifierCode");
            return (Criteria) this;
        }

        public Criteria andModifierCodeLessThanOrEqualTo(String value) {
            addCriterion("modifier_code <=", value, "modifierCode");
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

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
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

        public Criteria andBak01NotEqualTo(String value) {
            addCriterion("bak01 <>", value, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak01GreaterThan(String value) {
            addCriterion("bak01 >", value, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak01GreaterThanOrEqualTo(String value) {
            addCriterion("bak01 >=", value, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak01LessThan(String value) {
            addCriterion("bak01 <", value, "bak01");
            return (Criteria) this;
        }

        public Criteria andBak01LessThanOrEqualTo(String value) {
            addCriterion("bak01 <=", value, "bak01");
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

        public Criteria andBak02NotEqualTo(String value) {
            addCriterion("bak02 <>", value, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak02GreaterThan(String value) {
            addCriterion("bak02 >", value, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak02GreaterThanOrEqualTo(String value) {
            addCriterion("bak02 >=", value, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak02LessThan(String value) {
            addCriterion("bak02 <", value, "bak02");
            return (Criteria) this;
        }

        public Criteria andBak02LessThanOrEqualTo(String value) {
            addCriterion("bak02 <=", value, "bak02");
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

        public Criteria andBak03NotEqualTo(String value) {
            addCriterion("bak03 <>", value, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak03GreaterThan(String value) {
            addCriterion("bak03 >", value, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak03GreaterThanOrEqualTo(String value) {
            addCriterion("bak03 >=", value, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak03LessThan(String value) {
            addCriterion("bak03 <", value, "bak03");
            return (Criteria) this;
        }

        public Criteria andBak03LessThanOrEqualTo(String value) {
            addCriterion("bak03 <=", value, "bak03");
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

        public Criteria andBak04NotEqualTo(String value) {
            addCriterion("bak04 <>", value, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak04GreaterThan(String value) {
            addCriterion("bak04 >", value, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak04GreaterThanOrEqualTo(String value) {
            addCriterion("bak04 >=", value, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak04LessThan(String value) {
            addCriterion("bak04 <", value, "bak04");
            return (Criteria) this;
        }

        public Criteria andBak04LessThanOrEqualTo(String value) {
            addCriterion("bak04 <=", value, "bak04");
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

        public Criteria andBak05NotEqualTo(String value) {
            addCriterion("bak05 <>", value, "bak05");
            return (Criteria) this;
        }

        public Criteria andBak05GreaterThan(String value) {
            addCriterion("bak05 >", value, "bak05");
            return (Criteria) this;
        }

        public Criteria andBak05GreaterThanOrEqualTo(String value) {
            addCriterion("bak05 >=", value, "bak05");
            return (Criteria) this;
        }

        public Criteria andBak05LessThan(String value) {
            addCriterion("bak05 <", value, "bak05");
            return (Criteria) this;
        }

        public Criteria andBak05LessThanOrEqualTo(String value) {
            addCriterion("bak05 <=", value, "bak05");
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

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andBeanReferenceNameLikeInsensitive(String value) {
            addCriterion("upper(bean_reference_name) like", value.toUpperCase(), "beanReferenceName");
            return (Criteria) this;
        }

        public Criteria andMethodLikeInsensitive(String value) {
            addCriterion("upper(method) like", value.toUpperCase(), "method");
            return (Criteria) this;
        }

        public Criteria andParamsLikeInsensitive(String value) {
            addCriterion("upper(params) like", value.toUpperCase(), "params");
            return (Criteria) this;
        }

        public Criteria andCronExpressionLikeInsensitive(String value) {
            addCriterion("upper(cron_expression) like", value.toUpperCase(), "cronExpression");
            return (Criteria) this;
        }

        public Criteria andResultMsgLikeInsensitive(String value) {
            addCriterion("upper(result_msg) like", value.toUpperCase(), "resultMsg");
            return (Criteria) this;
        }

        public Criteria andIpGroupLikeInsensitive(String value) {
            addCriterion("upper(ip_group) like", value.toUpperCase(), "ipGroup");
            return (Criteria) this;
        }

        public Criteria andFailStrategyLikeInsensitive(String value) {
            addCriterion("upper(fail_strategy) like", value.toUpperCase(), "failStrategy");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
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
     * @mbg.generated do_not_delete_during_merge Tue Aug 27 01:14:43 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {
        /**
         *
         * @mbg.generated Tue Aug 27 01:14:43 CST 2019
         */
        private WorkerJobLogsExample example;

        /**
         *
         * @mbg.generated Tue Aug 27 01:14:43 CST 2019
         */
        protected Criteria(WorkerJobLogsExample example) {
            super();
            this.example = example;
        }

        /**
         *
         * @mbg.generated Tue Aug 27 01:14:43 CST 2019
         */
        public WorkerJobLogsExample example() {
            return this.example;
        }

        /**
         *
         * @mbg.generated Tue Aug 27 01:14:43 CST 2019
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
             * @mbg.generated Tue Aug 27 01:14:43 CST 2019
             */
            Criteria add(Criteria add);
        }
    }

    /**
     *
     * @mbg.generated Tue Aug 27 01:14:43 CST 2019
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