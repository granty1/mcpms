package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MProcess;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 工序管理扩展类
 * @author yuhong
 * @date   2019/1/31/031
 **/
public interface MProcessCustomMapper {

    @Select("SELECT * FROM m_process where m_process.id != '218' and m_process.id!= '219' ORDER BY sort")
    public List<MProcess> getAllOrderBySort();
}
