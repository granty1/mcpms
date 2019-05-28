package com.mcpms.mcpms.system.pojo.out;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MProductPartRepertoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MProductPartRepertoryExample() {
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

        public Criteria andCinvcodeIsNull() {
            addCriterion("cinvcode is null");
            return (Criteria) this;
        }

        public Criteria andCinvcodeIsNotNull() {
            addCriterion("cinvcode is not null");
            return (Criteria) this;
        }

        public Criteria andCinvcodeEqualTo(String value) {
            addCriterion("cinvcode =", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotEqualTo(String value) {
            addCriterion("cinvcode <>", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeGreaterThan(String value) {
            addCriterion("cinvcode >", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeGreaterThanOrEqualTo(String value) {
            addCriterion("cinvcode >=", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeLessThan(String value) {
            addCriterion("cinvcode <", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeLessThanOrEqualTo(String value) {
            addCriterion("cinvcode <=", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeLike(String value) {
            addCriterion("cinvcode like", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotLike(String value) {
            addCriterion("cinvcode not like", value, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeIn(List<String> values) {
            addCriterion("cinvcode in", values, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotIn(List<String> values) {
            addCriterion("cinvcode not in", values, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeBetween(String value1, String value2) {
            addCriterion("cinvcode between", value1, value2, "cinvcode");
            return (Criteria) this;
        }

        public Criteria andCinvcodeNotBetween(String value1, String value2) {
            addCriterion("cinvcode not between", value1, value2, "cinvcode");
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

        public Criteria andReTimeIsNull() {
            addCriterion("re_time is null");
            return (Criteria) this;
        }

        public Criteria andReTimeIsNotNull() {
            addCriterion("re_time is not null");
            return (Criteria) this;
        }

        public Criteria andReTimeEqualTo(String value) {
            addCriterion("re_time =", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeNotEqualTo(String value) {
            addCriterion("re_time <>", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeGreaterThan(String value) {
            addCriterion("re_time >", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeGreaterThanOrEqualTo(String value) {
            addCriterion("re_time >=", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeLessThan(String value) {
            addCriterion("re_time <", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeLessThanOrEqualTo(String value) {
            addCriterion("re_time <=", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeLike(String value) {
            addCriterion("re_time like", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeNotLike(String value) {
            addCriterion("re_time not like", value, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeIn(List<String> values) {
            addCriterion("re_time in", values, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeNotIn(List<String> values) {
            addCriterion("re_time not in", values, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeBetween(String value1, String value2) {
            addCriterion("re_time between", value1, value2, "reTime");
            return (Criteria) this;
        }

        public Criteria andReTimeNotBetween(String value1, String value2) {
            addCriterion("re_time not between", value1, value2, "reTime");
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