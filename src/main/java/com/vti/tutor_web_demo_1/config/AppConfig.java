package com.vti.tutor_web_demo_1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration nghia la khi chạy chương trình chạy qua config trước tiên

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new JwtInterceptor())
//                .addPathPatterns("/api/test/**",
//                        "/api/user/**"); // Add the API endpoint pattern you want to filter
    }
}