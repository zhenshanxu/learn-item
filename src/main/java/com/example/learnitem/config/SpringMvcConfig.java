package com.example.learnitem.config;

import com.example.learnitem.interceptors.LoginInterceptor;
import com.example.learnitem.interceptors.TokenInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.config
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-01 15:42.
 * @Description:
 */

public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new TokenInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/").
                excludePathPatterns("/api/getVerifyCode").
                excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }
}
