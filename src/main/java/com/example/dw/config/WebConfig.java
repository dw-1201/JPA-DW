package com.example.dw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.dir}")
    private String goodsImgPath;
    @Value("${file.que}")
    private String questionPath;
    // 사용자 프로필 저장 공간
    @Value("${file.user}")
    private String userFilePath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandlers() 리소스 경로와 연결된 URL경로를 작성한다.
        //리소스는 자원(이미지)
        registry.addResourceHandler("/jpa_dw/**")
                .addResourceLocations("file:" + goodsImgPath)
                .addResourceLocations("file:" + questionPath)
                .addResourceLocations("file:"+ userFilePath);

        //로컬 디스크 경로는 file: 을 반드시 사용해야한다.
        registry.addResourceHandler("/common/**")
                .addResourceLocations("classpath:/static/common/");
    }

}
