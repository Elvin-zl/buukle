package top.buukle.security.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleExample {
    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    protected String orderByClause;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    protected boolean distinct;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public RoleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public RoleExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public RoleExample orderBy(String ... orderByClauses) {
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
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
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
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
     */
    public static Criteria newAndCreateCriteria() {
        RoleExample example = new RoleExample();
        return example.createCriteria();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
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

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
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

        public Criteria andSystemFlagIsNull() {
            addCriterion("system_flag is null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIsNotNull() {
            addCriterion("system_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagEqualTo(Integer value) {
            addCriterion("system_flag =", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotEqualTo(Integer value) {
            addCriterion("system_flag <>", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThan(Integer value) {
            addCriterion("system_flag >", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("system_flag >=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThan(Integer value) {
            addCriterion("system_flag <", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThanOrEqualTo(Integer value) {
            addCriterion("system_flag <=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIn(List<Integer> values) {
            addCriterion("system_flag in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotIn(List<Integer> values) {
            addCriterion("system_flag not in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagBetween(Integer value1, Integer value2) {
            addCriterion("system_flag between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("system_flag not between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(Integer value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(Integer value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(Integer value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(Integer value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(Integer value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<Integer> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<Integer> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(Integer value1, Integer value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIsNull() {
            addCriterion("application_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIsNotNull() {
            addCriterion("application_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationNameEqualTo(String value) {
            addCriterion("application_name =", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotEqualTo(String value) {
            addCriterion("application_name <>", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameGreaterThan(String value) {
            addCriterion("application_name >", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameGreaterThanOrEqualTo(String value) {
            addCriterion("application_name >=", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLessThan(String value) {
            addCriterion("application_name <", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLessThanOrEqualTo(String value) {
            addCriterion("application_name <=", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLike(String value) {
            addCriterion("application_name like", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotLike(String value) {
            addCriterion("application_name not like", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIn(List<String> values) {
            addCriterion("application_name in", values, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotIn(List<String> values) {
            addCriterion("application_name not in", values, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameBetween(String value1, String value2) {
            addCriterion("application_name between", value1, value2, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotBetween(String value1, String value2) {
            addCriterion("application_name not between", value1, value2, "applicationName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
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

        public Criteria andApplicationNameLikeInsensitive(String value) {
            addCriterion("upper(application_name) like", value.toUpperCase(), "applicationName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLikeInsensitive(String value) {
            addCriterion("upper(role_name) like", value.toUpperCase(), "roleName");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
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
     * @mbg.generated do_not_delete_during_merge Sun Aug 18 22:53:10 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {
        /**
         *
         * @mbg.generated Sun Aug 18 22:53:10 CST 2019
         */
        private RoleExample example;

        /**
         *
         * @mbg.generated Sun Aug 18 22:53:10 CST 2019
         */
        protected Criteria(RoleExample example) {
            super();
            this.example = example;
        }

        /**
         *
         * @mbg.generated Sun Aug 18 22:53:10 CST 2019
         */
        public RoleExample example() {
            return this.example;
        }

        /**
         *
         * @mbg.generated Sun Aug 18 22:53:10 CST 2019
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
             * @mbg.generated Sun Aug 18 22:53:10 CST 2019
             */
            Criteria add(Criteria add);
        }
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:10 CST 2019
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