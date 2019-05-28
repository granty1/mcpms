package com.mcpms.mcpms.system.mapper.out;

import com.mcpms.mcpms.system.pojo.out.MProductPartOutprocess;
import com.mcpms.mcpms.system.pojo.out.MProductPartOutprocessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MProductPartOutprocessMapper {
    int countByExample(MProductPartOutprocessExample example);

    int deleteByExample(MProductPartOutprocessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MProductPartOutprocess record);

    int insertSelective(MProductPartOutprocess record);

    List<MProductPartOutprocess> selectByExample(MProductPartOutprocessExample example);

    MProductPartOutprocess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MProductPartOutprocess record, @Param("example") MProductPartOutprocessExample example);

    int updateByExample(@Param("record") MProductPartOutprocess record, @Param("example") MProductPartOutprocessExample example);

    int updateByPrimaryKeySelective(MProductPartOutprocess record);

    int updateByPrimaryKey(MProductPartOutprocess record);
}