package com.mcpms.mcpms.system.mapper.index;

import com.mcpms.mcpms.system.pojo.index.VUser;
import com.mcpms.mcpms.system.pojo.index.VUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VUserMapper {
    int countByExample(VUserExample example);

    int deleteByExample(VUserExample example);

    int insert(VUser record);

    int insertSelective(VUser record);

    List<VUser> selectByExample(VUserExample example);

    int updateByExampleSelective(@Param("record") VUser record, @Param("example") VUserExample example);

    int updateByExample(@Param("record") VUser record, @Param("example") VUserExample example);
}