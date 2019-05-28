package com.mcpms.mcpms.system.controller.system;

import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.pojo.index.VUser;
import com.mcpms.mcpms.system.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
*
* @class  UserController
* @author guolin
* @date   2019/2/24/024
**/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/system/user/getall")
    public Result getAll(@RequestBody VUser vUser,Integer page, Integer size){
        return userService.getAll(vUser,page,size);
    }

    @GetMapping("/system/user/findone")
    public Result findone(long id){
        return userService.findone(id);
    }

    @PostMapping("/system/user/add")
    public Result add(@RequestBody MUser mUser){
        return userService.save(mUser);
    }

    @PutMapping("/system/user/update")
    public Result update(@RequestBody MUser mUser){
        return userService.update(mUser);
    }

    @GetMapping("/system/user/delpass")
    public Result delpass(long id){
        return userService.delpass(id);
    }
}
