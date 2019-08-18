package top.buukle.security.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemExample {
    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    protected String orderByClause;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    protected boolean distinct;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public ItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public ItemExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public ItemExample orderBy(String ... orderByClauses) {
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
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
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
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
     */
    public static Criteria newAndCreateCriteria() {
        ItemExample example = new ItemExample();
        return example.createCriteria();
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andSkuidIsNull() {
            addCriterion("skuId is null");
            return (Criteria) this;
        }

        public Criteria andSkuidIsNotNull() {
            addCriterion("skuId is not null");
            return (Criteria) this;
        }

        public Criteria andSkuidEqualTo(String value) {
            addCriterion("skuId =", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotEqualTo(String value) {
            addCriterion("skuId <>", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidGreaterThan(String value) {
            addCriterion("skuId >", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidGreaterThanOrEqualTo(String value) {
            addCriterion("skuId >=", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLessThan(String value) {
            addCriterion("skuId <", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLessThanOrEqualTo(String value) {
            addCriterion("skuId <=", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLike(String value) {
            addCriterion("skuId like", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotLike(String value) {
            addCriterion("skuId not like", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidIn(List<String> values) {
            addCriterion("skuId in", values, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotIn(List<String> values) {
            addCriterion("skuId not in", values, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidBetween(String value1, String value2) {
            addCriterion("skuId between", value1, value2, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotBetween(String value1, String value2) {
            addCriterion("skuId not between", value1, value2, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkunameIsNull() {
            addCriterion("skuName is null");
            return (Criteria) this;
        }

        public Criteria andSkunameIsNotNull() {
            addCriterion("skuName is not null");
            return (Criteria) this;
        }

        public Criteria andSkunameEqualTo(String value) {
            addCriterion("skuName =", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameNotEqualTo(String value) {
            addCriterion("skuName <>", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameGreaterThan(String value) {
            addCriterion("skuName >", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameGreaterThanOrEqualTo(String value) {
            addCriterion("skuName >=", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameLessThan(String value) {
            addCriterion("skuName <", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameLessThanOrEqualTo(String value) {
            addCriterion("skuName <=", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameLike(String value) {
            addCriterion("skuName like", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameNotLike(String value) {
            addCriterion("skuName not like", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameIn(List<String> values) {
            addCriterion("skuName in", values, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameNotIn(List<String> values) {
            addCriterion("skuName not in", values, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameBetween(String value1, String value2) {
            addCriterion("skuName between", value1, value2, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameNotBetween(String value1, String value2) {
            addCriterion("skuName not between", value1, value2, "skuname");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNull() {
            addCriterion("bizType is null");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNotNull() {
            addCriterion("bizType is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypeEqualTo(Integer value) {
            addCriterion("bizType =", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotEqualTo(Integer value) {
            addCriterion("bizType <>", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThan(Integer value) {
            addCriterion("bizType >", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bizType >=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThan(Integer value) {
            addCriterion("bizType <", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThanOrEqualTo(Integer value) {
            addCriterion("bizType <=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeIn(List<Integer> values) {
            addCriterion("bizType in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotIn(List<Integer> values) {
            addCriterion("bizType not in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeBetween(Integer value1, Integer value2) {
            addCriterion("bizType between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotBetween(Integer value1, Integer value2) {
            addCriterion("bizType not between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andProductidIsNull() {
            addCriterion("productId is null");
            return (Criteria) this;
        }

        public Criteria andProductidIsNotNull() {
            addCriterion("productId is not null");
            return (Criteria) this;
        }

        public Criteria andProductidEqualTo(Integer value) {
            addCriterion("productId =", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotEqualTo(Integer value) {
            addCriterion("productId <>", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThan(Integer value) {
            addCriterion("productId >", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidGreaterThanOrEqualTo(Integer value) {
            addCriterion("productId >=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThan(Integer value) {
            addCriterion("productId <", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidLessThanOrEqualTo(Integer value) {
            addCriterion("productId <=", value, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidIn(List<Integer> values) {
            addCriterion("productId in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotIn(List<Integer> values) {
            addCriterion("productId not in", values, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidBetween(Integer value1, Integer value2) {
            addCriterion("productId between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andProductidNotBetween(Integer value1, Integer value2) {
            addCriterion("productId not between", value1, value2, "productid");
            return (Criteria) this;
        }

        public Criteria andMerchantidIsNull() {
            addCriterion("merchantId is null");
            return (Criteria) this;
        }

        public Criteria andMerchantidIsNotNull() {
            addCriterion("merchantId is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantidEqualTo(String value) {
            addCriterion("merchantId =", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotEqualTo(String value) {
            addCriterion("merchantId <>", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidGreaterThan(String value) {
            addCriterion("merchantId >", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidGreaterThanOrEqualTo(String value) {
            addCriterion("merchantId >=", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidLessThan(String value) {
            addCriterion("merchantId <", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidLessThanOrEqualTo(String value) {
            addCriterion("merchantId <=", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidLike(String value) {
            addCriterion("merchantId like", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotLike(String value) {
            addCriterion("merchantId not like", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidIn(List<String> values) {
            addCriterion("merchantId in", values, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotIn(List<String> values) {
            addCriterion("merchantId not in", values, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidBetween(String value1, String value2) {
            addCriterion("merchantId between", value1, value2, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotBetween(String value1, String value2) {
            addCriterion("merchantId not between", value1, value2, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantnameIsNull() {
            addCriterion("merchantName is null");
            return (Criteria) this;
        }

        public Criteria andMerchantnameIsNotNull() {
            addCriterion("merchantName is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantnameEqualTo(String value) {
            addCriterion("merchantName =", value, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameNotEqualTo(String value) {
            addCriterion("merchantName <>", value, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameGreaterThan(String value) {
            addCriterion("merchantName >", value, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameGreaterThanOrEqualTo(String value) {
            addCriterion("merchantName >=", value, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameLessThan(String value) {
            addCriterion("merchantName <", value, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameLessThanOrEqualTo(String value) {
            addCriterion("merchantName <=", value, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameLike(String value) {
            addCriterion("merchantName like", value, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameNotLike(String value) {
            addCriterion("merchantName not like", value, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameIn(List<String> values) {
            addCriterion("merchantName in", values, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameNotIn(List<String> values) {
            addCriterion("merchantName not in", values, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameBetween(String value1, String value2) {
            addCriterion("merchantName between", value1, value2, "merchantname");
            return (Criteria) this;
        }

        public Criteria andMerchantnameNotBetween(String value1, String value2) {
            addCriterion("merchantName not between", value1, value2, "merchantname");
            return (Criteria) this;
        }

        public Criteria andThirdcodeIsNull() {
            addCriterion("thirdCode is null");
            return (Criteria) this;
        }

        public Criteria andThirdcodeIsNotNull() {
            addCriterion("thirdCode is not null");
            return (Criteria) this;
        }

        public Criteria andThirdcodeEqualTo(String value) {
            addCriterion("thirdCode =", value, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeNotEqualTo(String value) {
            addCriterion("thirdCode <>", value, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeGreaterThan(String value) {
            addCriterion("thirdCode >", value, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeGreaterThanOrEqualTo(String value) {
            addCriterion("thirdCode >=", value, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeLessThan(String value) {
            addCriterion("thirdCode <", value, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeLessThanOrEqualTo(String value) {
            addCriterion("thirdCode <=", value, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeLike(String value) {
            addCriterion("thirdCode like", value, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeNotLike(String value) {
            addCriterion("thirdCode not like", value, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeIn(List<String> values) {
            addCriterion("thirdCode in", values, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeNotIn(List<String> values) {
            addCriterion("thirdCode not in", values, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeBetween(String value1, String value2) {
            addCriterion("thirdCode between", value1, value2, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andThirdcodeNotBetween(String value1, String value2) {
            addCriterion("thirdCode not between", value1, value2, "thirdcode");
            return (Criteria) this;
        }

        public Criteria andItemstatusIsNull() {
            addCriterion("itemStatus is null");
            return (Criteria) this;
        }

        public Criteria andItemstatusIsNotNull() {
            addCriterion("itemStatus is not null");
            return (Criteria) this;
        }

        public Criteria andItemstatusEqualTo(Integer value) {
            addCriterion("itemStatus =", value, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andItemstatusNotEqualTo(Integer value) {
            addCriterion("itemStatus <>", value, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andItemstatusGreaterThan(Integer value) {
            addCriterion("itemStatus >", value, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andItemstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("itemStatus >=", value, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andItemstatusLessThan(Integer value) {
            addCriterion("itemStatus <", value, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andItemstatusLessThanOrEqualTo(Integer value) {
            addCriterion("itemStatus <=", value, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andItemstatusIn(List<Integer> values) {
            addCriterion("itemStatus in", values, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andItemstatusNotIn(List<Integer> values) {
            addCriterion("itemStatus not in", values, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andItemstatusBetween(Integer value1, Integer value2) {
            addCriterion("itemStatus between", value1, value2, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andItemstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("itemStatus not between", value1, value2, "itemstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNull() {
            addCriterion("auditStatus is null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIsNotNull() {
            addCriterion("auditStatus is not null");
            return (Criteria) this;
        }

        public Criteria andAuditstatusEqualTo(Integer value) {
            addCriterion("auditStatus =", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotEqualTo(Integer value) {
            addCriterion("auditStatus <>", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThan(Integer value) {
            addCriterion("auditStatus >", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("auditStatus >=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThan(Integer value) {
            addCriterion("auditStatus <", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusLessThanOrEqualTo(Integer value) {
            addCriterion("auditStatus <=", value, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusIn(List<Integer> values) {
            addCriterion("auditStatus in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotIn(List<Integer> values) {
            addCriterion("auditStatus not in", values, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusBetween(Integer value1, Integer value2) {
            addCriterion("auditStatus between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andAuditstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("auditStatus not between", value1, value2, "auditstatus");
            return (Criteria) this;
        }

        public Criteria andPinIsNull() {
            addCriterion("pin is null");
            return (Criteria) this;
        }

        public Criteria andPinIsNotNull() {
            addCriterion("pin is not null");
            return (Criteria) this;
        }

        public Criteria andPinEqualTo(String value) {
            addCriterion("pin =", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotEqualTo(String value) {
            addCriterion("pin <>", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThan(String value) {
            addCriterion("pin >", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThanOrEqualTo(String value) {
            addCriterion("pin >=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThan(String value) {
            addCriterion("pin <", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThanOrEqualTo(String value) {
            addCriterion("pin <=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLike(String value) {
            addCriterion("pin like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotLike(String value) {
            addCriterion("pin not like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinIn(List<String> values) {
            addCriterion("pin in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotIn(List<String> values) {
            addCriterion("pin not in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinBetween(String value1, String value2) {
            addCriterion("pin between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotBetween(String value1, String value2) {
            addCriterion("pin not between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateIsNull() {
            addCriterion("fundCloseEndDate is null");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateIsNotNull() {
            addCriterion("fundCloseEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateEqualTo(Date value) {
            addCriterion("fundCloseEndDate =", value, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateNotEqualTo(Date value) {
            addCriterion("fundCloseEndDate <>", value, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateGreaterThan(Date value) {
            addCriterion("fundCloseEndDate >", value, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("fundCloseEndDate >=", value, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateLessThan(Date value) {
            addCriterion("fundCloseEndDate <", value, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateLessThanOrEqualTo(Date value) {
            addCriterion("fundCloseEndDate <=", value, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateIn(List<Date> values) {
            addCriterion("fundCloseEndDate in", values, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateNotIn(List<Date> values) {
            addCriterion("fundCloseEndDate not in", values, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateBetween(Date value1, Date value2) {
            addCriterion("fundCloseEndDate between", value1, value2, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundcloseenddateNotBetween(Date value1, Date value2) {
            addCriterion("fundCloseEndDate not between", value1, value2, "fundcloseenddate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateIsNull() {
            addCriterion("fundCloseBeginDate is null");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateIsNotNull() {
            addCriterion("fundCloseBeginDate is not null");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateEqualTo(Date value) {
            addCriterion("fundCloseBeginDate =", value, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateNotEqualTo(Date value) {
            addCriterion("fundCloseBeginDate <>", value, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateGreaterThan(Date value) {
            addCriterion("fundCloseBeginDate >", value, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateGreaterThanOrEqualTo(Date value) {
            addCriterion("fundCloseBeginDate >=", value, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateLessThan(Date value) {
            addCriterion("fundCloseBeginDate <", value, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateLessThanOrEqualTo(Date value) {
            addCriterion("fundCloseBeginDate <=", value, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateIn(List<Date> values) {
            addCriterion("fundCloseBeginDate in", values, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateNotIn(List<Date> values) {
            addCriterion("fundCloseBeginDate not in", values, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateBetween(Date value1, Date value2) {
            addCriterion("fundCloseBeginDate between", value1, value2, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundclosebegindateNotBetween(Date value1, Date value2) {
            addCriterion("fundCloseBeginDate not between", value1, value2, "fundclosebegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateIsNull() {
            addCriterion("fundraisingBeginDate is null");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateIsNotNull() {
            addCriterion("fundraisingBeginDate is not null");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateEqualTo(Date value) {
            addCriterion("fundraisingBeginDate =", value, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateNotEqualTo(Date value) {
            addCriterion("fundraisingBeginDate <>", value, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateGreaterThan(Date value) {
            addCriterion("fundraisingBeginDate >", value, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateGreaterThanOrEqualTo(Date value) {
            addCriterion("fundraisingBeginDate >=", value, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateLessThan(Date value) {
            addCriterion("fundraisingBeginDate <", value, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateLessThanOrEqualTo(Date value) {
            addCriterion("fundraisingBeginDate <=", value, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateIn(List<Date> values) {
            addCriterion("fundraisingBeginDate in", values, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateNotIn(List<Date> values) {
            addCriterion("fundraisingBeginDate not in", values, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateBetween(Date value1, Date value2) {
            addCriterion("fundraisingBeginDate between", value1, value2, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingbegindateNotBetween(Date value1, Date value2) {
            addCriterion("fundraisingBeginDate not between", value1, value2, "fundraisingbegindate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateIsNull() {
            addCriterion("fundraisingEndDate is null");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateIsNotNull() {
            addCriterion("fundraisingEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateEqualTo(Date value) {
            addCriterion("fundraisingEndDate =", value, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateNotEqualTo(Date value) {
            addCriterion("fundraisingEndDate <>", value, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateGreaterThan(Date value) {
            addCriterion("fundraisingEndDate >", value, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("fundraisingEndDate >=", value, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateLessThan(Date value) {
            addCriterion("fundraisingEndDate <", value, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateLessThanOrEqualTo(Date value) {
            addCriterion("fundraisingEndDate <=", value, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateIn(List<Date> values) {
            addCriterion("fundraisingEndDate in", values, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateNotIn(List<Date> values) {
            addCriterion("fundraisingEndDate not in", values, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateBetween(Date value1, Date value2) {
            addCriterion("fundraisingEndDate between", value1, value2, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andFundraisingenddateNotBetween(Date value1, Date value2) {
            addCriterion("fundraisingEndDate not between", value1, value2, "fundraisingenddate");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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

        public Criteria andBak06IsNull() {
            addCriterion("bak06 is null");
            return (Criteria) this;
        }

        public Criteria andBak06IsNotNull() {
            addCriterion("bak06 is not null");
            return (Criteria) this;
        }

        public Criteria andBak06EqualTo(String value) {
            addCriterion("bak06 =", value, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06NotEqualTo(String value) {
            addCriterion("bak06 <>", value, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06GreaterThan(String value) {
            addCriterion("bak06 >", value, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06GreaterThanOrEqualTo(String value) {
            addCriterion("bak06 >=", value, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06LessThan(String value) {
            addCriterion("bak06 <", value, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06LessThanOrEqualTo(String value) {
            addCriterion("bak06 <=", value, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06Like(String value) {
            addCriterion("bak06 like", value, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06NotLike(String value) {
            addCriterion("bak06 not like", value, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06In(List<String> values) {
            addCriterion("bak06 in", values, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06NotIn(List<String> values) {
            addCriterion("bak06 not in", values, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06Between(String value1, String value2) {
            addCriterion("bak06 between", value1, value2, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak06NotBetween(String value1, String value2) {
            addCriterion("bak06 not between", value1, value2, "bak06");
            return (Criteria) this;
        }

        public Criteria andBak07IsNull() {
            addCriterion("bak07 is null");
            return (Criteria) this;
        }

        public Criteria andBak07IsNotNull() {
            addCriterion("bak07 is not null");
            return (Criteria) this;
        }

        public Criteria andBak07EqualTo(String value) {
            addCriterion("bak07 =", value, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07NotEqualTo(String value) {
            addCriterion("bak07 <>", value, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07GreaterThan(String value) {
            addCriterion("bak07 >", value, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07GreaterThanOrEqualTo(String value) {
            addCriterion("bak07 >=", value, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07LessThan(String value) {
            addCriterion("bak07 <", value, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07LessThanOrEqualTo(String value) {
            addCriterion("bak07 <=", value, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07Like(String value) {
            addCriterion("bak07 like", value, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07NotLike(String value) {
            addCriterion("bak07 not like", value, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07In(List<String> values) {
            addCriterion("bak07 in", values, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07NotIn(List<String> values) {
            addCriterion("bak07 not in", values, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07Between(String value1, String value2) {
            addCriterion("bak07 between", value1, value2, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak07NotBetween(String value1, String value2) {
            addCriterion("bak07 not between", value1, value2, "bak07");
            return (Criteria) this;
        }

        public Criteria andBak08IsNull() {
            addCriterion("bak08 is null");
            return (Criteria) this;
        }

        public Criteria andBak08IsNotNull() {
            addCriterion("bak08 is not null");
            return (Criteria) this;
        }

        public Criteria andBak08EqualTo(String value) {
            addCriterion("bak08 =", value, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08NotEqualTo(String value) {
            addCriterion("bak08 <>", value, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08GreaterThan(String value) {
            addCriterion("bak08 >", value, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08GreaterThanOrEqualTo(String value) {
            addCriterion("bak08 >=", value, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08LessThan(String value) {
            addCriterion("bak08 <", value, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08LessThanOrEqualTo(String value) {
            addCriterion("bak08 <=", value, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08Like(String value) {
            addCriterion("bak08 like", value, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08NotLike(String value) {
            addCriterion("bak08 not like", value, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08In(List<String> values) {
            addCriterion("bak08 in", values, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08NotIn(List<String> values) {
            addCriterion("bak08 not in", values, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08Between(String value1, String value2) {
            addCriterion("bak08 between", value1, value2, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak08NotBetween(String value1, String value2) {
            addCriterion("bak08 not between", value1, value2, "bak08");
            return (Criteria) this;
        }

        public Criteria andBak09IsNull() {
            addCriterion("bak09 is null");
            return (Criteria) this;
        }

        public Criteria andBak09IsNotNull() {
            addCriterion("bak09 is not null");
            return (Criteria) this;
        }

        public Criteria andBak09EqualTo(String value) {
            addCriterion("bak09 =", value, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09NotEqualTo(String value) {
            addCriterion("bak09 <>", value, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09GreaterThan(String value) {
            addCriterion("bak09 >", value, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09GreaterThanOrEqualTo(String value) {
            addCriterion("bak09 >=", value, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09LessThan(String value) {
            addCriterion("bak09 <", value, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09LessThanOrEqualTo(String value) {
            addCriterion("bak09 <=", value, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09Like(String value) {
            addCriterion("bak09 like", value, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09NotLike(String value) {
            addCriterion("bak09 not like", value, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09In(List<String> values) {
            addCriterion("bak09 in", values, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09NotIn(List<String> values) {
            addCriterion("bak09 not in", values, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09Between(String value1, String value2) {
            addCriterion("bak09 between", value1, value2, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak09NotBetween(String value1, String value2) {
            addCriterion("bak09 not between", value1, value2, "bak09");
            return (Criteria) this;
        }

        public Criteria andBak10IsNull() {
            addCriterion("bak10 is null");
            return (Criteria) this;
        }

        public Criteria andBak10IsNotNull() {
            addCriterion("bak10 is not null");
            return (Criteria) this;
        }

        public Criteria andBak10EqualTo(String value) {
            addCriterion("bak10 =", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotEqualTo(String value) {
            addCriterion("bak10 <>", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10GreaterThan(String value) {
            addCriterion("bak10 >", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10GreaterThanOrEqualTo(String value) {
            addCriterion("bak10 >=", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10LessThan(String value) {
            addCriterion("bak10 <", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10LessThanOrEqualTo(String value) {
            addCriterion("bak10 <=", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10Like(String value) {
            addCriterion("bak10 like", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotLike(String value) {
            addCriterion("bak10 not like", value, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10In(List<String> values) {
            addCriterion("bak10 in", values, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotIn(List<String> values) {
            addCriterion("bak10 not in", values, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10Between(String value1, String value2) {
            addCriterion("bak10 between", value1, value2, "bak10");
            return (Criteria) this;
        }

        public Criteria andBak10NotBetween(String value1, String value2) {
            addCriterion("bak10 not between", value1, value2, "bak10");
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

        public Criteria andUuidLikeInsensitive(String value) {
            addCriterion("upper(uuid) like", value.toUpperCase(), "uuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLikeInsensitive(String value) {
            addCriterion("upper(skuId) like", value.toUpperCase(), "skuid");
            return (Criteria) this;
        }

        public Criteria andSkunameLikeInsensitive(String value) {
            addCriterion("upper(skuName) like", value.toUpperCase(), "skuname");
            return (Criteria) this;
        }

        public Criteria andMerchantidLikeInsensitive(String value) {
            addCriterion("upper(merchantId) like", value.toUpperCase(), "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantnameLikeInsensitive(String value) {
            addCriterion("upper(merchantName) like", value.toUpperCase(), "merchantname");
            return (Criteria) this;
        }

        public Criteria andThirdcodeLikeInsensitive(String value) {
            addCriterion("upper(thirdCode) like", value.toUpperCase(), "thirdcode");
            return (Criteria) this;
        }

        public Criteria andPinLikeInsensitive(String value) {
            addCriterion("upper(pin) like", value.toUpperCase(), "pin");
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

        public Criteria andBak06LikeInsensitive(String value) {
            addCriterion("upper(bak06) like", value.toUpperCase(), "bak06");
            return (Criteria) this;
        }

        public Criteria andBak07LikeInsensitive(String value) {
            addCriterion("upper(bak07) like", value.toUpperCase(), "bak07");
            return (Criteria) this;
        }

        public Criteria andBak08LikeInsensitive(String value) {
            addCriterion("upper(bak08) like", value.toUpperCase(), "bak08");
            return (Criteria) this;
        }

        public Criteria andBak09LikeInsensitive(String value) {
            addCriterion("upper(bak09) like", value.toUpperCase(), "bak09");
            return (Criteria) this;
        }

        public Criteria andBak10LikeInsensitive(String value) {
            addCriterion("upper(bak10) like", value.toUpperCase(), "bak10");
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
     * @mbg.generated do_not_delete_during_merge Sun Aug 18 22:53:14 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {
        /**
         *
         * @mbg.generated Sun Aug 18 22:53:14 CST 2019
         */
        private ItemExample example;

        /**
         *
         * @mbg.generated Sun Aug 18 22:53:14 CST 2019
         */
        protected Criteria(ItemExample example) {
            super();
            this.example = example;
        }

        /**
         *
         * @mbg.generated Sun Aug 18 22:53:14 CST 2019
         */
        public ItemExample example() {
            return this.example;
        }

        /**
         *
         * @mbg.generated Sun Aug 18 22:53:14 CST 2019
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
             * @mbg.generated Sun Aug 18 22:53:14 CST 2019
             */
            Criteria add(Criteria add);
        }
    }

    /**
     *
     * @mbg.generated Sun Aug 18 22:53:14 CST 2019
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