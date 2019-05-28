package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.MOrder;
import com.mcpms.mcpms.system.pojo.produce.MOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MOrderMapper {
    int countByExample(MOrderExample example);

    int deleteByExample(MOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MOrder record);

    int insertSelective(MOrder record);

    List<MOrder> selectByExample(MOrderExample example);

    MOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MOrder record, @Param("example") MOrderExample example);

    int updateByExample(@Param("record") MOrder record, @Param("example") MOrderExample example);

    int updateByPrimaryKeySelective(MOrder record);

    int updateByPrimaryKey(MOrder record);
}