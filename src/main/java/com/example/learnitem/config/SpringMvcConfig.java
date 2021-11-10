package com.example.learnitem.config;

import com.example.learnitem.interceptors.LoginInterceptor;
import com.example.learnitem.interceptors.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @BelongsProject: learn-item
 * @BelongsPackage: com.example.learnitem.config
 * @Author: ZhenShanXu
 * @CreateTime: 2021-11-01 15:42.
 * @Description:
 */

@Configuration
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new TokenInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/").
                excludePathPatterns("/api/getVerifyCode").
                excludePathPatterns("/api/codeToLogin").
                excludePathPatterns("/api/accountToLogin").
                excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
