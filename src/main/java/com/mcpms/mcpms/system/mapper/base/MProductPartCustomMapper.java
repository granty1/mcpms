package com.mcpms.mcpms.system.mapper.base;

import com.mcpms.mcpms.system.pojo.base.MPart;
import com.mcpms.mcpms.system.pojo.base.MProcess;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 产品零件管理
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MProductPartCustomMapper {

    @Select("select * from m_part WHERE NOT EXISTS (SELECT * from v_product_part WHERE m_part.id = v_product_part.part_id and product_id = ${id})")
    public List<MPart> getallnochoiceparts(@Param("id") long id);

    @Select("select * from m_part WHERE NOT EXISTS (SELECT * from v_product_part WHERE m_part.id = v_product_part.part_id and product_id = ${id}) AND m_part.name LIKE '%${name}%'")
    public List<MPart> getallnochoicepartsSearch(@Param("id") long id,@Param("name") String name);
}
