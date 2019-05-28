package com.mcpms.mcpms.newplan.pojo.produce;

import java.math.BigDecimal;

public class NewMPartPlanProcess {
    private Long id;

    private Long partPlanId;

    private Long partProcessId;

    private Long processModeId;

    private String partDrawingNum;

    private String turnOutTime;

    private String planFinishTime;

    private String actualFinishTime;

    private Integer days;

    private BigDecimal price;

    private Long outId;

    private String remarks;

    private Long planProcessStatus;

    private Integer doSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPartPlanId() {
        return partPlanId;
    }

    public void setPartPlanId(Long partPlanId) {
        this.partPlanId = partPlanId;
    }

    public Long getPartProcessId() {
        return partProcessId;
    }

    public void setPartProcessId(Long partProcessId) {
        this.partProcessId = partProcessId;
    }

    public Long getProcessModeId() {
        return processModeId;
    }

    public void setProcessModeId(Long processModeId) {
        this.processModeId = processModeId;
    }

    public String getPartDrawingNum() {
        return partDrawingNum;
    }

    public void setPartDrawingNum(String partDrawingNum) {
        this.partDrawingNum = partDrawingNum == null ? null : partDrawingNum.trim();
    }

    public String getTurnOutTime() {
        return turnOutTime;
    }

    public void setTurnOutTime(String turnOutTime) {
        this.turnOutTime = turnOutTime == null ? null : turnOutTime.trim();
    }

    public String getPlanFinishTime() {
        return planFinishTime;
    }

    public void setPlanFinishTime(String planFinishTime) {
        this.planFinishTime = planFinishTime == null ? null : planFinishTime.trim();
    }

    public String getActualFinishTime() {
        return actualFinishTime;
    }

    public void setActualFinishTime(String actualFinishTime) {
        this.actualFinishTime = actualFinishTime == null ? null : actualFinishTime.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getOutId() {
        return outId;
    }

    public void setOutId(Long outId) {
        this.outId = outId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Long getPlanProcessStatus() {
        return planProcessStatus;
    }

    public void setPlanProcessStatus(Long planProcessStatus) {
        this.planProcessStatus = planProcessStatus;
    }

    public Integer getDoSort() {
        return doSort;
    }

    public void setDoSort(Integer doSort) {
        this.doSort = doSort;
    }
}