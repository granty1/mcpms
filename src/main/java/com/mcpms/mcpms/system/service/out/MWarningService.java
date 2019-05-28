package com.mcpms.mcpms.system.service.out;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.out.MWarning;
import com.mcpms.mcpms.system.pojo.out.VWarning;

public interface MWarningService {
    public Result getAll(VWarning vWarning,int page,int size);
    public Result hastenDelyvery(long id);
}
