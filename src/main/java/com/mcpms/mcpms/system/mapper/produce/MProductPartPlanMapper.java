package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.MProductPartPlan;
import com.mcpms.mcpms.system.pojo.produce.MProductPartPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MProductPartPlanMapper {
    int countByExample(MProductPartPlanExample example);

    int deleteByExample(MProductPartPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MProductPartPlan record);

    int insertSelective(MProductPartPlan record);

    List<MProductPartPlan> selectByExample(MProductPartPlanExample example);

    MProductPartPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MProductPartPlan record, @Param("example") MProductPartPlanExample example);

    int updateByExample(@Param("record") MProductPartPlan record, @Param("example") MProductPartPlanExample example);

    int updateByPrimaryKeySelective(MProductPartPlan record);

    int updateByPrimaryKey(MProductPartPlan record);
}