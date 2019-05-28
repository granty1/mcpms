package com.mcpms.mcpms.newplan.mapper.produce;

import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlanProcess;
import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlanProcessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewMPartPlanProcessMapper {
    int countByExample(NewMPartPlanProcessExample example);

    int deleteByExample(NewMPartPlanProcessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewMPartPlanProcess record);

    int insertSelective(NewMPartPlanProcess record);

    List<NewMPartPlanProcess> selectByExample(NewMPartPlanProcessExample example);

    NewMPartPlanProcess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewMPartPlanProcess record, @Param("example") NewMPartPlanProcessExample example);

    int updateByExample(@Param("record") NewMPartPlanProcess record, @Param("example") NewMPartPlanProcessExample example);

    int updateByPrimaryKeySelective(NewMPartPlanProcess record);

    int updateByPrimaryKey(NewMPartPlanProcess record);
}