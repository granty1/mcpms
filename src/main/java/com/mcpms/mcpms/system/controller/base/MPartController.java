package com.mcpms.mcpms.system.controller.base;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MPart;
import com.mcpms.mcpms.system.service.base.MPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 零件管理
 * @author yuhong
 * @date   2019/1/16
 **/
@RestController
public class MPartController {
    
    @Autowired
    private MPartService mPartService;
    @PostMapping("/base/parts/getall")
    public Result getAll(@RequestBody MPart mPart,int page,int size) {
        return mPartService.getAll(mPart,page,size);
    }

    @DeleteMapping("/base/parts/delete")
    public Result batchDel(long[] ids){
        return mPartService.del(ids);
    }

    @GetMapping("/base/parts/findone")
    public Result findOne(long id){
        return mPartService.findOne(id);
    }

    @PutMapping("/base/parts/save")
    public Result update(@RequestBody MPart mPart){
        return mPartService.update(mPart);
    }

    @PostMapping("/base/parts/save")
    public Result add(@RequestBody MPart mPart){
        return mPartService.add(mPart);
    }
}
