package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MPartProcess;
import com.mcpms.mcpms.system.pojo.base.MPartProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MPartProcessMapper {
    int countByExample(MPartProcessExample example);

    int deleteByExample(MPartProcessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MPartProcess record);

    int insertSelective(MPartProcess record);

    List<MPartProcess> selectByExample(MPartProcessExample example);

    MPartProcess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MPartProcess record, @Param("example") MPartProcessExample example);

    int updateByExample(@Param("record") MPartProcess record, @Param("example") MPartProcessExample example);

    int updateByPrimaryKeySelective(MPartProcess record);

    int updateByPrimaryKey(MPartProcess record);
}