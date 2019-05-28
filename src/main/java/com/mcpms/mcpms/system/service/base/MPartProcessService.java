package com.mcpms.mcpms.system.service.base;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MPartProcess;

/**
 * 零件工序管理
 * @author yuhong
 * @date   2019/1/17
 **/
public interface MPartProcessService {
    public Result getAllByPartId(Long partsId);
    public Result del(long ids);
    public Result findOne(long id);
    public Result update(MPartProcess mPartProcess);
    public Result add(MPartProcess mProduct);
    public Result initData();
    public Result clone(long id,long targitId);

}
