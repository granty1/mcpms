package com.mcpms.mcpms.newplan.mapper.produce;

import com.mcpms.mcpms.newplan.pojo.produce.VPartPlanProcess;
import com.mcpms.mcpms.newplan.pojo.produce.VPartPlanProcessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VPartPlanProcessMapper {
    int countByExample(VPartPlanProcessExample example);

    int deleteByExample(VPartPlanProcessExample example);

    int insert(VPartPlanProcess record);

    int insertSelective(VPartPlanProcess record);

    List<VPartPlanProcess> selectByExample(VPartPlanProcessExample example);

    int updateByExampleSelective(@Param("record") VPartPlanProcess record, @Param("example") VPartPlanProcessExample example);

    int updateByExample(@Param("record") VPartPlanProcess record, @Param("example") VPartPlanProcessExample example);
}