package com.mcpms.mcpms.newplan.pojo.produce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VPartPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VPartPlanExample() {
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

        public Criteria andPartNumIsNull() {
            addCriterion("part_num is null");
            return (Criteria) this;
        }

        public Criteria andPartNumIsNotNull() {
            addCriterion("part_num is not null");
            return (Criteria) this;
        }

        public Criteria andPartNumEqualTo(String value) {
            addCriterion("part_num =", value, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumNotEqualTo(String value) {
            addCriterion("part_num <>", value, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumGreaterThan(String value) {
            addCriterion("part_num >", value, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumGreaterThanOrEqualTo(String value) {
            addCriterion("part_num >=", value, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumLessThan(String value) {
            addCriterion("part_num <", value, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumLessThanOrEqualTo(String value) {
            addCriterion("part_num <=", value, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumLike(String value) {
            addCriterion("part_num like", value, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumNotLike(String value) {
            addCriterion("part_num not like", value, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumIn(List<String> values) {
            addCriterion("part_num in", values, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumNotIn(List<String> values) {
            addCriterion("part_num not in", values, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumBetween(String value1, String value2) {
            addCriterion("part_num between", value1, value2, "partNum");
            return (Criteria) this;
        }

        public Criteria andPartNumNotBetween(String value1, String value2) {
            addCriterion("part_num not between", value1, value2, "partNum");
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

        public Criteria andRunNumIsNull() {
            addCriterion("run_num is null");
            return (Criteria) this;
        }

        public Criteria andRunNumIsNotNull() {
            addCriterion("run_num is not null");
            return (Criteria) this;
        }

        public Criteria andRunNumEqualTo(String value) {
            addCriterion("run_num =", value, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumNotEqualTo(String value) {
            addCriterion("run_num <>", value, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumGreaterThan(String value) {
            addCriterion("run_num >", value, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumGreaterThanOrEqualTo(String value) {
            addCriterion("run_num >=", value, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumLessThan(String value) {
            addCriterion("run_num <", value, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumLessThanOrEqualTo(String value) {
            addCriterion("run_num <=", value, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumLike(String value) {
            addCriterion("run_num like", value, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumNotLike(String value) {
            addCriterion("run_num not like", value, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumIn(List<String> values) {
            addCriterion("run_num in", values, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumNotIn(List<String> values) {
            addCriterion("run_num not in", values, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumBetween(String value1, String value2) {
            addCriterion("run_num between", value1, value2, "runNum");
            return (Criteria) this;
        }

        public Criteria andRunNumNotBetween(String value1, String value2) {
            addCriterion("run_num not between", value1, value2, "runNum");
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

        public Criteria andCurrentProcessIdIsNull() {
            addCriterion("current_process_id is null");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdIsNotNull() {
            addCriterion("current_process_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdEqualTo(Long value) {
            addCriterion("current_process_id =", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdNotEqualTo(Long value) {
            addCriterion("current_process_id <>", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdGreaterThan(Long value) {
            addCriterion("current_process_id >", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("current_process_id >=", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdLessThan(Long value) {
            addCriterion("current_process_id <", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("current_process_id <=", value, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdIn(List<Long> values) {
            addCriterion("current_process_id in", values, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdNotIn(List<Long> values) {
            addCriterion("current_process_id not in", values, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdBetween(Long value1, Long value2) {
            addCriterion("current_process_id between", value1, value2, "currentProcessId");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("current_process_id not between", value1, value2, "currentProcessId");
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

        public Criteria andPlanStatusIsNull() {
            addCriterion("plan_status is null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIsNotNull() {
            addCriterion("plan_status is not null");
            return (Criteria) this;
        }

        public Criteria andPlanStatusEqualTo(Long value) {
            addCriterion("plan_status =", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotEqualTo(Long value) {
            addCriterion("plan_status <>", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThan(Long value) {
            addCriterion("plan_status >", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_status >=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThan(Long value) {
            addCriterion("plan_status <", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusLessThanOrEqualTo(Long value) {
            addCriterion("plan_status <=", value, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusIn(List<Long> values) {
            addCriterion("plan_status in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotIn(List<Long> values) {
            addCriterion("plan_status not in", values, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusBetween(Long value1, Long value2) {
            addCriterion("plan_status between", value1, value2, "planStatus");
            return (Criteria) this;
        }

        public Criteria andPlanStatusNotBetween(Long value1, Long value2) {
            addCriterion("plan_status not between", value1, value2, "planStatus");
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

        public Criteria andIsWarningIsNull() {
            addCriterion("is_warning is null");
            return (Criteria) this;
        }

        public Criteria andIsWarningIsNotNull() {
            addCriterion("is_warning is not null");
            return (Criteria) this;
        }

        public Criteria andIsWarningEqualTo(Long value) {
            addCriterion("is_warning =", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningNotEqualTo(Long value) {
            addCriterion("is_warning <>", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningGreaterThan(Long value) {
            addCriterion("is_warning >", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningGreaterThanOrEqualTo(Long value) {
            addCriterion("is_warning >=", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningLessThan(Long value) {
            addCriterion("is_warning <", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningLessThanOrEqualTo(Long value) {
            addCriterion("is_warning <=", value, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningIn(List<Long> values) {
            addCriterion("is_warning in", values, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningNotIn(List<Long> values) {
            addCriterion("is_warning not in", values, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningBetween(Long value1, Long value2) {
            addCriterion("is_warning between", value1, value2, "isWarning");
            return (Criteria) this;
        }

        public Criteria andIsWarningNotBetween(Long value1, Long value2) {
            addCriterion("is_warning not between", value1, value2, "isWarning");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameIsNull() {
            addCriterion("current_process_name is null");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameIsNotNull() {
            addCriterion("current_process_name is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameEqualTo(String value) {
            addCriterion("current_process_name =", value, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameNotEqualTo(String value) {
            addCriterion("current_process_name <>", value, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameGreaterThan(String value) {
            addCriterion("current_process_name >", value, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("current_process_name >=", value, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameLessThan(String value) {
            addCriterion("current_process_name <", value, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameLessThanOrEqualTo(String value) {
            addCriterion("current_process_name <=", value, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameLike(String value) {
            addCriterion("current_process_name like", value, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameNotLike(String value) {
            addCriterion("current_process_name not like", value, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameIn(List<String> values) {
            addCriterion("current_process_name in", values, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameNotIn(List<String> values) {
            addCriterion("current_process_name not in", values, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameBetween(String value1, String value2) {
            addCriterion("current_process_name between", value1, value2, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andCurrentProcessNameNotBetween(String value1, String value2) {
            addCriterion("current_process_name not between", value1, value2, "currentProcessName");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNull() {
            addCriterion("status_name is null");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNotNull() {
            addCriterion("status_name is not null");
            return (Criteria) this;
        }

        public Criteria andStatusNameEqualTo(String value) {
            addCriterion("status_name =", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotEqualTo(String value) {
            addCriterion("status_name <>", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThan(String value) {
            addCriterion("status_name >", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("status_name >=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThan(String value) {
            addCriterion("status_name <", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThanOrEqualTo(String value) {
            addCriterion("status_name <=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLike(String value) {
            addCriterion("status_name like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotLike(String value) {
            addCriterion("status_name not like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameIn(List<String> values) {
            addCriterion("status_name in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotIn(List<String> values) {
            addCriterion("status_name not in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameBetween(String value1, String value2) {
            addCriterion("status_name between", value1, value2, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotBetween(String value1, String value2) {
            addCriterion("status_name not between", value1, value2, "statusName");
            return (Criteria) this;
        }

        public Criteria andSpecTypeIsNull() {
            addCriterion("spec_type is null");
            return (Criteria) this;
        }

        public Criteria andSpecTypeIsNotNull() {
            addCriterion("spec_type is not null");
            return (Criteria) this;
        }

        public Criteria andSpecTypeEqualTo(String value) {
            addCriterion("spec_type =", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeNotEqualTo(String value) {
            addCriterion("spec_type <>", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeGreaterThan(String value) {
            addCriterion("spec_type >", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeGreaterThanOrEqualTo(String value) {
            addCriterion("spec_type >=", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeLessThan(String value) {
            addCriterion("spec_type <", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeLessThanOrEqualTo(String value) {
            addCriterion("spec_type <=", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeLike(String value) {
            addCriterion("spec_type like", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeNotLike(String value) {
            addCriterion("spec_type not like", value, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeIn(List<String> values) {
            addCriterion("spec_type in", values, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeNotIn(List<String> values) {
            addCriterion("spec_type not in", values, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeBetween(String value1, String value2) {
            addCriterion("spec_type between", value1, value2, "specType");
            return (Criteria) this;
        }

        public Criteria andSpecTypeNotBetween(String value1, String value2) {
            addCriterion("spec_type not between", value1, value2, "specType");
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