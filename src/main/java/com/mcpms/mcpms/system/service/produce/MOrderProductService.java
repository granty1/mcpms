package com.mcpms.mcpms.system.service.produce;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.base.MProduct;
import com.mcpms.mcpms.system.pojo.base.MProductPart;
import com.mcpms.mcpms.system.pojo.produce.MOrderProduct;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;


/**
 * 订单产品管理
 * @author yuhong
 * @date   2019/1/16
 **/
public interface MOrderProductService {
    public Result getallpro(long id);
    public Result findonePro(long id);
    public Result update(HttpSession session,MOrderProduct mOrderProduct);
    public Result delete(HttpSession session,long ids[]);
    public Result add(HttpSession session, MOrderProduct mOrderProduct);
    public Result initData();
    public Result clone(HttpSession session,long orderId,long tOrderId,long orderProductId);

}
