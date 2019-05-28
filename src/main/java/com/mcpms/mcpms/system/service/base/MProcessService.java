package com.mcpms.mcpms.system.service.base;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MProcess;

/**
 * service 工序管理接口
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MProcessService {

    public Result getAll();
    public Result del(long id);
    public Result batchDel(long[] ids);
    public Result findOne(long id);
    public Result update(MProcess mProcess);
    public Result add(MProcess mProcess);
}
