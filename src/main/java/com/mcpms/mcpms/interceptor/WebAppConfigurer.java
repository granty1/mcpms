package com.mcpms.mcpms.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author guolin
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer{

    @Autowired
    private GuolinInterceptor guolinInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(guolinInterceptor).
                addPathPatterns("/**").
                excludePathPatterns("/static/**");
    }
}
