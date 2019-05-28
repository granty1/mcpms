package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.VProductPart;
import com.mcpms.mcpms.system.pojo.base.VProductPartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VProductPartMapper {
    int countByExample(VProductPartExample example);

    int deleteByExample(VProductPartExample example);

    int insert(VProductPart record);

    int insertSelective(VProductPart record);

    List<VProductPart> selectByExample(VProductPartExample example);

    int updateByExampleSelective(@Param("record") VProductPart record, @Param("example") VProductPartExample example);

    int updateByExample(@Param("record") VProductPart record, @Param("example") VProductPartExample example);
}