package com.mcpms.mcpms.system.pojo.out;

import java.math.BigDecimal;

public class MProductPartRepertory {
    private Long id;

    private Long orderProductPartId;

    private Long partId;

    private String cinvcode;

    private Integer num;

    private BigDecimal price;

    private String reTime;

    private String inTime;

    private Integer status;

    private Long modeId;

    private Long partProcessId;

    private Long outId;

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

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getCinvcode() {
        return cinvcode;
    }

    public void setCinvcode(String cinvcode) {
        this.cinvcode = cinvcode == null ? null : cinvcode.trim();
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

    public String getReTime() {
        return reTime;
    }

    public void setReTime(String reTime) {
        this.reTime = reTime == null ? null : reTime.trim();
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime == null ? null : inTime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getModeId() {
        return modeId;
    }

    public void setModeId(Long modeId) {
        this.modeId = modeId;
    }

    public Long getPartProcessId() {
        return partProcessId;
    }

    public void setPartProcessId(Long partProcessId) {
        this.partProcessId = partProcessId;
    }

    public Long getOutId() {
        return outId;
    }

    public void setOutId(Long outId) {
        this.outId = outId;
    }
}