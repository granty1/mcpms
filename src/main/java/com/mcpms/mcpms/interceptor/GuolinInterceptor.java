package com.mcpms.mcpms.interceptor;

import com.mcpms.mcpms.emun.interceptor.RoleType;
import com.mcpms.mcpms.interceptor.annotation.GuoLinAuthenticate;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.service.index.impl.loginServiceImpl;
import com.mcpms.mcpms.system.service.index.loginService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guolin
 */
@Component
public class GuolinInterceptor extends HandlerInterceptorAdapter {

    private static final String ROLE = "ROLE";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            GuoLinAuthenticate declaredAnnotation = method.getDeclaredAnnotation(GuoLinAuthenticate.class);
            if (declaredAnnotation!=null){
                if(declaredAnnotation.isNeed()){
                    RoleType[] value = declaredAnnotation.value();
                    if(isPermit(request,response,value)){
                        return true;
                    }
                    response.sendRedirect(request.getContextPath()+"/login");
                    return false;
                }
            }else{
                Class<?> declaringClass = method.getDeclaringClass();
                GuoLinAuthenticate classAnnotation = declaringClass.getDeclaredAnnotation(GuoLinAuthenticate.class);
                if(classAnnotation!=null){
                    if(classAnnotation.isNeed()){
                        RoleType[] value = classAnnotation.value();
                        if(isPermit(request,response,value)){
                            return true;
                        }
                        response.sendRedirect(request.getContextPath()+"/login");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isPermit(HttpServletRequest request,HttpServletResponse response,RoleType[] annotationValues)throws Exception{
        MUser current_user = (MUser) request.getSession().getAttribute("current_user");
        if(current_user!=null){
            String role = current_user.getRole();
            if(role!=null){
                for (RoleType roletye :
                        annotationValues) {
                    String name = roletye.name();
                    if (name.equals(role)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
