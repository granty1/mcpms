package com.mcpms.mcpms.system.controller.base;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MProduct;
import com.mcpms.mcpms.system.service.base.MProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 产品管理
 * @author yuhong
 * @date   2019/1/16
 **/
@RestController
public class MProductController {



    @Autowired
    private MProductService mProductService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @PostMapping("/base/product/getall")
    public Result getAll(@RequestBody MProduct mProduct, int page, int size) {
        return mProductService.getAll(mProduct,page,size);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @DeleteMapping("/base/product/delete")
    public Result batchDel(long[] ids){
        return mProductService.del(ids);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @GetMapping("/base/product/findone")
    public Result findOne(long id){
        return mProductService.findOne(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @PutMapping("/base/product/save")
    public Result update(@RequestBody MProduct mProduct){
        return mProductService.update(mProduct);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @PostMapping("/base/product/add")
    public Result add(@RequestBody MProduct mProduct){
        return mProductService.add(mProduct);
    }
}
