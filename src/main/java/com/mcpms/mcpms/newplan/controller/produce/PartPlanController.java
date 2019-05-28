package com.mcpms.mcpms.newplan.controller.produce;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.newplan.pojo.produce.PlanEntity;
import com.mcpms.mcpms.newplan.service.produce.PartPlanService;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.InserOrderObj;
import com.mcpms.mcpms.system.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@RestController
public class PartPlanController {

    @Autowired
    private PartPlanService partPlanService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @PostMapping("/produce/plan/insertOrder")
    public Result add(HttpSession session, @RequestBody PlanEntity entity){
        ArrayList<InserOrderObj> list = entity.getList();
        String batchNum = "";
        if (StringUtils.isEmpty(entity.getNum())){
            batchNum = DateUtils.dateTimeNow();
        }else {
            batchNum = entity.getNum();
        }
        if (list.size()==0){
            return ResponseUtils.responseFail("请添加零件");
        }
        return partPlanService.createPlan(list,batchNum);
    }

    @GetMapping("/produce/plan/circule")
    public Result circule(long id){
        return partPlanService.circult(id);
    }

    @GetMapping("/produce/plan/precircule")
    public Result preCirclue(long id){
        return partPlanService.preCirclue(id);
    }
}
