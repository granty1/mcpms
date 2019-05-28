package com.mcpms.mcpms.system.service.base;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.vo.PlanDate;

public interface MStatusService {
    /*修改计划预警时间*/
    public Result updatePlanTime(PlanDate planDate);
    public Result findPlanTime();


}
