package com.mcpms.mcpms.system.pojo.out;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VWarningExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VWarningExample() {
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

        public Criteria andDeliverTimeIsNull() {
            addCriterion("deliver_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeIsNotNull() {
            addCriterion("deliver_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeEqualTo(String value) {
            addCriterion("deliver_time =", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeNotEqualTo(String value) {
            addCriterion("deliver_time <>", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeGreaterThan(String value) {
            addCriterion("deliver_time >", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeGreaterThanOrEqualTo(String value) {
            addCriterion("deliver_time >=", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeLessThan(String value) {
            addCriterion("deliver_time <", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeLessThanOrEqualTo(String value) {
            addCriterion("deliver_time <=", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeLike(String value) {
            addCriterion("deliver_time like", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeNotLike(String value) {
            addCriterion("deliver_time not like", value, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeIn(List<String> values) {
            addCriterion("deliver_time in", values, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeNotIn(List<String> values) {
            addCriterion("deliver_time not in", values, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeBetween(String value1, String value2) {
            addCriterion("deliver_time between", value1, value2, "deliverTime");
            return (Criteria) this;
        }

        public Criteria andDeliverTimeNotBetween(String value1, String value2) {
            addCriterion("deliver_time not between", value1, value2, "deliverTime");
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

        public Criteria andExpeditingTimeIsNull() {
            addCriterion("expediting_time is null");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeIsNotNull() {
            addCriterion("expediting_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeEqualTo(String value) {
            addCriterion("expediting_time =", value, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeNotEqualTo(String value) {
            addCriterion("expediting_time <>", value, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeGreaterThan(String value) {
            addCriterion("expediting_time >", value, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("expediting_time >=", value, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeLessThan(String value) {
            addCriterion("expediting_time <", value, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeLessThanOrEqualTo(String value) {
            addCriterion("expediting_time <=", value, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeLike(String value) {
            addCriterion("expediting_time like", value, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeNotLike(String value) {
            addCriterion("expediting_time not like", value, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeIn(List<String> values) {
            addCriterion("expediting_time in", values, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeNotIn(List<String> values) {
            addCriterion("expediting_time not in", values, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeBetween(String value1, String value2) {
            addCriterion("expediting_time between", value1, value2, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingTimeNotBetween(String value1, String value2) {
            addCriterion("expediting_time not between", value1, value2, "expeditingTime");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumIsNull() {
            addCriterion("expediting_num is null");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumIsNotNull() {
            addCriterion("expediting_num is not null");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumEqualTo(Integer value) {
            addCriterion("expediting_num =", value, "expeditingNum");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumNotEqualTo(Integer value) {
            addCriterion("expediting_num <>", value, "expeditingNum");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumGreaterThan(Integer value) {
            addCriterion("expediting_num >", value, "expeditingNum");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("expediting_num >=", value, "expeditingNum");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumLessThan(Integer value) {
            addCriterion("expediting_num <", value, "expeditingNum");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumLessThanOrEqualTo(Integer value) {
            addCriterion("expediting_num <=", value, "expeditingNum");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumIn(List<Integer> values) {
            addCriterion("expediting_num in", values, "expeditingNum");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumNotIn(List<Integer> values) {
            addCriterion("expediting_num not in", values, "expeditingNum");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumBetween(Integer value1, Integer value2) {
            addCriterion("expediting_num between", value1, value2, "expeditingNum");
            return (Criteria) this;
        }

        public Criteria andExpeditingNumNotBetween(Integer value1, Integer value2) {
            addCriterion("expediting_num not between", value1, value2, "expeditingNum");
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

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Integer value) {
            addCriterion("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Integer value) {
            addCriterion("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Integer value) {
            addCriterion("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Integer value) {
            addCriterion("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Integer value) {
            addCriterion("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Integer> values) {
            addCriterion("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Integer> values) {
            addCriterion("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Integer value1, Integer value2) {
            addCriterion("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Integer value1, Integer value2) {
            addCriterion("day not between", value1, value2, "day");
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

        public Criteria andPartProcessIdIsNull() {
            addCriterion("part_process_id is null");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdIsNotNull() {
            addCriterion("part_process_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdEqualTo(Long value) {
            addCriterion("part_process_id =", value, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdNotEqualTo(Long value) {
            addCriterion("part_process_id <>", value, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdGreaterThan(Long value) {
            addCriterion("part_process_id >", value, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("part_process_id >=", value, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdLessThan(Long value) {
            addCriterion("part_process_id <", value, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("part_process_id <=", value, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdIn(List<Long> values) {
            addCriterion("part_process_id in", values, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdNotIn(List<Long> values) {
            addCriterion("part_process_id not in", values, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdBetween(Long value1, Long value2) {
            addCriterion("part_process_id between", value1, value2, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andPartProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("part_process_id not between", value1, value2, "partProcessId");
            return (Criteria) this;
        }

        public Criteria andModeIdIsNull() {
            addCriterion("mode_id is null");
            return (Criteria) this;
        }

        public Criteria andModeIdIsNotNull() {
            addCriterion("mode_id is not null");
            return (Criteria) this;
        }

        public Criteria andModeIdEqualTo(Long value) {
            addCriterion("mode_id =", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotEqualTo(Long value) {
            addCriterion("mode_id <>", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdGreaterThan(Long value) {
            addCriterion("mode_id >", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mode_id >=", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLessThan(Long value) {
            addCriterion("mode_id <", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLessThanOrEqualTo(Long value) {
            addCriterion("mode_id <=", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdIn(List<Long> values) {
            addCriterion("mode_id in", values, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotIn(List<Long> values) {
            addCriterion("mode_id not in", values, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdBetween(Long value1, Long value2) {
            addCriterion("mode_id between", value1, value2, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotBetween(Long value1, Long value2) {
            addCriterion("mode_id not between", value1, value2, "modeId");
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

        public Criteria andOutIdIsNull() {
            addCriterion("out_id is null");
            return (Criteria) this;
        }

        public Criteria andOutIdIsNotNull() {
            addCriterion("out_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutIdEqualTo(Long value) {
            addCriterion("out_id =", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotEqualTo(Long value) {
            addCriterion("out_id <>", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdGreaterThan(Long value) {
            addCriterion("out_id >", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdGreaterThanOrEqualTo(Long value) {
            addCriterion("out_id >=", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLessThan(Long value) {
            addCriterion("out_id <", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLessThanOrEqualTo(Long value) {
            addCriterion("out_id <=", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdIn(List<Long> values) {
            addCriterion("out_id in", values, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotIn(List<Long> values) {
            addCriterion("out_id not in", values, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdBetween(Long value1, Long value2) {
            addCriterion("out_id between", value1, value2, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotBetween(Long value1, Long value2) {
            addCriterion("out_id not between", value1, value2, "outId");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andWayIsNull() {
            addCriterion("way is null");
            return (Criteria) this;
        }

        public Criteria andWayIsNotNull() {
            addCriterion("way is not null");
            return (Criteria) this;
        }

        public Criteria andWayEqualTo(String value) {
            addCriterion("way =", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotEqualTo(String value) {
            addCriterion("way <>", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayGreaterThan(String value) {
            addCriterion("way >", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayGreaterThanOrEqualTo(String value) {
            addCriterion("way >=", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayLessThan(String value) {
            addCriterion("way <", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayLessThanOrEqualTo(String value) {
            addCriterion("way <=", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayLike(String value) {
            addCriterion("way like", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotLike(String value) {
            addCriterion("way not like", value, "way");
            return (Criteria) this;
        }

        public Criteria andWayIn(List<String> values) {
            addCriterion("way in", values, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotIn(List<String> values) {
            addCriterion("way not in", values, "way");
            return (Criteria) this;
        }

        public Criteria andWayBetween(String value1, String value2) {
            addCriterion("way between", value1, value2, "way");
            return (Criteria) this;
        }

        public Criteria andWayNotBetween(String value1, String value2) {
            addCriterion("way not between", value1, value2, "way");
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

        public Criteria andOutPersonIsNull() {
            addCriterion("out_person is null");
            return (Criteria) this;
        }

        public Criteria andOutPersonIsNotNull() {
            addCriterion("out_person is not null");
            return (Criteria) this;
        }

        public Criteria andOutPersonEqualTo(String value) {
            addCriterion("out_person =", value, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonNotEqualTo(String value) {
            addCriterion("out_person <>", value, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonGreaterThan(String value) {
            addCriterion("out_person >", value, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonGreaterThanOrEqualTo(String value) {
            addCriterion("out_person >=", value, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonLessThan(String value) {
            addCriterion("out_person <", value, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonLessThanOrEqualTo(String value) {
            addCriterion("out_person <=", value, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonLike(String value) {
            addCriterion("out_person like", value, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonNotLike(String value) {
            addCriterion("out_person not like", value, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonIn(List<String> values) {
            addCriterion("out_person in", values, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonNotIn(List<String> values) {
            addCriterion("out_person not in", values, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonBetween(String value1, String value2) {
            addCriterion("out_person between", value1, value2, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutPersonNotBetween(String value1, String value2) {
            addCriterion("out_person not between", value1, value2, "outPerson");
            return (Criteria) this;
        }

        public Criteria andOutNameIsNull() {
            addCriterion("out_name is null");
            return (Criteria) this;
        }

        public Criteria andOutNameIsNotNull() {
            addCriterion("out_name is not null");
            return (Criteria) this;
        }

        public Criteria andOutNameEqualTo(String value) {
            addCriterion("out_name =", value, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameNotEqualTo(String value) {
            addCriterion("out_name <>", value, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameGreaterThan(String value) {
            addCriterion("out_name >", value, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameGreaterThanOrEqualTo(String value) {
            addCriterion("out_name >=", value, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameLessThan(String value) {
            addCriterion("out_name <", value, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameLessThanOrEqualTo(String value) {
            addCriterion("out_name <=", value, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameLike(String value) {
            addCriterion("out_name like", value, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameNotLike(String value) {
            addCriterion("out_name not like", value, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameIn(List<String> values) {
            addCriterion("out_name in", values, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameNotIn(List<String> values) {
            addCriterion("out_name not in", values, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameBetween(String value1, String value2) {
            addCriterion("out_name between", value1, value2, "outName");
            return (Criteria) this;
        }

        public Criteria andOutNameNotBetween(String value1, String value2) {
            addCriterion("out_name not between", value1, value2, "outName");
            return (Criteria) this;
        }

        public Criteria andOutTelIsNull() {
            addCriterion("out_tel is null");
            return (Criteria) this;
        }

        public Criteria andOutTelIsNotNull() {
            addCriterion("out_tel is not null");
            return (Criteria) this;
        }

        public Criteria andOutTelEqualTo(String value) {
            addCriterion("out_tel =", value, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelNotEqualTo(String value) {
            addCriterion("out_tel <>", value, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelGreaterThan(String value) {
            addCriterion("out_tel >", value, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelGreaterThanOrEqualTo(String value) {
            addCriterion("out_tel >=", value, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelLessThan(String value) {
            addCriterion("out_tel <", value, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelLessThanOrEqualTo(String value) {
            addCriterion("out_tel <=", value, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelLike(String value) {
            addCriterion("out_tel like", value, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelNotLike(String value) {
            addCriterion("out_tel not like", value, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelIn(List<String> values) {
            addCriterion("out_tel in", values, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelNotIn(List<String> values) {
            addCriterion("out_tel not in", values, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelBetween(String value1, String value2) {
            addCriterion("out_tel between", value1, value2, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutTelNotBetween(String value1, String value2) {
            addCriterion("out_tel not between", value1, value2, "outTel");
            return (Criteria) this;
        }

        public Criteria andOutAddressIsNull() {
            addCriterion("out_address is null");
            return (Criteria) this;
        }

        public Criteria andOutAddressIsNotNull() {
            addCriterion("out_address is not null");
            return (Criteria) this;
        }

        public Criteria andOutAddressEqualTo(String value) {
            addCriterion("out_address =", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressNotEqualTo(String value) {
            addCriterion("out_address <>", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressGreaterThan(String value) {
            addCriterion("out_address >", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressGreaterThanOrEqualTo(String value) {
            addCriterion("out_address >=", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressLessThan(String value) {
            addCriterion("out_address <", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressLessThanOrEqualTo(String value) {
            addCriterion("out_address <=", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressLike(String value) {
            addCriterion("out_address like", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressNotLike(String value) {
            addCriterion("out_address not like", value, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressIn(List<String> values) {
            addCriterion("out_address in", values, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressNotIn(List<String> values) {
            addCriterion("out_address not in", values, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressBetween(String value1, String value2) {
            addCriterion("out_address between", value1, value2, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutAddressNotBetween(String value1, String value2) {
            addCriterion("out_address not between", value1, value2, "outAddress");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(String value) {
            addCriterion("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(String value) {
            addCriterion("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(String value) {
            addCriterion("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(String value) {
            addCriterion("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(String value) {
            addCriterion("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(String value) {
            addCriterion("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLike(String value) {
            addCriterion("out_time like", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotLike(String value) {
            addCriterion("out_time not like", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<String> values) {
            addCriterion("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<String> values) {
            addCriterion("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(String value1, String value2) {
            addCriterion("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(String value1, String value2) {
            addCriterion("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusIsNull() {
            addCriterion("repertory_status is null");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusIsNotNull() {
            addCriterion("repertory_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusEqualTo(Integer value) {
            addCriterion("repertory_status =", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusNotEqualTo(Integer value) {
            addCriterion("repertory_status <>", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusGreaterThan(Integer value) {
            addCriterion("repertory_status >", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("repertory_status >=", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusLessThan(Integer value) {
            addCriterion("repertory_status <", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusLessThanOrEqualTo(Integer value) {
            addCriterion("repertory_status <=", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusIn(List<Integer> values) {
            addCriterion("repertory_status in", values, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusNotIn(List<Integer> values) {
            addCriterion("repertory_status not in", values, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusBetween(Integer value1, Integer value2) {
            addCriterion("repertory_status between", value1, value2, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("repertory_status not between", value1, value2, "repertoryStatus");
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