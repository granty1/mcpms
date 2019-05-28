package com.mcpms.mcpms.newplan.pojo.produce;

import java.math.BigDecimal;

public class VPartPlan {
    private Long partId;

    private String partNum;

    private String partName;

    private String drawingNum;

    private String unit;

    private Long id;

    private String runNum;

    private Integer num;

    private BigDecimal price;

    private Long currentProcessId;

    private String planFinishTime;

    private String actualFinishTime;

    private String remarks;

    private Long planStatus;

    private String createTime;

    private Long isWarning;

    private String currentProcessName;

    private String statusName;

    private String specType;

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum == null ? null : partNum.trim();
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName == null ? null : partName.trim();
    }

    public String getDrawingNum() {
        return drawingNum;
    }

    public void setDrawingNum(String drawingNum) {
        this.drawingNum = drawingNum == null ? null : drawingNum.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRunNum() {
        return runNum;
    }

    public void setRunNum(String runNum) {
        this.runNum = runNum == null ? null : runNum.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCurrentProcessId() {
        return currentProcessId;
    }

    public void setCurrentProcessId(Long currentProcessId) {
        this.currentProcessId = currentProcessId;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Long getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Long planStatus) {
        this.planStatus = planStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Long getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(Long isWarning) {
        this.isWarning = isWarning;
    }

    public String getCurrentProcessName() {
        return currentProcessName;
    }

    public void setCurrentProcessName(String currentProcessName) {
        this.currentProcessName = currentProcessName == null ? null : currentProcessName.trim();
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }

    public String getSpecType() {
        return specType;
    }

    public void setSpecType(String specType) {
        this.specType = specType == null ? null : specType.trim();
    }
}