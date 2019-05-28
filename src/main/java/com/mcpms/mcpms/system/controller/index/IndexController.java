package com.mcpms.mcpms.system.controller.index;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
* 初始化跳转
* @author guolin
* @date   2019/1/31/031
**/
@Controller
public class IndexController {


    /**
     * index
     * @return
     */
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/personal")
    public String profile(){ return "personal";}
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM,RoleType.ROLE_MANAGER_OUTSOURCE,RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/welcome")
    public String welcome(){ return "welcome";}
    @GetMapping("/login")
    public String login(HttpSession session){ session.invalidate();return "login";}
    @DeleteMapping("/login")
    public String loginDel(HttpSession session){ session.invalidate();return "login";}






    /**
     * base
     * @return
     */
    @GetMapping("/base/parts")
    public String baseParts(){
        return "system/base/parts";
    }

    @GetMapping("/base/product")
    public String baseProduct(){
        return "system/base/product";
    }

    @GetMapping("/base/process")
    public String baseProcess(){
        return "system/base/process";
    }

    @GetMapping("/base/out")
    public String baseOut(){
        return "system/base/out";
    }
    @GetMapping("/base/warning")
    public String baseWarning(){
        return "system/base/warning";
    }




    /**
     * produce
     */
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/produce/order")
    public String produceOrder(){
        return "system/produce/order";
    }
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/produce/plan")
    public String plan(){
        return "system/produce/produceplan";
    }
    @GuoLinAuthenticate(value = {RoleType.ROLE_PRODUCTION_DIRECTOR})
    @GetMapping("/produce/approval")
    public String approval(){
        return "system/produce/approval";
    }
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_STATISTICS,RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/produce/parts")
    public String produceParts(){
        return "system/produce/parts";
    }



    /**
     * out
     */
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/out/out")
    public String outOut(){
        return "system/out/outstock";
    }
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/out/in")
    public String outIn(){
        return "system/out/instock";
    }
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_OUTSOURCE})
    @GetMapping("/out/warning")
    public String warning(){
        return "system/out/warning";
    }


    /**
     * system
     */
    @GuoLinAuthenticate(value = {RoleType.ROLE_MANAGER_SYSTEM})
    @GetMapping("/system/user")
    public String user(){ return "system/system/user";}
}
