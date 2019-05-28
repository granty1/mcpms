package com.mcpms.mcpms.newplan.pojo.produce;

import java.math.BigDecimal;

public class NewMPartPlan {
    private Long id;

    private String runNum;

    private Long partId;

    private Integer num;

    private BigDecimal price;

    private Long currentProcessId;

    private String planFinishTime;

    private String actualFinishTime;

    private String remarks;

    private Long planStatus;

    private String createTime;

    private Long isWarning;

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

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
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
}