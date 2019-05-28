package com.mcpms.mcpms.system.controller.base;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MProcess;
import com.mcpms.mcpms.system.service.base.MProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 工序管理
 * @author yuhong
 * @date   2019/1/31/031
 **/
@RestController
public class MProcessController {
    @Autowired
    private MProcessService mProcessService;

    @GetMapping("/base/process/getall")
    public Result getAll() {
        return mProcessService.getAll();
    }

    @DeleteMapping("/base/process/delete")
    public Result del(long id){
        return mProcessService.del(id);
    }

    @GetMapping("/base/process/delete")
    public Result batchDel(long[] ids){
        return mProcessService.batchDel(ids);
    }

    @GetMapping("/base/process/findone")
    public Result findOne(long id){
        return mProcessService.findOne(id);
    }

    @PutMapping("/base/process/save")
    public Result update(@RequestBody MProcess mProcess){
        return mProcessService.update(mProcess);
    }

    @PostMapping("/base/process/save")
    public Result add(@RequestBody MProcess mProcess){
        return mProcessService.add(mProcess);
    }
}
