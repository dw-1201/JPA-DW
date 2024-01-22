package com.example.dw.config;

import com.example.dw.interceptor.AdminLoginInterceptor;
import com.example.dw.interceptor.ExecutionTimeInterceptor;
import com.example.dw.interceptor.UserLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final UserLoginInterceptor userLoginInterceptor;
    private final AdminLoginInterceptor adminLoginInterceptor;
    private final ExecutionTimeInterceptor executionTimeInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(adminLoginInterceptor)
//                .addPathPatterns("/admin/*")
//                .excludePathPatterns("/admin/enterLogin")
//                .excludePathPatterns("/admin/login")
//                .excludePathPatterns("/admin/logout")
//                .order(3);
////
//        registry.addInterceptor(userLoginInterceptor)
//                .addPathPatterns("/mypg/**")
//                .addPathPatterns("/shop/shopCart/*")
//                .order(1);
//
//        registry.addInterceptor(userLoginInterceptor)
//                .addPathPatterns("/qna/*")
//                .excludePathPatterns("/qna/qnaLists")
//                .excludePathPatterns("/qna/qnaDetail/*")
//                .addPathPatterns("/qna/*/*")
//                .addPathPatterns("/qna/delete/*");
//
//        registry.addInterceptor(userLoginInterceptor)
//                .addPathPatterns("/walk/*")
//                .excludePathPatterns("/walk/walkList")
//                .excludePathPatterns("/walk/detail")
//                .addPathPatterns("/walk/*/*")
//                .addPathPatterns("/walk/deleteWalkMate/*")
//                .addPathPatterns("/walk/applyCancel/*/*");

//        registry.addInterceptor(executionTimeInterceptor)
//                .addPathPatterns("/**")
//                .order(Ordered.HIGHEST_PRECEDENCE);
    }
}
