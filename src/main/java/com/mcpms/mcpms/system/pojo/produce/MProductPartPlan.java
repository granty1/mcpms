package com.mcpms.mcpms.system.pojo.produce;

import java.math.BigDecimal;

public class MProductPartPlan {
    private Long id;

    private String batch;

    private String runningNum;

    private Long orderProductPartId;

    private Integer num;

    private Integer actualNum;

    private BigDecimal price;

    private Long modeId;

    private Long outId;

    private String planTime;

    private String actualTime;

    private String inTime;

    private Integer isInsert;

    private String text;

    private Integer status;

    private String producer;

    private String createTime;

    private Integer approveStatus;

    private String approvePeople;

    private String approveTime;

    public MProductPartPlan() {
        this.actualNum = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public String getRunningNum() {
        return runningNum;
    }

    public void setRunningNum(String runningNum) {
        this.runningNum = runningNum == null ? null : runningNum.trim();
    }

    public Long getOrderProductPartId() {
        return orderProductPartId;
    }

    public void setOrderProductPartId(Long orderProductPartId) {
        this.orderProductPartId = orderProductPartId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getActualNum() {
        return actualNum;
    }

    public void setActualNum(Integer actualNum) {
        this.actualNum = actualNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getModeId() {
        return modeId;
    }

    public void setModeId(Long modeId) {
        this.modeId = modeId;
    }

    public Long getOutId() {
        return outId;
    }

    public void setOutId(Long outId) {
        this.outId = outId;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime == null ? null : planTime.trim();
    }

    public String getActualTime() {
        return actualTime;
    }

    public void setActualTime(String actualTime) {
        this.actualTime = actualTime == null ? null : actualTime.trim();
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime == null ? null : inTime.trim();
    }

    public Integer getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(Integer isInsert) {
        this.isInsert = isInsert;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer == null ? null : producer.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getApprovePeople() {
        return approvePeople;
    }

    public void setApprovePeople(String approvePeople) {
        this.approvePeople = approvePeople == null ? null : approvePeople.trim();
    }

    public String getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(String approveTime) {
        this.approveTime = approveTime == null ? null : approveTime.trim();
    }
}