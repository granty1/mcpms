package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MProcess;
import com.mcpms.mcpms.system.pojo.base.MProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MProcessMapper {
    int countByExample(MProcessExample example);

    int deleteByExample(MProcessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MProcess record);

    int insertSelective(MProcess record);

    List<MProcess> selectByExample(MProcessExample example);

    MProcess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MProcess record, @Param("example") MProcessExample example);

    int updateByExample(@Param("record") MProcess record, @Param("example") MProcessExample example);

    int updateByPrimaryKeySelective(MProcess record);

    int updateByPrimaryKey(MProcess record);
}