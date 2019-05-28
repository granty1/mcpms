package com.mcpms.mcpms.system.mapper.out;

import com.mcpms.mcpms.system.pojo.out.MProductPartRepertory;
import com.mcpms.mcpms.system.pojo.out.MProductPartRepertoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MProductPartRepertoryMapper {
    int countByExample(MProductPartRepertoryExample example);

    int deleteByExample(MProductPartRepertoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MProductPartRepertory record);

    int insertSelective(MProductPartRepertory record);

    List<MProductPartRepertory> selectByExample(MProductPartRepertoryExample example);

    MProductPartRepertory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MProductPartRepertory record, @Param("example") MProductPartRepertoryExample example);

    int updateByExample(@Param("record") MProductPartRepertory record, @Param("example") MProductPartRepertoryExample example);

    int updateByPrimaryKeySelective(MProductPartRepertory record);

    int updateByPrimaryKey(MProductPartRepertory record);
}