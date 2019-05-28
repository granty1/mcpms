package com.mcpms.mcpms.system.service.produce;

import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlan;
import com.mcpms.mcpms.newplan.pojo.produce.VPartPlan;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.produce.MOrderProduct;
import com.mcpms.mcpms.system.pojo.produce.MProductPartPlan;
import com.mcpms.mcpms.system.pojo.produce.VProductPartPlan;

import javax.servlet.http.HttpSession;
import java.beans.IntrospectionException;


/**
 * 订单产品管理
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MProductPartPlanService {
    public Result getall(VPartPlan vPartPlan, Integer page, Integer size);
    public Result findone(long id);
    public Result update(NewMPartPlan newMPartPlan);
    public Result delete(long ids[]);
    public Result add(HttpSession session,VProductPartPlan vProductPartPlan);
    public Result getAllApproval(VProductPartPlan vProductPartPlan, Integer page, Integer size);
    public Result approval(HttpSession session, long[] ids);
    public Result back(long id);
    public Result initData();
    public Result getPartByProduct(long id);
}
