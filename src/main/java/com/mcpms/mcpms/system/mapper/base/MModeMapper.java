package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MMode;
import com.mcpms.mcpms.system.pojo.base.MModeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MModeMapper {
    int countByExample(MModeExample example);

    int deleteByExample(MModeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MMode record);

    int insertSelective(MMode record);

    List<MMode> selectByExample(MModeExample example);

    MMode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MMode record, @Param("example") MModeExample example);

    int updateByExample(@Param("record") MMode record, @Param("example") MModeExample example);

    int updateByPrimaryKeySelective(MMode record);

    int updateByPrimaryKey(MMode record);
}