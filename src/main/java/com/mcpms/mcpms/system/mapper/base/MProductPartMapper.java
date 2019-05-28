package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MProductPart;
import com.mcpms.mcpms.system.pojo.base.MProductPartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MProductPartMapper {
    int countByExample(MProductPartExample example);

    int deleteByExample(MProductPartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MProductPart record);

    int insertSelective(MProductPart record);

    List<MProductPart> selectByExample(MProductPartExample example);

    MProductPart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MProductPart record, @Param("example") MProductPartExample example);

    int updateByExample(@Param("record") MProductPart record, @Param("example") MProductPartExample example);

    int updateByPrimaryKeySelective(MProductPart record);

    int updateByPrimaryKey(MProductPart record);
}