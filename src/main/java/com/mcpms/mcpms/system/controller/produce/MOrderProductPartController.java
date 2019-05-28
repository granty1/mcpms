package com.mcpms.mcpms.system.controller.produce;


import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.produce.MOrderProductPartMapper;
import com.mcpms.mcpms.system.pojo.produce.MOrderProduct;
import com.mcpms.mcpms.system.pojo.produce.VOrderProductPart;
import com.mcpms.mcpms.system.service.produce.MOrderProductPartService;
import com.mcpms.mcpms.system.service.produce.MOrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 订单产品零件管理
 * @author yuhong
 * @date   2019/2/24
 **/
@RestController
public class MOrderProductPartController {

    @Autowired
    MOrderProductPartService mOrderProductPartService;

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @PostMapping("/produce/parts/getall")
    public Result getAllByOrderAndProduct(@RequestBody VOrderProductPart vOrderProductPart, Integer page, Integer size){
        return mOrderProductPartService.getAllByOrderAndProduct(vOrderProductPart,page,size);
    }

}
