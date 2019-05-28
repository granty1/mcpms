package com.mcpms.mcpms.system.pojo.base;

import java.math.BigDecimal;

public class MPartProcessVo extends  MPartProcess{
    private String partsName;
    private String processName;
    private String way;
    private String outName;

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }
}