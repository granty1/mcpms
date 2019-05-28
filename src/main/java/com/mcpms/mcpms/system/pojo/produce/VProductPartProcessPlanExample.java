package com.mcpms.mcpms.system.pojo.produce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VProductPartProcessPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VProductPartProcessPlanExample() {
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

        public Criteria andProcessNameIsNull() {
            addCriterion("process_name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("process_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("process_name =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("process_name <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("process_name >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("process_name >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("process_name <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("process_name <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("process_name like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("process_name not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("process_name in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("process_name not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("process_name between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("process_name not between", value1, value2, "processName");
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

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(Long value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(Long value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(Long value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(Long value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<Long> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<Long> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(Long value1, Long value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessSortIsNull() {
            addCriterion("process_sort is null");
            return (Criteria) this;
        }

        public Criteria andProcessSortIsNotNull() {
            addCriterion("process_sort is not null");
            return (Criteria) this;
        }

        public Criteria andProcessSortEqualTo(Integer value) {
            addCriterion("process_sort =", value, "processSort");
            return (Criteria) this;
        }

        public Criteria andProcessSortNotEqualTo(Integer value) {
            addCriterion("process_sort <>", value, "processSort");
            return (Criteria) this;
        }

        public Criteria andProcessSortGreaterThan(Integer value) {
            addCriterion("process_sort >", value, "processSort");
            return (Criteria) this;
        }

        public Criteria andProcessSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_sort >=", value, "processSort");
            return (Criteria) this;
        }

        public Criteria andProcessSortLessThan(Integer value) {
            addCriterion("process_sort <", value, "processSort");
            return (Criteria) this;
        }

        public Criteria andProcessSortLessThanOrEqualTo(Integer value) {
            addCriterion("process_sort <=", value, "processSort");
            return (Criteria) this;
        }

        public Criteria andProcessSortIn(List<Integer> values) {
            addCriterion("process_sort in", values, "processSort");
            return (Criteria) this;
        }

        public Criteria andProcessSortNotIn(List<Integer> values) {
            addCriterion("process_sort not in", values, "processSort");
            return (Criteria) this;
        }

        public Criteria andProcessSortBetween(Integer value1, Integer value2) {
            addCriterion("process_sort between", value1, value2, "processSort");
            return (Criteria) this;
        }

        public Criteria andProcessSortNotBetween(Integer value1, Integer value2) {
            addCriterion("process_sort not between", value1, value2, "processSort");
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

        public Criteria andPartsIdIsNull() {
            addCriterion("parts_id is null");
            return (Criteria) this;
        }

        public Criteria andPartsIdIsNotNull() {
            addCriterion("parts_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartsIdEqualTo(Long value) {
            addCriterion("parts_id =", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdNotEqualTo(Long value) {
            addCriterion("parts_id <>", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdGreaterThan(Long value) {
            addCriterion("parts_id >", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parts_id >=", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdLessThan(Long value) {
            addCriterion("parts_id <", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdLessThanOrEqualTo(Long value) {
            addCriterion("parts_id <=", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdIn(List<Long> values) {
            addCriterion("parts_id in", values, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdNotIn(List<Long> values) {
            addCriterion("parts_id not in", values, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdBetween(Long value1, Long value2) {
            addCriterion("parts_id between", value1, value2, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdNotBetween(Long value1, Long value2) {
            addCriterion("parts_id not between", value1, value2, "partsId");
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

        public Criteria andPartsNameIsNull() {
            addCriterion("parts_name is null");
            return (Criteria) this;
        }

        public Criteria andPartsNameIsNotNull() {
            addCriterion("parts_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartsNameEqualTo(String value) {
            addCriterion("parts_name =", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameNotEqualTo(String value) {
            addCriterion("parts_name <>", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameGreaterThan(String value) {
            addCriterion("parts_name >", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameGreaterThanOrEqualTo(String value) {
            addCriterion("parts_name >=", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameLessThan(String value) {
            addCriterion("parts_name <", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameLessThanOrEqualTo(String value) {
            addCriterion("parts_name <=", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameLike(String value) {
            addCriterion("parts_name like", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameNotLike(String value) {
            addCriterion("parts_name not like", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameIn(List<String> values) {
            addCriterion("parts_name in", values, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameNotIn(List<String> values) {
            addCriterion("parts_name not in", values, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameBetween(String value1, String value2) {
            addCriterion("parts_name between", value1, value2, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameNotBetween(String value1, String value2) {
            addCriterion("parts_name not between", value1, value2, "partsName");
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

        public Criteria andPlanStatusIsNull() {
            addCriterion("plan_status is null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNotNull() {
            addCriterion("plan_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusEqualTo(Integer value) {
            addCriterion("plan_status =", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotEqualTo(Integer value) {
            addCriterion("plan_status <>", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThan(Integer value) {
            addCriterion("plan_status >", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_status >=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThan(Integer value) {
            addCriterion("plan_status <", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThanOrEqualTo(Integer value) {
            addCriterion("plan_status <=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIn(List<Integer> values) {
            addCriterion("plan_status in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotIn(List<Integer> values) {
            addCriterion("plan_status not in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusBetween(Integer value1, Integer value2) {
            addCriterion("plan_status between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_status not between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusIsNull() {
            addCriterion("plan_approve_status is null");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusIsNotNull() {
            addCriterion("plan_approve_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusEqualTo(Integer value) {
            addCriterion("plan_approve_status =", value, "planApproveStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusNotEqualTo(Integer value) {
            addCriterion("plan_approve_status <>", value, "planApproveStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusGreaterThan(Integer value) {
            addCriterion("plan_approve_status >", value, "planApproveStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_approve_status >=", value, "planApproveStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusLessThan(Integer value) {
            addCriterion("plan_approve_status <", value, "planApproveStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusLessThanOrEqualTo(Integer value) {
            addCriterion("plan_approve_status <=", value, "planApproveStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusIn(List<Integer> values) {
            addCriterion("plan_approve_status in", values, "planApproveStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusNotIn(List<Integer> values) {
            addCriterion("plan_approve_status not in", values, "planApproveStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusBetween(Integer value1, Integer value2) {
            addCriterion("plan_approve_status between", value1, value2, "planApproveStatus");
            return (Criteria) this;
        }

        public Criteria andPlanApproveStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_approve_status not between", value1, value2, "planApproveStatus");
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

        public Criteria andRepertoryStatusIsNull() {
            addCriterion("repertory_status is null");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusIsNotNull() {
            addCriterion("repertory_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusEqualTo(Long value) {
            addCriterion("repertory_status =", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusNotEqualTo(Long value) {
            addCriterion("repertory_status <>", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusGreaterThan(Long value) {
            addCriterion("repertory_status >", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("repertory_status >=", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusLessThan(Long value) {
            addCriterion("repertory_status <", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusLessThanOrEqualTo(Long value) {
            addCriterion("repertory_status <=", value, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusIn(List<Long> values) {
            addCriterion("repertory_status in", values, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusNotIn(List<Long> values) {
            addCriterion("repertory_status not in", values, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusBetween(Long value1, Long value2) {
            addCriterion("repertory_status between", value1, value2, "repertoryStatus");
            return (Criteria) this;
        }

        public Criteria andRepertoryStatusNotBetween(Long value1, Long value2) {
            addCriterion("repertory_status not between", value1, value2, "repertoryStatus");
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