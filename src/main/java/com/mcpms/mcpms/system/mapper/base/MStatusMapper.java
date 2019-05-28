package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MStatus;
import com.mcpms.mcpms.system.pojo.base.MStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MStatusMapper {
    int countByExample(MStatusExample example);

    int deleteByExample(MStatusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MStatus record);

    int insertSelective(MStatus record);

    List<MStatus> selectByExample(MStatusExample example);

    MStatus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MStatus record, @Param("example") MStatusExample example);

    int updateByExample(@Param("record") MStatus record, @Param("example") MStatusExample example);

    int updateByPrimaryKeySelective(MStatus record);

    int updateByPrimaryKey(MStatus record);
}