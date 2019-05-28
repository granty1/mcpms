package com.mcpms.mcpms.system.pojo.vo;

public class MonthCount {

    private int month;

    private int num;

    public MonthCount(int month, int num) {
        this.month = month;
        this.num = num;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
