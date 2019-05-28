package com.mcpms.mcpms.system.pojo.produce;

import java.math.BigDecimal;

public class MProductPartProcessPlan {
    private Long id;

    private Long orderProductPartId;

    private Long partProcessId;

    private Long modeId;

    private Integer day;

    private String planTime;

    private String actualTime;

    private String inTime;

    private String drawingNum;

    private BigDecimal price;

    private Long outId;

    private String outTime;

    private String deliverTime;

    private String remarks;

    private Integer status;

    private Integer approveStatus;

    private String approvePeople;

    private String approveTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderProductPartId() {
        return orderProductPartId;
    }

    public void setOrderProductPartId(Long orderProductPartId) {
        this.orderProductPartId = orderProductPartId;
    }

    public Long getPartProcessId() {
        return partProcessId;
    }

    public void setPartProcessId(Long partProcessId) {
        this.partProcessId = partProcessId;
    }

    public Long getModeId() {
        return modeId;
    }

    public void setModeId(Long modeId) {
        this.modeId = modeId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
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

    public String getDrawingNum() {
        return drawingNum;
    }

    public void setDrawingNum(String drawingNum) {
        this.drawingNum = drawingNum == null ? null : drawingNum.trim();
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

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime == null ? null : outTime.trim();
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(String deliverTime) {
        this.deliverTime = deliverTime == null ? null : deliverTime.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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