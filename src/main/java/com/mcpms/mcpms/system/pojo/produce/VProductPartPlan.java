package com.mcpms.mcpms.system.pojo.produce;

import java.math.BigDecimal;

public class VProductPartPlan {
    private Long id;

    private String batch;

    private String runningNum;

    private Long orderProductPartId;

    private Integer num;

    private BigDecimal price;

    private String planTime;

    private String actualTime;

    private String inTime;

    private String text;

    private String producer;

    private String createTime;

    private String approvePeople;

    private String approveTime;

    private String orderNum;

    private Long partId;

    private Long productId;

    private String partName;

    private String productName;

    private String drawingNum;

    private String unit;

    private Integer isInsert;

    private String isInsertStr;

    private Integer status;

    private String statusStr;

    private Integer approveStatus;

    private String approveStatusStr;

    private Long statusSort;

    private Long approveStatusSort;

    private Long orderId;

    private Integer actualNum;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
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

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName == null ? null : partName.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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

    public Integer getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(Integer isInsert) {
        this.isInsert = isInsert;
    }

    public String getIsInsertStr() {
        return isInsertStr;
    }

    public void setIsInsertStr(String isInsertStr) {
        this.isInsertStr = isInsertStr == null ? null : isInsertStr.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr == null ? null : statusStr.trim();
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getApproveStatusStr() {
        return approveStatusStr;
    }

    public void setApproveStatusStr(String approveStatusStr) {
        this.approveStatusStr = approveStatusStr == null ? null : approveStatusStr.trim();
    }

    public Long getStatusSort() {
        return statusSort;
    }

    public void setStatusSort(Long statusSort) {
        this.statusSort = statusSort;
    }

    public Long getApproveStatusSort() {
        return approveStatusSort;
    }

    public void setApproveStatusSort(Long approveStatusSort) {
        this.approveStatusSort = approveStatusSort;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getActualNum() {
        return actualNum;
    }

    public void setActualNum(Integer actualNum) {
        this.actualNum = actualNum;
    }
}