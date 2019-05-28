package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MPartProcess;
import com.mcpms.mcpms.system.pojo.base.MPartProcessVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 零件工序管理
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MPartProcessCustomMapper {

    @Select("SELECT DISTINCT\n" +
            "m_part_process.id id,\n" +
            "m_part_process.parts_id partsId,\n" +
            "(select m_part.`name` FROM m_part WHERE m_part_process.parts_id = m_part.id) partsName,\n" +
            "m_part_process.process_id processId,\n" +
            "(select m_process.`name` FROM m_process WHERE m_part_process.process_id = m_process.id) processName,\n" +
            "(select m_process.sort FROM m_process WHERE m_part_process.process_id = m_process.id) processSort,\n" +
            "m_part_process.mode_id modeId,\n" +
            "(select m_mode.way FROM m_mode WHERE m_part_process.mode_id = m_mode.id) way,\n" +
            "m_part_process.`day`,\n" +
            "m_part_process.drawing_num drawingNum,\n" +
            "m_part_process.out_id outId,\n" +
            "(select m_out.`name` FROM m_out WHERE m_part_process.out_id = m_out.id) outName,\n" +
            "m_part_process.price,\n" +
            "m_part_process.remarks\n" +
            "FROM\n" +
            "m_part_process,\n" +
            "m_process\n" +
            "WHERE \n" +
            "m_part_process.parts_id=${partsId}\n" +
            "order by m_part_process.`day`")
    public List<MPartProcessVo> getAllByPartIdDesc(@Param("partsId")Long partsId);
}
