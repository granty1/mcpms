package com.mcpms.mcpms.system.controller.base;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MOut;
import com.mcpms.mcpms.system.service.base.MOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 外协管理
 * @author yuhong
 * @date   2019/1/31/031
 **/
@RestController
@GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
public class MOutController {

    @Autowired
    private MOutService mOutService;

    @PostMapping("/base/out/getall")
    public Result getAll(@RequestBody MOut mOut, Integer page, Integer size) {
        return mOutService.getAll(mOut,page,size);
    }

    @DeleteMapping("/base/out/del")
    public Result del(long id){
        return mOutService.del(id);
    }

    @GetMapping("/base/out/findone")
    public Result findOne(long id){
        return mOutService.findOne(id);
    }

    @PutMapping("/base/out/save")
    public Result update(@RequestBody MOut mOut){
        return mOutService.update(mOut);
    }

    @PostMapping("/base/out/save")
    public Result add(@RequestBody MOut mOut){
        return mOutService.add(mOut);
    }
}
