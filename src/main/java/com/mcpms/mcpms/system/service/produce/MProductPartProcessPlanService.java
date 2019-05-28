package com.mcpms.mcpms.system.service.produce;

import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlanProcess;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.produce.MProductPartProcessPlan;
import com.mcpms.mcpms.system.pojo.produce.VProductPartProcessPlan;

import javax.servlet.http.HttpSession;

public interface MProductPartProcessPlanService {
    public Result findonePro(long id);
    public Result getAllPro(long id);
    public Result savePro(NewMPartPlanProcess mProductPartProcessPlan);
    public Result approvalOut(HttpSession session, long id);
    public Result getAllApprovalProcess(VProductPartProcessPlan vProductPartProcessPlan, Integer page, Integer size);
    public Result getAllInProcess(VProductPartProcessPlan vProductPartProcessPlan, Integer page, Integer size);
}
