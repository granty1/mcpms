package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MOut;
import com.mcpms.mcpms.system.pojo.base.MOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MOutMapper {
    int countByExample(MOutExample example);

    int deleteByExample(MOutExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MOut record);

    int insertSelective(MOut record);

    List<MOut> selectByExample(MOutExample example);

    MOut selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MOut record, @Param("example") MOutExample example);

    int updateByExample(@Param("record") MOut record, @Param("example") MOutExample example);

    int updateByPrimaryKeySelective(MOut record);

    int updateByPrimaryKey(MOut record);
}