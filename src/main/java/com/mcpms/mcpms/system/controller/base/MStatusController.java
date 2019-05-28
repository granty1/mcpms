package com.mcpms.mcpms.system.controller.base;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.vo.PlanDate;
import com.mcpms.mcpms.system.service.base.MStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 状态controller-对预警天数的设置
 * @author yuhong
 * @date   2019/3/1
 **/
@RestController
public class MStatusController {
    @Autowired
    MStatusService mStatusService;

    @PostMapping("/base/warning/save")
    public Result updatePlanTime(@RequestBody PlanDate planDate){
        return mStatusService.updatePlanTime(planDate);
    }

    @GetMapping("/base/warning/init")
    public Result findPlanTime(){
        return mStatusService.findPlanTime();
    }

}
