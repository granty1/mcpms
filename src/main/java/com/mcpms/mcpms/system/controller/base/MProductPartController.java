package com.mcpms.mcpms.system.controller.base;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MPart;
import com.mcpms.mcpms.system.service.base.MProductPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 产品零件管理
 * @author yuhong
 * @date   2019/1/16
 **/
@RestController
public class MProductPartController {

    @Autowired
    MProductPartService mProductPartService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @PostMapping("/base/product/findpartsbyproductid")
    public Result findpartsbyproductid(@RequestBody MPart mPart, int page, int size, long id){
        return mProductPartService.findpartsbyproductid(mPart,page,size,id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @GetMapping("/base/product/findnumbypartid")
    public Result findnumbypartid(long id){
        return mProductPartService.findnumbypartid(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @GetMapping("/base/product/savepartsnum")
    public Result savepartsnum(long id,int num){
        return mProductPartService.savepartsnum(id,num);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @DeleteMapping("/base/product/deleteproductpartsbatch")
    public Result deleteproductpartsbatch(long ids[]){
        return mProductPartService.deleteproductpartsbatch(ids);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @GetMapping("/base/product/getallnochoiceparts")
    public Result getallnochoiceparts(int page,int size,long id,String name){
        return mProductPartService.getallnochoiceparts(page,size,id,name);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @GetMapping("/base/product/batchaddparts")
    public Result batchaddparts(long id,long[] ids){
        return mProductPartService.batchaddparts(id,ids);
    }
}
