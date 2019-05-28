package com.mcpms.mcpms.system.service.base;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MPart;

/**
 * service 零件管理接口
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MPartService {
    public Result getAll(MPart mPart,Integer page, Integer size);
    public Result del(long[] ids);
    public Result findOne(long id);
    public Result update(MPart mPart);
    public Result add(MPart mPart);
}
