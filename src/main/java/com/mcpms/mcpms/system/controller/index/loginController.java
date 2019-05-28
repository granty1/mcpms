package com.mcpms.mcpms.system.controller.index;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.pojo.index.PassObj;
import com.mcpms.mcpms.system.service.index.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
* login
* @class  loginController
* @author guolin
* @date   2019/2/23/023
**/
@Controller
public class loginController {


    @Autowired
    private loginService loginService;

    private static final String CURRENT_USER = "current_user";

    @PostMapping("/system/login")
    @ResponseBody
    public Result login(@RequestBody MUser user, HttpSession session){
        return loginService.login(user,session);
    }

    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/current")
    @ResponseBody
    public Result current(HttpSession session){
        MUser current_user = getUser(session);
        return ResponseUtils.responseSuccess(current_user);
    }

    @PutMapping("/profile/saveInfo")
    @ResponseBody
    public Result saveInfo(@RequestBody MUser mUser,HttpSession session){
        MUser current_user = getUser(session);
        return loginService.saveInfo(current_user.getId(),mUser,session);
    }
    @PostMapping("/profile/savePass")
    @ResponseBody
    public Result savePass(@RequestBody PassObj passObj,HttpSession session){
        return loginService.savePass(getUser(session).getId(),passObj);
    }

    public MUser getUser(HttpSession session){
        return (MUser) session.getAttribute(CURRENT_USER);
    }
}
