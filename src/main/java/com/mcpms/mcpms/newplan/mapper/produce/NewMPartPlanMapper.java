package com.mcpms.mcpms.newplan.mapper.produce;

import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlan;
import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewMPartPlanMapper {
    int countByExample(NewMPartPlanExample example);

    int deleteByExample(NewMPartPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewMPartPlan record);

    int insertSelective(NewMPartPlan record);

    List<NewMPartPlan> selectByExample(NewMPartPlanExample example);

    NewMPartPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewMPartPlan record, @Param("example") NewMPartPlanExample example);

    int updateByExample(@Param("record") NewMPartPlan record, @Param("example") NewMPartPlanExample example);

    int updateByPrimaryKeySelective(NewMPartPlan record);

    int updateByPrimaryKey(NewMPartPlan record);
}