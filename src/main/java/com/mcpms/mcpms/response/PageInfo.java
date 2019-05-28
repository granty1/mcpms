package com.mcpms.mcpms.response;

import java.util.List;

public class PageInfo {

    /**
     * 总记录数
     */
    private long total;
    /**
     * 记录集合
     */
    private List data;

    public PageInfo(long total, List data) {
        this.total = total;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
