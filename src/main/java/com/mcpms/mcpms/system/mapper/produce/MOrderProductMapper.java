package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.MOrderProduct;
import com.mcpms.mcpms.system.pojo.produce.MOrderProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MOrderProductMapper {
    int countByExample(MOrderProductExample example);

    int deleteByExample(MOrderProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MOrderProduct record);

    int insertSelective(MOrderProduct record);

    List<MOrderProduct> selectByExample(MOrderProductExample example);

    MOrderProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MOrderProduct record, @Param("example") MOrderProductExample example);

    int updateByExample(@Param("record") MOrderProduct record, @Param("example") MOrderProductExample example);

    int updateByPrimaryKeySelective(MOrderProduct record);

    int updateByPrimaryKey(MOrderProduct record);
}