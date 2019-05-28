package com.mcpms.mcpms.system.mapper.out;

import com.mcpms.mcpms.system.pojo.out.MWarning;
import com.mcpms.mcpms.system.pojo.out.MWarningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MWarningMapper {
    int countByExample(MWarningExample example);

    int deleteByExample(MWarningExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MWarning record);

    int insertSelective(MWarning record);

    List<MWarning> selectByExample(MWarningExample example);

    MWarning selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MWarning record, @Param("example") MWarningExample example);

    int updateByExample(@Param("record") MWarning record, @Param("example") MWarningExample example);

    int updateByPrimaryKeySelective(MWarning record);

    int updateByPrimaryKey(MWarning record);
}