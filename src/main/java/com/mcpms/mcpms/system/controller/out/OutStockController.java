package com.mcpms.mcpms.system.controller.out;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.produce.VProductPartProcessPlan;
import com.mcpms.mcpms.system.pojo.vo.InStockVo;
import com.mcpms.mcpms.system.service.out.OutStockService;
import com.mcpms.mcpms.system.service.produce.MProductPartProcessPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 外协出入库管理
 * @author yuhong
 * @date   2019/2/24
 **/
@RestController
public class OutStockController {
    @Autowired
    MProductPartProcessPlanService mProductPartProcessPlanService;
    @Autowired
    OutStockService outStockService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @PostMapping("/out/out/getall")
    public Result getAllApprovalProcess(@RequestBody VProductPartProcessPlan vProductPartProcessPlan, Integer page, Integer size){
       return mProductPartProcessPlanService.getAllApprovalProcess(vProductPartProcessPlan,page,size);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @PostMapping("/out/in/getall")
    public Result getAllInProcess(@RequestBody VProductPartProcessPlan vProductPartProcessPlan, Integer page, Integer size){
        return mProductPartProcessPlanService.getAllInProcess(vProductPartProcessPlan,page,size);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_OUTSOURCE})
    @PostMapping("/out/in/instock")
    public Result inStock(@RequestBody InStockVo inStockVo,long id) {
        return outStockService.inStock(inStockVo,id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/out/out/outstock")
    public Result outStock(long id) {
        return outStockService.outStock(id);
    }
}
