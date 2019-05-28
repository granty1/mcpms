package com.mcpms.mcpms.system.service.out;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.vo.InStockVo;

/**
 * 出入库
 * @author yuhong
 * @date   2019/2/24
 **/
public interface OutStockService {
    public Result outStock(long id);
    public Result inStock(InStockVo inStockVo,long id);
    public Result destroy(long id);

}
