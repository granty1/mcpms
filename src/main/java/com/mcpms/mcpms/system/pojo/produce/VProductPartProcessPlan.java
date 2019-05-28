package com.mcpms.mcpms.system.pojo.produce;

import java.math.BigDecimal;

public class VProductPartProcessPlan {
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

    private String processName;

    private String statusStr;

    private String approveStatusStr;

    private Long statusSort;

    private Long approveStatusSort;

    private String way;

    private String outName;

    private Long processId;

    private Integer processSort;

    private String orderNum;

    private Long partsId;

    private Long productId;

    private String partsName;

    private String productName;

    private Integer num;

    private Integer planStatus;

    private Integer planApproveStatus;

    private String runningNum;

    private Integer isInsert;

    private Long repertoryStatus;

    private String isInsertStr;

    private Integer actualNum;


    /**
     * 扩展  存货编码 合计 单位
     */
    private String unit;
    private BigDecimal total;

    public VProductPartProcessPlan() {
        this.actualNum = 0;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

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

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr == null ? null : statusStr.trim();
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

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Integer getProcessSort() {
        return processSort;
    }

    public void setProcessSort(Integer processSort) {
        this.processSort = processSort;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Long getPartsId() {
        return partsId;
    }

    public void setPartsId(Long partsId) {
        this.partsId = partsId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName == null ? null : partsName.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    public Integer getPlanApproveStatus() {
        return planApproveStatus;
    }

    public void setPlanApproveStatus(Integer planApproveStatus) {
        this.planApproveStatus = planApproveStatus;
    }

    public String getRunningNum() {
        return runningNum;
    }

    public void setRunningNum(String runningNum) {
        this.runningNum = runningNum == null ? null : runningNum.trim();
    }

    public Integer getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(Integer isInsert) {
        this.isInsert = isInsert;
    }

    public Long getRepertoryStatus() {
        return repertoryStatus;
    }

    public void setRepertoryStatus(Long repertoryStatus) {
        this.repertoryStatus = repertoryStatus;
    }

    public String getIsInsertStr() {
        return isInsertStr;
    }

    public void setIsInsertStr(String isInsertStr) {
        this.isInsertStr = isInsertStr == null ? null : isInsertStr.trim();
    }

    public Integer getActualNum() {
        return actualNum;
    }

    public void setActualNum(Integer actualNum) {
        this.actualNum = actualNum;
    }
}