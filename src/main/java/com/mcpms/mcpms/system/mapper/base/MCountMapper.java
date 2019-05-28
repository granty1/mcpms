package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.vo.MonthCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MCountMapper {


    //总订单数
    @Select("select count(*) from m_part ")
    int orderTotalNums();


    //进行中的订单数
    @Select("select count(*) from m_out where m_out.id != '218' ")
    int orderRunningNums();


    //待审计划数
    @Select("select count(*) from new_m_part_plan")
    int notApprovalPlanNums();



    //执行中的计划数
    @Select("select count(*) from new_m_part_plan new where new.plan_status = '11'")
    int runningApprovalPlanNums();


    //工序加工外协数
    @Select("select count(*) from new_m_part_plan new where new.plan_status = '12'")
    int outProcessNum();


    //外协预警数
    @Select("select count(*) from new_m_part_plan new where new.plan_status = '13'")
    int outWarningNums();


    //各月份外协加工统计
    @Select("SELECT\n" +
            "\tDATE_FORMAT(nm.create_time, '%m') MONTH,\n" +
            "\tIFNULL(count(*), 0) num\n" +
            "FROM\n" +
            "\tnew_m_part_plan nm\n" +
            "WHERE\n" +
            "\tDATE_FORMAT(nm.create_time, '%Y') = '${year}'\n" +
            "GROUP BY\n" +
            "\tDATE_FORMAT(nm.create_time, '%m')\n" +
            "ORDER BY\n" +
            "\tDATE_FORMAT(nm.create_time, '%m')")
    List<MonthCount> findMonthCount(@Param("year")String year);

}
