package com.mcpms.mcpms.newplan.pojo.produce;

import java.math.BigDecimal;

public class VPartPlanProcess {
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

    private Long processId;

    private String way;

    private String outName;

    private String statusName;

    private String processName;

    private String partNum;

    private String unit;

    private String specType;

    private Integer num;

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

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way == null ? null : way.trim();
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName == null ? null : outName.trim();
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum == null ? null : partNum.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getSpecType() {
        return specType;
    }

    public void setSpecType(String specType) {
        this.specType = specType == null ? null : specType.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}