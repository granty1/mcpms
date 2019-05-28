package com.mcpms.mcpms.newplan.service.produce;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.InserOrderObj;

import java.util.ArrayList;

public interface PartPlanService {


    Result createPlan(ArrayList<InserOrderObj> list,String batchNum);

    Result circult(long id);

    Result preCirclue(long id);
}
