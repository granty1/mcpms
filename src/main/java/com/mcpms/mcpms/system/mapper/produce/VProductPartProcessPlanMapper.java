package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.VProductPartProcessPlan;
import com.mcpms.mcpms.system.pojo.produce.VProductPartProcessPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VProductPartProcessPlanMapper {
    int countByExample(VProductPartProcessPlanExample example);

    int deleteByExample(VProductPartProcessPlanExample example);

    int insert(VProductPartProcessPlan record);

    int insertSelective(VProductPartProcessPlan record);

    List<VProductPartProcessPlan> selectByExample(VProductPartProcessPlanExample example);

    int updateByExampleSelective(@Param("record") VProductPartProcessPlan record, @Param("example") VProductPartProcessPlanExample example);

    int updateByExample(@Param("record") VProductPartProcessPlan record, @Param("example") VProductPartProcessPlanExample example);
}