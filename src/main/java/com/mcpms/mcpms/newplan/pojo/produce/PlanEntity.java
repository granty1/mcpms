package com.mcpms.mcpms.newplan.pojo.produce;

import com.mcpms.mcpms.system.pojo.base.InserOrderObj;

import java.util.ArrayList;

public class PlanEntity {

    private String num;
    private ArrayList<InserOrderObj> list;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public ArrayList<InserOrderObj> getList() {
        return list;
    }

    public void setList(ArrayList<InserOrderObj> list) {
        this.list = list;
    }
}
