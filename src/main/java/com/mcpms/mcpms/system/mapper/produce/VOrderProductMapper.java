package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.VOrderProduct;
import com.mcpms.mcpms.system.pojo.produce.VOrderProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VOrderProductMapper {
    int countByExample(VOrderProductExample example);

    int deleteByExample(VOrderProductExample example);

    int insert(VOrderProduct record);

    int insertSelective(VOrderProduct record);

    List<VOrderProduct> selectByExample(VOrderProductExample example);

    int updateByExampleSelective(@Param("record") VOrderProduct record, @Param("example") VOrderProductExample example);

    int updateByExample(@Param("record") VOrderProduct record, @Param("example") VOrderProductExample example);
}