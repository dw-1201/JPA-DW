package com.example.dw.config;

import com.example.dw.interceptor.AdminLoginInterceptor;
import com.example.dw.interceptor.ExecutionTimeInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final AdminLoginInterceptor adminLoginInterceptor;
    private final ExecutionTimeInterceptor executionTimeInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(adminLoginInterceptor)
                .addPathPatterns("/admin/*")
                .excludePathPatterns("/admin/enterLogin")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/logout")
                .order(1);

//        registry.addInterceptor(executionTimeInterceptor)
//                .addPathPatterns("/**")
//                .order(Ordered.HIGHEST_PRECEDENCE);
    }
}
