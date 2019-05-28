package com.mcpms.mcpms.system.controller.out;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.out.VWarning;
import com.mcpms.mcpms.system.service.out.MWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MWarningController{

    @Autowired
    MWarningService mWarningService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @PostMapping("/out/warning/getall")
    public Result getAll(@RequestBody VWarning vWarning, int page, int size){
        return  mWarningService.getAll(vWarning,page,size);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/out/warning/expediting")
    public Result hastenDelyvery(long id){
       return mWarningService.hastenDelyvery(id);

    }
}
