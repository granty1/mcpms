package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.VOrder;
import com.mcpms.mcpms.system.pojo.produce.VOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VOrderMapper {
    int countByExample(VOrderExample example);

    int deleteByExample(VOrderExample example);

    int insert(VOrder record);

    int insertSelective(VOrder record);

    List<VOrder> selectByExample(VOrderExample example);

    int updateByExampleSelective(@Param("record") VOrder record, @Param("example") VOrderExample example);

    int updateByExample(@Param("record") VOrder record, @Param("example") VOrderExample example);
}