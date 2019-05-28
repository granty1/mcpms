package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.VProductPartPlan;
import com.mcpms.mcpms.system.pojo.produce.VProductPartPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VProductPartPlanMapper {
    int countByExample(VProductPartPlanExample example);

    int deleteByExample(VProductPartPlanExample example);

    int insert(VProductPartPlan record);

    int insertSelective(VProductPartPlan record);

    List<VProductPartPlan> selectByExample(VProductPartPlanExample example);

    int updateByExampleSelective(@Param("record") VProductPartPlan record, @Param("example") VProductPartPlanExample example);

    int updateByExample(@Param("record") VProductPartPlan record, @Param("example") VProductPartPlanExample example);
}