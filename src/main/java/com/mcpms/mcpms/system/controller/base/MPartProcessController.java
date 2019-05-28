package com.mcpms.mcpms.system.controller.base;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MPartProcess;
import com.mcpms.mcpms.system.service.base.MPartProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 零件工序管理
 * @author yuhong
 * @date   2019/1/16
 **/
@RestController
public class MPartProcessController{
    @Autowired
    private MPartProcessService mPartProcessService;

    @GetMapping("/base/parts/getallprocess")
    public Result getAll(Long id) {
        return mPartProcessService.getAllByPartId(id);
    }

    @DeleteMapping("/base/parts/deleteProcess")
    public Result batchDel(long id){
        return mPartProcessService.del(id);
    }

    @GetMapping("/base/parts/findoneProcess")
    public Result findOne(long id){
        return mPartProcessService.findOne(id);
    }

    @PutMapping("/base/parts/processsave")
    public Result update(@RequestBody MPartProcess mPartProcess){
        return mPartProcessService.update(mPartProcess);
    }

    @PostMapping("/base/parts/processsave")
    public Result add(@RequestBody MPartProcess mPartProcess){
        return mPartProcessService.add(mPartProcess);
    }

    @GetMapping("/base/parts/initdata")
    public Result initData() {
        return mPartProcessService.initData();
    }

    @GetMapping("/base/parts/clone")
    public Result clone(long id,long targetId) {
        return mPartProcessService.clone(id,targetId);
    }


}
