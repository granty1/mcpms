package com.mcpms.mcpms.system.service.index;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.pojo.index.PassObj;

import javax.servlet.http.HttpSession;

/**
* login service
* @class  loginService
* @author guolin
* @date   2019/2/23/023
**/
public interface loginService {

    Result login(MUser user, HttpSession session);

    Result saveInfo(long userId,MUser mUser,HttpSession session);

    Result savePass(long id, PassObj passObj);
}
