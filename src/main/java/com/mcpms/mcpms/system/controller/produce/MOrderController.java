package com.mcpms.mcpms.system.controller.produce;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.produce.MOrder;
import com.mcpms.mcpms.system.service.produce.MOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理
 *
 * @author yuhong
 * @date 2019/2/24
 **/
@RestController
public class MOrderController {
    @Autowired
    MOrderService mOrderService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS, RoleType.ROLE_MANAGER_OUTSOURCE})
    @PostMapping("/produce/order/getall")
    public Result getAll(@RequestBody MOrder mOrder, int page, int size) {
        return mOrderService.getAll(mOrder, page, size);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS, RoleType.ROLE_MANAGER_OUTSOURCE})
    @DeleteMapping("/produce/order/delete")
    public Result del(long[] ids) {
        return mOrderService.del(ids);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS, RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/produce/order/findone")
    public Result findOne(long id) {
        return mOrderService.findOne(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS, RoleType.ROLE_MANAGER_OUTSOURCE})
    @PutMapping("/produce/order/save")
    public Result update(@RequestBody MOrder mOrder) {
        return mOrderService.update(mOrder);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS, RoleType.ROLE_MANAGER_OUTSOURCE})
    @PostMapping("/produce/order/save")
    public Result add(@RequestBody MOrder mOrder) {
        return mOrderService.add(mOrder);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS, RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/produce/order/finshorder")
    public Result finshorder(long id) {
        return mOrderService.finshorder(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS, RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/produce/order/scrap")
    public Result scrap(long id) {
        return mOrderService.scrap(id);
    }
}
