package com.mcpms.mcpms.system.pojo.vo;

public class CountBaseData {

    //订单总数
    private int orderTotalNum;
    //进行中的订单数
    private int orderRunningNum;
    //待审计划数
    private int notApprovalPlanNum;
    //进行中的计划数
    private int runningApprovalPlanNum;
    //工序外协加工数
    private int outProcessNum;
    //外协预警数
    private int outWarningNum;

    public CountBaseData(int orderTotalNum, int orderRunningNum, int notApprovalPlanNum, int runningApprovalPlanNum, int outProcessNum, int outWarningNum) {
        this.orderTotalNum = orderTotalNum;
        this.orderRunningNum = orderRunningNum;
        this.notApprovalPlanNum = notApprovalPlanNum;
        this.runningApprovalPlanNum = runningApprovalPlanNum;
        this.outProcessNum = outProcessNum;
        this.outWarningNum = outWarningNum;
    }

    public int getOrderTotalNum() {
        return orderTotalNum;
    }

    public void setOrderTotalNum(int orderTotalNum) {
        this.orderTotalNum = orderTotalNum;
    }

    public int getOrderRunningNum() {
        return orderRunningNum;
    }

    public void setOrderRunningNum(int orderRunningNum) {
        this.orderRunningNum = orderRunningNum;
    }

    public int getNotApprovalPlanNum() {
        return notApprovalPlanNum;
    }

    public void setNotApprovalPlanNum(int notApprovalPlanNum) {
        this.notApprovalPlanNum = notApprovalPlanNum;
    }

    public int getRunningApprovalPlanNum() {
        return runningApprovalPlanNum;
    }

    public void setRunningApprovalPlanNum(int runningApprovalPlanNum) {
        this.runningApprovalPlanNum = runningApprovalPlanNum;
    }

    public int getOutProcessNum() {
        return outProcessNum;
    }

    public void setOutProcessNum(int outProcessNum) {
        this.outProcessNum = outProcessNum;
    }

    public int getOutWarningNum() {
        return outWarningNum;
    }

    public void setOutWarningNum(int outWarningNum) {
        this.outWarningNum = outWarningNum;
    }
}
