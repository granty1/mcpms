package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.MProductPartProcessPlan;
import com.mcpms.mcpms.system.pojo.produce.MProductPartProcessPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MProductPartProcessPlanMapper {
    int countByExample(MProductPartProcessPlanExample example);

    int deleteByExample(MProductPartProcessPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MProductPartProcessPlan record);

    int insertSelective(MProductPartProcessPlan record);

    List<MProductPartProcessPlan> selectByExample(MProductPartProcessPlanExample example);

    MProductPartProcessPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MProductPartProcessPlan record, @Param("example") MProductPartProcessPlanExample example);

    int updateByExample(@Param("record") MProductPartProcessPlan record, @Param("example") MProductPartProcessPlanExample example);

    int updateByPrimaryKeySelective(MProductPartProcessPlan record);

    int updateByPrimaryKey(MProductPartProcessPlan record);
}