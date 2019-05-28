package com.mcpms.mcpms.response;



import com.mcpms.mcpms.config.response.ResponseConfig;

import java.util.List;

import static com.mcpms.mcpms.config.response.ResponseConfig.*;

/**
* Response 统一处理工具类
* @author guolin
* @date   2019/1/23/023
**/
public class ResponseUtils {

    /**
     * 自定响应
     * @param code code
     * @param msg  message
     * @param data data
     * @return {@link Result}
     */
    public static Result responseCustom(int code,String msg,Object data){
        return new Result(code,msg,data);
    }
    /**
     * 无参数响应成功
     * @return {@link Result}
     */
    public static Result responseSuccess(){
        return new Result(REQUEST_SUCCESS_CODE,REQUEST_SUCCESS_MSG,null);
    }

    /**
     * 有信息响应成功
     * @param msg message
     * @return {@link Result}
     */
    public static Result responseSuccess(String msg){
        return new Result(REQUEST_SUCCESS_CODE,msg,null);
    }

    /**
     * 有数据响应成功
     * @param data
     * @return
     */
    public static Result responseSuccess(Object data){
        return new Result(REQUEST_SUCCESS_CODE,REQUEST_SUCCESS_MSG,data);
    }

    /**
     * 有信息、数据响应成功
     * @param msg message
     * @param data data
     * @return {@link Result}
     */
    public static Result responseSuccess(String msg,Object data){
        return new Result(REQUEST_SUCCESS_CODE,msg,data);
    }

    /**
     * 无参数响应失败
     * @return {@link Result}
     */
    public static Result responseFail(){
        return new Result(REQUEST_FAIL_CODE,REQUEST_FAIL_MSG,null);
    }

    /**
     * 有信息响应失败
     * @param msg message
     * @return {@link Result}
     */
    public static Result responseFail(String msg){
        return new Result(REQUEST_FAIL_CODE,msg,null);
    }

    /**
     * 有数据响应成功
     * @param data
     * @return
     */
    public static Result responseFail(Object data){
        return new Result(REQUEST_FAIL_CODE,REQUEST_FAIL_MSG,data);
    }

    /**
     * 有信息、数据响应失败
     * @param msg message
     * @param data data
     * @return {@link Result}
     */
    public static Result responseFail(String msg,Object data){
        return new Result(REQUEST_FAIL_CODE,msg,data);
    }

    /**
     * 分页响应成功
     * @param total 总记录数
     * @param data  数据列表
     * @return {@link Result}
     */
    public static Result responseSuccessPage(long total, List data){
        return new Result(REQUEST_SUCCESS_CODE,REQUEST_SUCCESS_MSG,new PageInfo(total,data));
    }


}
