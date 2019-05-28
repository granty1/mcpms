package com.mcpms.mcpms.system.service.produce;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.produce.VOrderProduct;
import com.mcpms.mcpms.system.pojo.produce.VOrderProductPart;

public interface MOrderProductPartService {
    public Result getAllByOrderAndProduct(VOrderProductPart vOrderProductPart,Integer page,Integer size);
}
