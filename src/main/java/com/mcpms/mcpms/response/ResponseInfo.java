package com.mcpms.mcpms.response;

/**
 * 统一信息工具类
 * @author yuhong
 * @date   2019/1/16
 **/
public class ResponseInfo {
    public static String SUCCESS = "成功";
    public static String INFOMUSTFULL = "请将信息填写完整";
    public static String CANNOTDEL = "无法删除该记录";
    public static String CANNOTADD = "无法添加该记录";
    public static String UNKOWNERROR = "未知错误，请联系开发者";
    public static String LIEASTONE = "请至少选择一项";
    public static String NOTHIS = "不存在该记录";



    public static String OUTNOTEXIST = "不存在该外协单位";
    public static String OUTEXIST = "已存在该外协单位";
    public static String OUTNEEDNAME = "外协单位名称不能为空";

    public static String PROCESSNOTEXIST = "不存在该工序";
    public static String PROCESSEXIST = "已存在该工序";
    public static String PROCESSNEEDNAME = "工序名称不能为空";

    public static String PARTNOTEXIST = "不存在该零件";
    public static String PARTEXIST = "已存在该零件";
    public static String PARTNUMEXIST = "该零件编号已经被使用";
    public static String PARTNEEDNUM = "零件编号不能为空";

    public static String PRODUCTNOTEXIST = "不存在该产品";
    public static String PRODUCTEXIST = "已存在该产品";
    public static String PRODUCTTYPEEXIST = "该产品型号已经存在";
    public static String PRODUCTNEEDNUM = "产品型号不能为空";

    public static String PARTPROCESSIDNEEDFULL = "请选择零件工序";
    public static String PARTPROCESSNOTEXIST = "零件不存在该工序";
    public static String PARTPROCESSEXIST = "该零件已经存在该工序";
    public static String PARTPROCESSTYPEEXIST = "该产品型号已经存在";
    public static String PARTPROCESSNEEDNUM = "产品型号不能为空";

    public static String ORDERNOTEXIST = "不存在该订单";
    public static String ORDEREXIST = "已存在该订单";
    public static String ORDERNUMEXIST = "该订单编号已经被使用";
    public static String ORDERNEEDNUM = "订单编号不能为空";

    public static String ORDERPRODUCTEXIT = "该订单已经存在该产品";

    public static String PLANNOTEXIT = "生产计划不存在";
    public static String PLANEXIT = "生产计划已经存在";


}
