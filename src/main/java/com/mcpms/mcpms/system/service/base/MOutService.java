package com.mcpms.mcpms.system.service.base;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MOut;


/**
 * service 外协管理接口
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MOutService {

    public Result getAll(MOut mOut,Integer page, Integer size);
    public Result del(long id);
    public Result findOne(long id);
    public Result update(MOut mOut);
    public Result add(MOut mOut);

}
