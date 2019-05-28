package com.mcpms.mcpms.system.pojo.out;

public class MWarning {
    private Long id;

    private Integer type;

    private String expeditingTime;

    private Integer expeditingNum;

    private Long orderProductPartId;

    private Integer day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExpeditingTime() {
        return expeditingTime;
    }

    public void setExpeditingTime(String expeditingTime) {
        this.expeditingTime = expeditingTime == null ? null : expeditingTime.trim();
    }

    public Integer getExpeditingNum() {
        return expeditingNum;
    }

    public void setExpeditingNum(Integer expeditingNum) {
        this.expeditingNum = expeditingNum;
    }

    public Long getOrderProductPartId() {
        return orderProductPartId;
    }

    public void setOrderProductPartId(Long orderProductPartId) {
        this.orderProductPartId = orderProductPartId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}