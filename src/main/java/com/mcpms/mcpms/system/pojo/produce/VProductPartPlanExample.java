package com.mcpms.mcpms.system.pojo.produce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VProductPartPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VProductPartPlanExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(String value) {
            addCriterion("batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(String value) {
            addCriterion("batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(String value) {
            addCriterion("batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(String value) {
            addCriterion("batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(String value) {
            addCriterion("batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(String value) {
            addCriterion("batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLike(String value) {
            addCriterion("batch like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotLike(String value) {
            addCriterion("batch not like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<String> values) {
            addCriterion("batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<String> values) {
            addCriterion("batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(String value1, String value2) {
            addCriterion("batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(String value1, String value2) {
            addCriterion("batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andRunningNumIsNull() {
            addCriterion("running_num is null");
            return (Criteria) this;
        }

        public Criteria andRunningNumIsNotNull() {
            addCriterion("running_num is not null");
            return (Criteria) this;
        }

        public Criteria andRunningNumEqualTo(String value) {
            addCriterion("running_num =", value, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumNotEqualTo(String value) {
            addCriterion("running_num <>", value, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumGreaterThan(String value) {
            addCriterion("running_num >", value, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumGreaterThanOrEqualTo(String value) {
            addCriterion("running_num >=", value, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumLessThan(String value) {
            addCriterion("running_num <", value, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumLessThanOrEqualTo(String value) {
            addCriterion("running_num <=", value, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumLike(String value) {
            addCriterion("running_num like", value, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumNotLike(String value) {
            addCriterion("running_num not like", value, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumIn(List<String> values) {
            addCriterion("running_num in", values, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumNotIn(List<String> values) {
            addCriterion("running_num not in", values, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumBetween(String value1, String value2) {
            addCriterion("running_num between", value1, value2, "runningNum");
            return (Criteria) this;
        }

        public Criteria andRunningNumNotBetween(String value1, String value2) {
            addCriterion("running_num not between", value1, value2, "runningNum");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdIsNull() {
            addCriterion("order_product_part_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdIsNotNull() {
            addCriterion("order_product_part_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdEqualTo(Long value) {
            addCriterion("order_product_part_id =", value, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdNotEqualTo(Long value) {
            addCriterion("order_product_part_id <>", value, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdGreaterThan(Long value) {
            addCriterion("order_product_part_id >", value, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_product_part_id >=", value, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdLessThan(Long value) {
            addCriterion("order_product_part_id <", value, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdLessThanOrEqualTo(Long value) {
            addCriterion("order_product_part_id <=", value, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdIn(List<Long> values) {
            addCriterion("order_product_part_id in", values, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdNotIn(List<Long> values) {
            addCriterion("order_product_part_id not in", values, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdBetween(Long value1, Long value2) {
            addCriterion("order_product_part_id between", value1, value2, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andOrderProductPartIdNotBetween(Long value1, Long value2) {
            addCriterion("order_product_part_id not between", value1, value2, "orderProductPartId");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPlanTimeIsNull() {
            addCriterion("plan_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanTimeIsNotNull() {
            addCriterion("plan_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTimeEqualTo(String value) {
            addCriterion("plan_time =", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeNotEqualTo(String value) {
            addCriterion("plan_time <>", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeGreaterThan(String value) {
            addCriterion("plan_time >", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_time >=", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeLessThan(String value) {
            addCriterion("plan_time <", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeLessThanOrEqualTo(String value) {
            addCriterion("plan_time <=", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeLike(String value) {
            addCriterion("plan_time like", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeNotLike(String value) {
            addCriterion("plan_time not like", value, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeIn(List<String> values) {
            addCriterion("plan_time in", values, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeNotIn(List<String> values) {
            addCriterion("plan_time not in", values, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeBetween(String value1, String value2) {
            addCriterion("plan_time between", value1, value2, "planTime");
            return (Criteria) this;
        }

        public Criteria andPlanTimeNotBetween(String value1, String value2) {
            addCriterion("plan_time not between", value1, value2, "planTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeIsNull() {
            addCriterion("actual_time is null");
            return (Criteria) this;
        }

        public Criteria andActualTimeIsNotNull() {
            addCriterion("actual_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualTimeEqualTo(String value) {
            addCriterion("actual_time =", value, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeNotEqualTo(String value) {
            addCriterion("actual_time <>", value, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeGreaterThan(String value) {
            addCriterion("actual_time >", value, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeGreaterThanOrEqualTo(String value) {
            addCriterion("actual_time >=", value, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeLessThan(String value) {
            addCriterion("actual_time <", value, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeLessThanOrEqualTo(String value) {
            addCriterion("actual_time <=", value, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeLike(String value) {
            addCriterion("actual_time like", value, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeNotLike(String value) {
            addCriterion("actual_time not like", value, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeIn(List<String> values) {
            addCriterion("actual_time in", values, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeNotIn(List<String> values) {
            addCriterion("actual_time not in", values, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeBetween(String value1, String value2) {
            addCriterion("actual_time between", value1, value2, "actualTime");
            return (Criteria) this;
        }

        public Criteria andActualTimeNotBetween(String value1, String value2) {
            addCriterion("actual_time not between", value1, value2, "actualTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(String value) {
            addCriterion("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(String value) {
            addCriterion("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(String value) {
            addCriterion("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(String value) {
            addCriterion("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(String value) {
            addCriterion("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(String value) {
            addCriterion("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLike(String value) {
            addCriterion("in_time like", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotLike(String value) {
            addCriterion("in_time not like", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<String> values) {
            addCriterion("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<String> values) {
            addCriterion("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(String value1, String value2) {
            addCriterion("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(String value1, String value2) {
            addCriterion("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("text is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("text is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("text =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("text <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("text >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("text >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("text <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("text <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("text like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("text not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("text in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("text not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("text between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("text not between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andProducerIsNull() {
            addCriterion("producer is null");
            return (Criteria) this;
        }

        public Criteria andProducerIsNotNull() {
            addCriterion("producer is not null");
            return (Criteria) this;
        }

        public Criteria andProducerEqualTo(String value) {
            addCriterion("producer =", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotEqualTo(String value) {
            addCriterion("producer <>", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerGreaterThan(String value) {
            addCriterion("producer >", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerGreaterThanOrEqualTo(String value) {
            addCriterion("producer >=", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLessThan(String value) {
            addCriterion("producer <", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLessThanOrEqualTo(String value) {
            addCriterion("producer <=", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLike(String value) {
            addCriterion("producer like", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotLike(String value) {
            addCriterion("producer not like", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerIn(List<String> values) {
            addCriterion("producer in", values, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotIn(List<String> values) {
            addCriterion("producer not in", values, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerBetween(String value1, String value2) {
            addCriterion("producer between", value1, value2, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotBetween(String value1, String value2) {
            addCriterion("producer not between", value1, value2, "producer");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleIsNull() {
            addCriterion("approve_people is null");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleIsNotNull() {
            addCriterion("approve_people is not null");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleEqualTo(String value) {
            addCriterion("approve_people =", value, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleNotEqualTo(String value) {
            addCriterion("approve_people <>", value, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleGreaterThan(String value) {
            addCriterion("approve_people >", value, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("approve_people >=", value, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleLessThan(String value) {
            addCriterion("approve_people <", value, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleLessThanOrEqualTo(String value) {
            addCriterion("approve_people <=", value, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleLike(String value) {
            addCriterion("approve_people like", value, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleNotLike(String value) {
            addCriterion("approve_people not like", value, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleIn(List<String> values) {
            addCriterion("approve_people in", values, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleNotIn(List<String> values) {
            addCriterion("approve_people not in", values, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleBetween(String value1, String value2) {
            addCriterion("approve_people between", value1, value2, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApprovePeopleNotBetween(String value1, String value2) {
            addCriterion("approve_people not between", value1, value2, "approvePeople");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNull() {
            addCriterion("approve_time is null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNotNull() {
            addCriterion("approve_time is not null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeEqualTo(String value) {
            addCriterion("approve_time =", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotEqualTo(String value) {
            addCriterion("approve_time <>", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThan(String value) {
            addCriterion("approve_time >", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("approve_time >=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThan(String value) {
            addCriterion("approve_time <", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThanOrEqualTo(String value) {
            addCriterion("approve_time <=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLike(String value) {
            addCriterion("approve_time like", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotLike(String value) {
            addCriterion("approve_time not like", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIn(List<String> values) {
            addCriterion("approve_time in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotIn(List<String> values) {
            addCriterion("approve_time not in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeBetween(String value1, String value2) {
            addCriterion("approve_time between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotBetween(String value1, String value2) {
            addCriterion("approve_time not between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("order_num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("order_num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andPartIdIsNull() {
            addCriterion("part_id is null");
            return (Criteria) this;
        }

        public Criteria andPartIdIsNotNull() {
            addCriterion("part_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartIdEqualTo(Long value) {
            addCriterion("part_id =", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdNotEqualTo(Long value) {
            addCriterion("part_id <>", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdGreaterThan(Long value) {
            addCriterion("part_id >", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdGreaterThanOrEqualTo(Long value) {
            addCriterion("part_id >=", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdLessThan(Long value) {
            addCriterion("part_id <", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdLessThanOrEqualTo(Long value) {
            addCriterion("part_id <=", value, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdIn(List<Long> values) {
            addCriterion("part_id in", values, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdNotIn(List<Long> values) {
            addCriterion("part_id not in", values, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdBetween(Long value1, Long value2) {
            addCriterion("part_id between", value1, value2, "partId");
            return (Criteria) this;
        }

        public Criteria andPartIdNotBetween(Long value1, Long value2) {
            addCriterion("part_id not between", value1, value2, "partId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andPartNameIsNull() {
            addCriterion("part_name is null");
            return (Criteria) this;
        }

        public Criteria andPartNameIsNotNull() {
            addCriterion("part_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartNameEqualTo(String value) {
            addCriterion("part_name =", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameNotEqualTo(String value) {
            addCriterion("part_name <>", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameGreaterThan(String value) {
            addCriterion("part_name >", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameGreaterThanOrEqualTo(String value) {
            addCriterion("part_name >=", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameLessThan(String value) {
            addCriterion("part_name <", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameLessThanOrEqualTo(String value) {
            addCriterion("part_name <=", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameLike(String value) {
            addCriterion("part_name like", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameNotLike(String value) {
            addCriterion("part_name not like", value, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameIn(List<String> values) {
            addCriterion("part_name in", values, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameNotIn(List<String> values) {
            addCriterion("part_name not in", values, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameBetween(String value1, String value2) {
            addCriterion("part_name between", value1, value2, "partName");
            return (Criteria) this;
        }

        public Criteria andPartNameNotBetween(String value1, String value2) {
            addCriterion("part_name not between", value1, value2, "partName");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andDrawingNumIsNull() {
            addCriterion("drawing_num is null");
            return (Criteria) this;
        }

        public Criteria andDrawingNumIsNotNull() {
            addCriterion("drawing_num is not null");
            return (Criteria) this;
        }

        public Criteria andDrawingNumEqualTo(String value) {
            addCriterion("drawing_num =", value, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumNotEqualTo(String value) {
            addCriterion("drawing_num <>", value, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumGreaterThan(String value) {
            addCriterion("drawing_num >", value, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumGreaterThanOrEqualTo(String value) {
            addCriterion("drawing_num >=", value, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumLessThan(String value) {
            addCriterion("drawing_num <", value, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumLessThanOrEqualTo(String value) {
            addCriterion("drawing_num <=", value, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumLike(String value) {
            addCriterion("drawing_num like", value, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumNotLike(String value) {
            addCriterion("drawing_num not like", value, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumIn(List<String> values) {
            addCriterion("drawing_num in", values, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumNotIn(List<String> values) {
            addCriterion("drawing_num not in", values, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumBetween(String value1, String value2) {
            addCriterion("drawing_num between", value1, value2, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andDrawingNumNotBetween(String value1, String value2) {
            addCriterion("drawing_num not between", value1, value2, "drawingNum");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andIsInsertIsNull() {
            addCriterion("is_insert is null");
            return (Criteria) this;
        }

        public Criteria andIsInsertIsNotNull() {
            addCriterion("is_insert is not null");
            return (Criteria) this;
        }

        public Criteria andIsInsertEqualTo(Integer value) {
            addCriterion("is_insert =", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertNotEqualTo(Integer value) {
            addCriterion("is_insert <>", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertGreaterThan(Integer value) {
            addCriterion("is_insert >", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_insert >=", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertLessThan(Integer value) {
            addCriterion("is_insert <", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertLessThanOrEqualTo(Integer value) {
            addCriterion("is_insert <=", value, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertIn(List<Integer> values) {
            addCriterion("is_insert in", values, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertNotIn(List<Integer> values) {
            addCriterion("is_insert not in", values, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertBetween(Integer value1, Integer value2) {
            addCriterion("is_insert between", value1, value2, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertNotBetween(Integer value1, Integer value2) {
            addCriterion("is_insert not between", value1, value2, "isInsert");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrIsNull() {
            addCriterion("is_insert_str is null");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrIsNotNull() {
            addCriterion("is_insert_str is not null");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrEqualTo(String value) {
            addCriterion("is_insert_str =", value, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrNotEqualTo(String value) {
            addCriterion("is_insert_str <>", value, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrGreaterThan(String value) {
            addCriterion("is_insert_str >", value, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrGreaterThanOrEqualTo(String value) {
            addCriterion("is_insert_str >=", value, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrLessThan(String value) {
            addCriterion("is_insert_str <", value, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrLessThanOrEqualTo(String value) {
            addCriterion("is_insert_str <=", value, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrLike(String value) {
            addCriterion("is_insert_str like", value, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrNotLike(String value) {
            addCriterion("is_insert_str not like", value, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrIn(List<String> values) {
            addCriterion("is_insert_str in", values, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrNotIn(List<String> values) {
            addCriterion("is_insert_str not in", values, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrBetween(String value1, String value2) {
            addCriterion("is_insert_str between", value1, value2, "isInsertStr");
            return (Criteria) this;
        }

        public Criteria andIsInsertStrNotBetween(String value1, String value2) {
            addCriterion("is_insert_str not between", value1, value2, "isInsertStr");
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

        public Criteria andStatusStrIsNull() {
            addCriterion("status_str is null");
            return (Criteria) this;
        }

        public Criteria andStatusStrIsNotNull() {
            addCriterion("status_str is not null");
            return (Criteria) this;
        }

        public Criteria andStatusStrEqualTo(String value) {
            addCriterion("status_str =", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrNotEqualTo(String value) {
            addCriterion("status_str <>", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrGreaterThan(String value) {
            addCriterion("status_str >", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrGreaterThanOrEqualTo(String value) {
            addCriterion("status_str >=", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrLessThan(String value) {
            addCriterion("status_str <", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrLessThanOrEqualTo(String value) {
            addCriterion("status_str <=", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrLike(String value) {
            addCriterion("status_str like", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrNotLike(String value) {
            addCriterion("status_str not like", value, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrIn(List<String> values) {
            addCriterion("status_str in", values, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrNotIn(List<String> values) {
            addCriterion("status_str not in", values, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrBetween(String value1, String value2) {
            addCriterion("status_str between", value1, value2, "statusStr");
            return (Criteria) this;
        }

        public Criteria andStatusStrNotBetween(String value1, String value2) {
            addCriterion("status_str not between", value1, value2, "statusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNull() {
            addCriterion("approve_status is null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNotNull() {
            addCriterion("approve_status is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusEqualTo(Integer value) {
            addCriterion("approve_status =", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotEqualTo(Integer value) {
            addCriterion("approve_status <>", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThan(Integer value) {
            addCriterion("approve_status >", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_status >=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThan(Integer value) {
            addCriterion("approve_status <", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThanOrEqualTo(Integer value) {
            addCriterion("approve_status <=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIn(List<Integer> values) {
            addCriterion("approve_status in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotIn(List<Integer> values) {
            addCriterion("approve_status not in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusBetween(Integer value1, Integer value2) {
            addCriterion("approve_status between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_status not between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrIsNull() {
            addCriterion("approve_status_str is null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrIsNotNull() {
            addCriterion("approve_status_str is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrEqualTo(String value) {
            addCriterion("approve_status_str =", value, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrNotEqualTo(String value) {
            addCriterion("approve_status_str <>", value, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrGreaterThan(String value) {
            addCriterion("approve_status_str >", value, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrGreaterThanOrEqualTo(String value) {
            addCriterion("approve_status_str >=", value, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrLessThan(String value) {
            addCriterion("approve_status_str <", value, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrLessThanOrEqualTo(String value) {
            addCriterion("approve_status_str <=", value, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrLike(String value) {
            addCriterion("approve_status_str like", value, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrNotLike(String value) {
            addCriterion("approve_status_str not like", value, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrIn(List<String> values) {
            addCriterion("approve_status_str in", values, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrNotIn(List<String> values) {
            addCriterion("approve_status_str not in", values, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrBetween(String value1, String value2) {
            addCriterion("approve_status_str between", value1, value2, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andApproveStatusStrNotBetween(String value1, String value2) {
            addCriterion("approve_status_str not between", value1, value2, "approveStatusStr");
            return (Criteria) this;
        }

        public Criteria andStatusSortIsNull() {
            addCriterion("status_sort is null");
            return (Criteria) this;
        }

        public Criteria andStatusSortIsNotNull() {
            addCriterion("status_sort is not null");
            return (Criteria) this;
        }

        public Criteria andStatusSortEqualTo(Long value) {
            addCriterion("status_sort =", value, "statusSort");
            return (Criteria) this;
        }

        public Criteria andStatusSortNotEqualTo(Long value) {
            addCriterion("status_sort <>", value, "statusSort");
            return (Criteria) this;
        }

        public Criteria andStatusSortGreaterThan(Long value) {
            addCriterion("status_sort >", value, "statusSort");
            return (Criteria) this;
        }

        public Criteria andStatusSortGreaterThanOrEqualTo(Long value) {
            addCriterion("status_sort >=", value, "statusSort");
            return (Criteria) this;
        }

        public Criteria andStatusSortLessThan(Long value) {
            addCriterion("status_sort <", value, "statusSort");
            return (Criteria) this;
        }

        public Criteria andStatusSortLessThanOrEqualTo(Long value) {
            addCriterion("status_sort <=", value, "statusSort");
            return (Criteria) this;
        }

        public Criteria andStatusSortIn(List<Long> values) {
            addCriterion("status_sort in", values, "statusSort");
            return (Criteria) this;
        }

        public Criteria andStatusSortNotIn(List<Long> values) {
            addCriterion("status_sort not in", values, "statusSort");
            return (Criteria) this;
        }

        public Criteria andStatusSortBetween(Long value1, Long value2) {
            addCriterion("status_sort between", value1, value2, "statusSort");
            return (Criteria) this;
        }

        public Criteria andStatusSortNotBetween(Long value1, Long value2) {
            addCriterion("status_sort not between", value1, value2, "statusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortIsNull() {
            addCriterion("approve_status_sort is null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortIsNotNull() {
            addCriterion("approve_status_sort is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortEqualTo(Long value) {
            addCriterion("approve_status_sort =", value, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortNotEqualTo(Long value) {
            addCriterion("approve_status_sort <>", value, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortGreaterThan(Long value) {
            addCriterion("approve_status_sort >", value, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortGreaterThanOrEqualTo(Long value) {
            addCriterion("approve_status_sort >=", value, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortLessThan(Long value) {
            addCriterion("approve_status_sort <", value, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortLessThanOrEqualTo(Long value) {
            addCriterion("approve_status_sort <=", value, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortIn(List<Long> values) {
            addCriterion("approve_status_sort in", values, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortNotIn(List<Long> values) {
            addCriterion("approve_status_sort not in", values, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortBetween(Long value1, Long value2) {
            addCriterion("approve_status_sort between", value1, value2, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andApproveStatusSortNotBetween(Long value1, Long value2) {
            addCriterion("approve_status_sort not between", value1, value2, "approveStatusSort");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andActualNumIsNull() {
            addCriterion("actual_num is null");
            return (Criteria) this;
        }

        public Criteria andActualNumIsNotNull() {
            addCriterion("actual_num is not null");
            return (Criteria) this;
        }

        public Criteria andActualNumEqualTo(Integer value) {
            addCriterion("actual_num =", value, "actualNum");
            return (Criteria) this;
        }

        public Criteria andActualNumNotEqualTo(Integer value) {
            addCriterion("actual_num <>", value, "actualNum");
            return (Criteria) this;
        }

        public Criteria andActualNumGreaterThan(Integer value) {
            addCriterion("actual_num >", value, "actualNum");
            return (Criteria) this;
        }

        public Criteria andActualNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("actual_num >=", value, "actualNum");
            return (Criteria) this;
        }

        public Criteria andActualNumLessThan(Integer value) {
            addCriterion("actual_num <", value, "actualNum");
            return (Criteria) this;
        }

        public Criteria andActualNumLessThanOrEqualTo(Integer value) {
            addCriterion("actual_num <=", value, "actualNum");
            return (Criteria) this;
        }

        public Criteria andActualNumIn(List<Integer> values) {
            addCriterion("actual_num in", values, "actualNum");
            return (Criteria) this;
        }

        public Criteria andActualNumNotIn(List<Integer> values) {
            addCriterion("actual_num not in", values, "actualNum");
            return (Criteria) this;
        }

        public Criteria andActualNumBetween(Integer value1, Integer value2) {
            addCriterion("actual_num between", value1, value2, "actualNum");
            return (Criteria) this;
        }

        public Criteria andActualNumNotBetween(Integer value1, Integer value2) {
            addCriterion("actual_num not between", value1, value2, "actualNum");
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