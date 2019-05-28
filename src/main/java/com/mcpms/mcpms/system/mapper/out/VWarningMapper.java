package com.mcpms.mcpms.system.mapper.out;

import com.mcpms.mcpms.system.pojo.out.VWarning;
import com.mcpms.mcpms.system.pojo.out.VWarningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VWarningMapper {
    int countByExample(VWarningExample example);

    int deleteByExample(VWarningExample example);

    int insert(VWarning record);

    int insertSelective(VWarning record);

    List<VWarning> selectByExample(VWarningExample example);

    int updateByExampleSelective(@Param("record") VWarning record, @Param("example") VWarningExample example);

    int updateByExample(@Param("record") VWarning record, @Param("example") VWarningExample example);
}