package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MProduct;
import com.mcpms.mcpms.system.pojo.base.MProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MProductMapper {
    int countByExample(MProductExample example);

    int deleteByExample(MProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MProduct record);

    int insertSelective(MProduct record);

    List<MProduct> selectByExample(MProductExample example);

    MProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MProduct record, @Param("example") MProductExample example);

    int updateByExample(@Param("record") MProduct record, @Param("example") MProductExample example);

    int updateByPrimaryKeySelective(MProduct record);

    int updateByPrimaryKey(MProduct record);
}