package top.buukle.consumer.www.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FriendLinkExample {
    /**
     */
    protected String orderByClause;

    /**
     */
    protected boolean distinct;

    /**
     */
    protected List<Criteria> oredCriteria;

    /**
     */
    public FriendLinkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     */
    public FriendLinkExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     */
    public FriendLinkExample orderBy(String ... orderByClauses) {
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
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     */
    public static Criteria newAndCreateCriteria() {
        FriendLinkExample example = new FriendLinkExample();
        return example.createCriteria();
    }

    /**
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

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andLinkDescIsNull() {
            addCriterion("link_desc is null");
            return (Criteria) this;
        }

        public Criteria andLinkDescIsNotNull() {
            addCriterion("link_desc is not null");
            return (Criteria) this;
        }

        public Criteria andLinkDescEqualTo(String value) {
            addCriterion("link_desc =", value, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescNotEqualTo(String value) {
            addCriterion("link_desc <>", value, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescGreaterThan(String value) {
            addCriterion("link_desc >", value, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescGreaterThanOrEqualTo(String value) {
            addCriterion("link_desc >=", value, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescLessThan(String value) {
            addCriterion("link_desc <", value, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescLessThanOrEqualTo(String value) {
            addCriterion("link_desc <=", value, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescLike(String value) {
            addCriterion("link_desc like", value, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescNotLike(String value) {
            addCriterion("link_desc not like", value, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescIn(List<String> values) {
            addCriterion("link_desc in", values, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescNotIn(List<String> values) {
            addCriterion("link_desc not in", values, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescBetween(String value1, String value2) {
            addCriterion("link_desc between", value1, value2, "linkDesc");
            return (Criteria) this;
        }

        public Criteria andLinkDescNotBetween(String value1, String value2) {
            addCriterion("link_desc not between", value1, value2, "linkDesc");
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

        public Criteria andNameCnIsNull() {
            addCriterion("name_cn is null");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNotNull() {
            addCriterion("name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andNameCnEqualTo(String value) {
            addCriterion("name_cn =", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotEqualTo(String value) {
            addCriterion("name_cn <>", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThan(String value) {
            addCriterion("name_cn >", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("name_cn >=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThan(String value) {
            addCriterion("name_cn <", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThanOrEqualTo(String value) {
            addCriterion("name_cn <=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLike(String value) {
            addCriterion("name_cn like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotLike(String value) {
            addCriterion("name_cn not like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnIn(List<String> values) {
            addCriterion("name_cn in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotIn(List<String> values) {
            addCriterion("name_cn not in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnBetween(String value1, String value2) {
            addCriterion("name_cn between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotBetween(String value1, String value2) {
            addCriterion("name_cn not between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnIsNull() {
            addCriterion("full_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andFullNameCnIsNotNull() {
            addCriterion("full_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andFullNameCnEqualTo(String value) {
            addCriterion("full_name_cn =", value, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnNotEqualTo(String value) {
            addCriterion("full_name_cn <>", value, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnGreaterThan(String value) {
            addCriterion("full_name_cn >", value, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("full_name_cn >=", value, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnLessThan(String value) {
            addCriterion("full_name_cn <", value, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnLessThanOrEqualTo(String value) {
            addCriterion("full_name_cn <=", value, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnLike(String value) {
            addCriterion("full_name_cn like", value, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnNotLike(String value) {
            addCriterion("full_name_cn not like", value, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnIn(List<String> values) {
            addCriterion("full_name_cn in", values, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnNotIn(List<String> values) {
            addCriterion("full_name_cn not in", values, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnBetween(String value1, String value2) {
            addCriterion("full_name_cn between", value1, value2, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnNotBetween(String value1, String value2) {
            addCriterion("full_name_cn not between", value1, value2, "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("name_en is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("name_en is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("name_en =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("name_en <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("name_en >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("name_en >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("name_en <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("name_en <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("name_en like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("name_en not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("name_en in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("name_en not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("name_en between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("name_en not between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnIsNull() {
            addCriterion("full_name_en is null");
            return (Criteria) this;
        }

        public Criteria andFullNameEnIsNotNull() {
            addCriterion("full_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andFullNameEnEqualTo(String value) {
            addCriterion("full_name_en =", value, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnNotEqualTo(String value) {
            addCriterion("full_name_en <>", value, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnGreaterThan(String value) {
            addCriterion("full_name_en >", value, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("full_name_en >=", value, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnLessThan(String value) {
            addCriterion("full_name_en <", value, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnLessThanOrEqualTo(String value) {
            addCriterion("full_name_en <=", value, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnLike(String value) {
            addCriterion("full_name_en like", value, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnNotLike(String value) {
            addCriterion("full_name_en not like", value, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnIn(List<String> values) {
            addCriterion("full_name_en in", values, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnNotIn(List<String> values) {
            addCriterion("full_name_en not in", values, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnBetween(String value1, String value2) {
            addCriterion("full_name_en between", value1, value2, "fullNameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnNotBetween(String value1, String value2) {
            addCriterion("full_name_en not between", value1, value2, "fullNameEn");
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

        public Criteria andLogoLikeInsensitive(String value) {
            addCriterion("upper(logo) like", value.toUpperCase(), "logo");
            return (Criteria) this;
        }

        public Criteria andUrlLikeInsensitive(String value) {
            addCriterion("upper(url) like", value.toUpperCase(), "url");
            return (Criteria) this;
        }

        public Criteria andLinkDescLikeInsensitive(String value) {
            addCriterion("upper(link_desc) like", value.toUpperCase(), "linkDesc");
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

        public Criteria andNameCnLikeInsensitive(String value) {
            addCriterion("upper(name_cn) like", value.toUpperCase(), "nameCn");
            return (Criteria) this;
        }

        public Criteria andFullNameCnLikeInsensitive(String value) {
            addCriterion("upper(full_name_cn) like", value.toUpperCase(), "fullNameCn");
            return (Criteria) this;
        }

        public Criteria andNameEnLikeInsensitive(String value) {
            addCriterion("upper(name_en) like", value.toUpperCase(), "nameEn");
            return (Criteria) this;
        }

        public Criteria andFullNameEnLikeInsensitive(String value) {
            addCriterion("upper(full_name_en) like", value.toUpperCase(), "fullNameEn");
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
     */
    public static class Criteria extends GeneratedCriteria {
        /**
         */
        private FriendLinkExample example;

        /**
         */
        protected Criteria(FriendLinkExample example) {
            super();
            this.example = example;
        }

        /**
         */
        public FriendLinkExample example() {
            return this.example;
        }

        /**
         */
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        public interface ICriteriaAdd {
            /**
             */
            Criteria add(Criteria add);
        }
    }

    /**
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