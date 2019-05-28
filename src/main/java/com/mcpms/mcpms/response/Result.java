package com.mcpms.mcpms.response;


import com.mcpms.mcpms.config.response.ResponseConfig;

public class Result {

    /**
     * 状态码
     * {@link ResponseConfig}
     */
    private int code;

    /**
     * 响应消息
     * {@link ResponseConfig}
     */
    private String msg;

    /**
     * 数据列表
     */
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
