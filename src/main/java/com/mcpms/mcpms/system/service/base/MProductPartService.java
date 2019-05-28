package com.mcpms.mcpms.system.service.base;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MPart;

/**
 * 产品零件管理
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MProductPartService {
    public Result findpartsbyproductid(MPart mPart,int page,int size,long id);
    public Result findnumbypartid(long id);
    public Result savepartsnum(long id,int num);
    public Result deleteproductpartsbatch(long ids[]);
    public Result getallnochoiceparts(int page,int size,long id,String name);
    public Result batchaddparts(long id,long[] ids);
}
