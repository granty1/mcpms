package com.mcpms.mcpms.system.controller.produce;


import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.produce.MOrderProduct;
import com.mcpms.mcpms.system.service.produce.MOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * 订单产品管理
 * @author yuhong
 * @date   2019/2/24
 **/
@RestController
public class MOrderProductController {

    @Autowired
    MOrderProductService mOrderProductService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/produce/order/getallpro")
    public Result getallpro(long id){
        return mOrderProductService.getallpro(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/produce/order/findonePro")
    public Result findonePro(long id){
        return mOrderProductService.findonePro(id);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @PutMapping("/produce/order/savepro")
    public Result update(HttpSession session,@RequestBody  MOrderProduct mOrderProduct){
        return mOrderProductService.update(session,mOrderProduct);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @DeleteMapping("/produce/order/deletepro")
    public Result delete(HttpSession session,long ids[]){
        return mOrderProductService.delete(session,ids);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @PostMapping("/produce/order/savepro")
    public Result add(HttpSession session, @RequestBody MOrderProduct mOrderProduct){
        return mOrderProductService.add(session,mOrderProduct);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/order/initdata")
    public Result initData(){
        return mOrderProductService.initData();
    }

}
