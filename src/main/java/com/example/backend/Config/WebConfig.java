package com.example.backend.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://react-frontend-server.s3-website.ap-northeast-2.amazonaws.com")  // React 애플리케이션의 주소
                .allowedMethods("GET")
                .allowedHeaders("*");
    }
}