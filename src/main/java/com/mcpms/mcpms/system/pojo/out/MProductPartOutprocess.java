package com.mcpms.mcpms.system.pojo.out;

import java.math.BigDecimal;

public class MProductPartOutprocess {
    private Long id;

    private Long orderProductPartId;

    private Integer num;

    private BigDecimal price;

    private Long modeId;

    private Long partProcessId;

    private Long outId;

    private String outTime;

    private String deliverTime;

    private Integer status;

    private String address;

    private String linkman;

    private String tel;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
}