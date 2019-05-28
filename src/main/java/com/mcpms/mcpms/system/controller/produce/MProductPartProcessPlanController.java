package com.mcpms.mcpms.system.controller.produce;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlanProcess;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.produce.MProductPartPlanMapper;
import com.mcpms.mcpms.system.pojo.produce.MProductPartPlan;
import com.mcpms.mcpms.system.pojo.produce.MProductPartProcessPlan;
import com.mcpms.mcpms.system.pojo.produce.VProductPartPlan;
import com.mcpms.mcpms.system.service.produce.MProductPartPlanService;
import com.mcpms.mcpms.system.service.produce.MProductPartProcessPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 生产工序计划管理
 * @author yuhong
 * @date   2019/2/24
 **/
@RestController
public class MProductPartProcessPlanController {

    @Autowired
    MProductPartProcessPlanService mProductPartProcessPlanService;
    @Autowired
    MProductPartPlanService mProductPartPlanService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/plan/getprocess")
    public Result getall(long id){
        return mProductPartProcessPlanService.getAllPro(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/plan/findonePro")
    public Result findone(long id){
        return mProductPartProcessPlanService.findonePro(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @PostMapping("/produce/plan/saveprocess")
    public Result update(@RequestBody NewMPartPlanProcess mProductPartProcessPlan){
        return mProductPartProcessPlanService.savePro(mProductPartProcessPlan);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/approval/passprocess")
    public Result approvalOut(HttpSession session, long id) {
        return mProductPartProcessPlanService.approvalOut(session,id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/approval/initdata")
    public Result initdata(){
        return mProductPartPlanService.initData();
    }

}
