package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.VOrderProductPart;
import com.mcpms.mcpms.system.pojo.produce.VOrderProductPartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VOrderProductPartMapper {
    int countByExample(VOrderProductPartExample example);

    int deleteByExample(VOrderProductPartExample example);

    int insert(VOrderProductPart record);

    int insertSelective(VOrderProductPart record);

    List<VOrderProductPart> selectByExample(VOrderProductPartExample example);

    int updateByExampleSelective(@Param("record") VOrderProductPart record, @Param("example") VOrderProductPartExample example);

    int updateByExample(@Param("record") VOrderProductPart record, @Param("example") VOrderProductPartExample example);
}