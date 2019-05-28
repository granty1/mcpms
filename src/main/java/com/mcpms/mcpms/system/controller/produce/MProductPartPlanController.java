package com.mcpms.mcpms.system.controller.produce;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlan;
import com.mcpms.mcpms.newplan.pojo.produce.VPartPlan;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.produce.MProductPartPlanMapper;
import com.mcpms.mcpms.system.pojo.base.InserOrderObj;
import com.mcpms.mcpms.system.pojo.produce.MProductPartPlan;
import com.mcpms.mcpms.system.pojo.produce.VProductPartPlan;
import com.mcpms.mcpms.system.service.produce.MProductPartPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;


/**
 * 生产计划管理
 * @author yuhong
 * @date   2019/2/24
 **/
@RestController
public class MProductPartPlanController {

    @Autowired
    MProductPartPlanService mProductPartPlanService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @PostMapping("/produce/plan/getall")
    public Result getall(@RequestBody VPartPlan vPartPlan, Integer page, Integer size){
       return mProductPartPlanService.getall(vPartPlan,page,size);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/plan/findone")
    public Result findone(long id){
        return mProductPartPlanService.findone(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @PutMapping("/produce/plan/save")
    public Result update(@RequestBody NewMPartPlan newMPartPlan){
        return mProductPartPlanService.update(newMPartPlan);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    public Result delete(long ids[]){
        return mProductPartPlanService.delete(ids);
    }



    /*@GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @PostMapping("/produce/approval/getall")
    public Result getAllApproval(@RequestBody VProductPartPlan vProductPartPlan, Integer page, Integer size){
        return mProductPartPlanService.getall(vProductPartPlan,page,size);
    }
*/
    @GuoLinAuthenticate(value = {RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/approval/pass")
    public Result approval(HttpSession session, long[] ids){
        return mProductPartPlanService.approval(session,ids);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/approval/back")
    public Result back(long id){
        return mProductPartPlanService.back(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/plan/initdata")
    public Result initData(){
        return  mProductPartPlanService.initData();
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/plan/findPartsByProductId")
    public Result getAllPartByProduct(long id){
        return  mProductPartPlanService.getPartByProduct(id);
    }
}
