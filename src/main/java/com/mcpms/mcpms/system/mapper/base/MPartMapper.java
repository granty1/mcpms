package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MPart;
import com.mcpms.mcpms.system.pojo.base.MPartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MPartMapper {
    int countByExample(MPartExample example);

    int deleteByExample(MPartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MPart record);

    int insertSelective(MPart record);

    List<MPart> selectByExample(MPartExample example);

    MPart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MPart record, @Param("example") MPartExample example);

    int updateByExample(@Param("record") MPart record, @Param("example") MPartExample example);

    int updateByPrimaryKeySelective(MPart record);

    int updateByPrimaryKey(MPart record);
}