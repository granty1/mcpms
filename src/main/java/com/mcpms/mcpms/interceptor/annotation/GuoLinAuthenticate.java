package com.mcpms.mcpms.interceptor.annotation;




import com.mcpms.mcpms.emun.interceptor.RoleType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* 权限注解
* @class  GuoLinAuthenticate
* @author guolin
* @date   2019/1/16/016
**/
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GuoLinAuthenticate {

    /**
     * 是否需要权限访问
     * @return
     */
    boolean isNeed() default true;

    /**
     * 需要的权限名
     * @return
     */
    RoleType[] value() default RoleType.ROLE_MANAGER_SYSTEM;
}
