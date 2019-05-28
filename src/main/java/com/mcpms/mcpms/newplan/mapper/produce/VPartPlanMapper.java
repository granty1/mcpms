package com.mcpms.mcpms.newplan.mapper.produce;

import com.mcpms.mcpms.newplan.pojo.produce.VPartPlan;
import com.mcpms.mcpms.newplan.pojo.produce.VPartPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VPartPlanMapper {
    int countByExample(VPartPlanExample example);

    int deleteByExample(VPartPlanExample example);

    int insert(VPartPlan record);

    int insertSelective(VPartPlan record);

    List<VPartPlan> selectByExample(VPartPlanExample example);

    int updateByExampleSelective(@Param("record") VPartPlan record, @Param("example") VPartPlanExample example);

    int updateByExample(@Param("record") VPartPlan record, @Param("example") VPartPlanExample example);
}