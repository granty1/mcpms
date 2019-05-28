package com.mcpms.mcpms.newplan.pojo.produce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NewMPartPlanProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewMPartPlanProcessExample() {
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

        public Criteria andPartPlanIdIsNull() {
            addCriterion("part_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdIsNotNull() {
            addCriterion("part_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdEqualTo(Long value) {
            addCriterion("part_plan_id =", value, "partPlanId");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdNotEqualTo(Long value) {
            addCriterion("part_plan_id <>", value, "partPlanId");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdGreaterThan(Long value) {
            addCriterion("part_plan_id >", value, "partPlanId");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("part_plan_id >=", value, "partPlanId");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdLessThan(Long value) {
            addCriterion("part_plan_id <", value, "partPlanId");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("part_plan_id <=", value, "partPlanId");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdIn(List<Long> values) {
            addCriterion("part_plan_id in", values, "partPlanId");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdNotIn(List<Long> values) {
            addCriterion("part_plan_id not in", values, "partPlanId");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdBetween(Long value1, Long value2) {
            addCriterion("part_plan_id between", value1, value2, "partPlanId");
            return (Criteria) this;
        }

        public Criteria andPartPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("part_plan_id not between", value1, value2, "partPlanId");
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

        public Criteria andProcessModeIdIsNull() {
            addCriterion("process_mode_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdIsNotNull() {
            addCriterion("process_mode_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdEqualTo(Long value) {
            addCriterion("process_mode_id =", value, "processModeId");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdNotEqualTo(Long value) {
            addCriterion("process_mode_id <>", value, "processModeId");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdGreaterThan(Long value) {
            addCriterion("process_mode_id >", value, "processModeId");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("process_mode_id >=", value, "processModeId");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdLessThan(Long value) {
            addCriterion("process_mode_id <", value, "processModeId");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdLessThanOrEqualTo(Long value) {
            addCriterion("process_mode_id <=", value, "processModeId");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdIn(List<Long> values) {
            addCriterion("process_mode_id in", values, "processModeId");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdNotIn(List<Long> values) {
            addCriterion("process_mode_id not in", values, "processModeId");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdBetween(Long value1, Long value2) {
            addCriterion("process_mode_id between", value1, value2, "processModeId");
            return (Criteria) this;
        }

        public Criteria andProcessModeIdNotBetween(Long value1, Long value2) {
            addCriterion("process_mode_id not between", value1, value2, "processModeId");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumIsNull() {
            addCriterion("part_drawing_num is null");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumIsNotNull() {
            addCriterion("part_drawing_num is not null");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumEqualTo(String value) {
            addCriterion("part_drawing_num =", value, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumNotEqualTo(String value) {
            addCriterion("part_drawing_num <>", value, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumGreaterThan(String value) {
            addCriterion("part_drawing_num >", value, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumGreaterThanOrEqualTo(String value) {
            addCriterion("part_drawing_num >=", value, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumLessThan(String value) {
            addCriterion("part_drawing_num <", value, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumLessThanOrEqualTo(String value) {
            addCriterion("part_drawing_num <=", value, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumLike(String value) {
            addCriterion("part_drawing_num like", value, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumNotLike(String value) {
            addCriterion("part_drawing_num not like", value, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumIn(List<String> values) {
            addCriterion("part_drawing_num in", values, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumNotIn(List<String> values) {
            addCriterion("part_drawing_num not in", values, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumBetween(String value1, String value2) {
            addCriterion("part_drawing_num between", value1, value2, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andPartDrawingNumNotBetween(String value1, String value2) {
            addCriterion("part_drawing_num not between", value1, value2, "partDrawingNum");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeIsNull() {
            addCriterion("turn_out_time is null");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeIsNotNull() {
            addCriterion("turn_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeEqualTo(String value) {
            addCriterion("turn_out_time =", value, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeNotEqualTo(String value) {
            addCriterion("turn_out_time <>", value, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeGreaterThan(String value) {
            addCriterion("turn_out_time >", value, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeGreaterThanOrEqualTo(String value) {
            addCriterion("turn_out_time >=", value, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeLessThan(String value) {
            addCriterion("turn_out_time <", value, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeLessThanOrEqualTo(String value) {
            addCriterion("turn_out_time <=", value, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeLike(String value) {
            addCriterion("turn_out_time like", value, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeNotLike(String value) {
            addCriterion("turn_out_time not like", value, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeIn(List<String> values) {
            addCriterion("turn_out_time in", values, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeNotIn(List<String> values) {
            addCriterion("turn_out_time not in", values, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeBetween(String value1, String value2) {
            addCriterion("turn_out_time between", value1, value2, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andTurnOutTimeNotBetween(String value1, String value2) {
            addCriterion("turn_out_time not between", value1, value2, "turnOutTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeIsNull() {
            addCriterion("plan_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeIsNotNull() {
            addCriterion("plan_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeEqualTo(String value) {
            addCriterion("plan_finish_time =", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotEqualTo(String value) {
            addCriterion("plan_finish_time <>", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeGreaterThan(String value) {
            addCriterion("plan_finish_time >", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_finish_time >=", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeLessThan(String value) {
            addCriterion("plan_finish_time <", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeLessThanOrEqualTo(String value) {
            addCriterion("plan_finish_time <=", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeLike(String value) {
            addCriterion("plan_finish_time like", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotLike(String value) {
            addCriterion("plan_finish_time not like", value, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeIn(List<String> values) {
            addCriterion("plan_finish_time in", values, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotIn(List<String> values) {
            addCriterion("plan_finish_time not in", values, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeBetween(String value1, String value2) {
            addCriterion("plan_finish_time between", value1, value2, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andPlanFinishTimeNotBetween(String value1, String value2) {
            addCriterion("plan_finish_time not between", value1, value2, "planFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeIsNull() {
            addCriterion("actual_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeIsNotNull() {
            addCriterion("actual_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeEqualTo(String value) {
            addCriterion("actual_finish_time =", value, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeNotEqualTo(String value) {
            addCriterion("actual_finish_time <>", value, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeGreaterThan(String value) {
            addCriterion("actual_finish_time >", value, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("actual_finish_time >=", value, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeLessThan(String value) {
            addCriterion("actual_finish_time <", value, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeLessThanOrEqualTo(String value) {
            addCriterion("actual_finish_time <=", value, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeLike(String value) {
            addCriterion("actual_finish_time like", value, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeNotLike(String value) {
            addCriterion("actual_finish_time not like", value, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeIn(List<String> values) {
            addCriterion("actual_finish_time in", values, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeNotIn(List<String> values) {
            addCriterion("actual_finish_time not in", values, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeBetween(String value1, String value2) {
            addCriterion("actual_finish_time between", value1, value2, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andActualFinishTimeNotBetween(String value1, String value2) {
            addCriterion("actual_finish_time not between", value1, value2, "actualFinishTime");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
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

        public Criteria andPlanProcessStatusIsNull() {
            addCriterion("plan_process_status is null");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusIsNotNull() {
            addCriterion("plan_process_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusEqualTo(Long value) {
            addCriterion("plan_process_status =", value, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusNotEqualTo(Long value) {
            addCriterion("plan_process_status <>", value, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusGreaterThan(Long value) {
            addCriterion("plan_process_status >", value, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_process_status >=", value, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusLessThan(Long value) {
            addCriterion("plan_process_status <", value, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusLessThanOrEqualTo(Long value) {
            addCriterion("plan_process_status <=", value, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusIn(List<Long> values) {
            addCriterion("plan_process_status in", values, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusNotIn(List<Long> values) {
            addCriterion("plan_process_status not in", values, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusBetween(Long value1, Long value2) {
            addCriterion("plan_process_status between", value1, value2, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andPlanProcessStatusNotBetween(Long value1, Long value2) {
            addCriterion("plan_process_status not between", value1, value2, "planProcessStatus");
            return (Criteria) this;
        }

        public Criteria andDoSortIsNull() {
            addCriterion("do_sort is null");
            return (Criteria) this;
        }

        public Criteria andDoSortIsNotNull() {
            addCriterion("do_sort is not null");
            return (Criteria) this;
        }

        public Criteria andDoSortEqualTo(Integer value) {
            addCriterion("do_sort =", value, "doSort");
            return (Criteria) this;
        }

        public Criteria andDoSortNotEqualTo(Integer value) {
            addCriterion("do_sort <>", value, "doSort");
            return (Criteria) this;
        }

        public Criteria andDoSortGreaterThan(Integer value) {
            addCriterion("do_sort >", value, "doSort");
            return (Criteria) this;
        }

        public Criteria andDoSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("do_sort >=", value, "doSort");
            return (Criteria) this;
        }

        public Criteria andDoSortLessThan(Integer value) {
            addCriterion("do_sort <", value, "doSort");
            return (Criteria) this;
        }

        public Criteria andDoSortLessThanOrEqualTo(Integer value) {
            addCriterion("do_sort <=", value, "doSort");
            return (Criteria) this;
        }

        public Criteria andDoSortIn(List<Integer> values) {
            addCriterion("do_sort in", values, "doSort");
            return (Criteria) this;
        }

        public Criteria andDoSortNotIn(List<Integer> values) {
            addCriterion("do_sort not in", values, "doSort");
            return (Criteria) this;
        }

        public Criteria andDoSortBetween(Integer value1, Integer value2) {
            addCriterion("do_sort between", value1, value2, "doSort");
            return (Criteria) this;
        }

        public Criteria andDoSortNotBetween(Integer value1, Integer value2) {
            addCriterion("do_sort not between", value1, value2, "doSort");
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