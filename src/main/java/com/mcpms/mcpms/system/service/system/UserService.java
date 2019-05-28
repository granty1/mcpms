package com.mcpms.mcpms.system.service.system;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.pojo.index.VUser;

public interface UserService {

    Result getAll(VUser vUser,Integer page,Integer size);

    Result findone(long id);

    Result save(MUser mUser);

    Result update(MUser mUser);

    Result delpass(long id);
}
