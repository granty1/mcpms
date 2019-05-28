package com.mcpms.mcpms.system.service.base;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MProduct;

/**
 * 产品管理
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MProductService{
    public Result getAll(MProduct mProduct, Integer page, Integer size);
    public Result del(long[] ids);
    public Result findOne(long id);
    public Result update(MProduct mProduct);
    public Result add(MProduct mProduct);
}
