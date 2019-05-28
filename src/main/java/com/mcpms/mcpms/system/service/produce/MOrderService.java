package com.mcpms.mcpms.system.service.produce;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.produce.MOrder;

/**
 * 订单
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MOrderService {
    public Result getAll(MOrder mOrder, Integer page, Integer size);
    public Result del(long[] ids);
    public Result findOne(long id);
    public Result update(MOrder mOrder);
    public Result add(MOrder mOrder);
    public Result finshorder(long id);
    public Result scrap(long id);
}
