package com.mcpms.mcpms.system.mapper.produce;

import com.mcpms.mcpms.system.pojo.produce.MOrderProductPart;
import com.mcpms.mcpms.system.pojo.produce.MOrderProductPartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MOrderProductPartMapper {
    int countByExample(MOrderProductPartExample example);

    int deleteByExample(MOrderProductPartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MOrderProductPart record);

    int insertSelective(MOrderProductPart record);

    List<MOrderProductPart> selectByExample(MOrderProductPartExample example);

    MOrderProductPart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MOrderProductPart record, @Param("example") MOrderProductPartExample example);

    int updateByExample(@Param("record") MOrderProductPart record, @Param("example") MOrderProductPartExample example);

    int updateByPrimaryKeySelective(MOrderProductPart record);

    int updateByPrimaryKey(MOrderProductPart record);
}