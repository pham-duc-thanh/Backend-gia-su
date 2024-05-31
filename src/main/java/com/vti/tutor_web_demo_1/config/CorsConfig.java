package com.vti.tutor_web_demo_1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOriginPatterns(
                        "*",
                        "localhost:80",
                        "localhost:81",
                        "163.44.206.118:80",
                        "163.44.206.118:81",
                        "localhost",
                        "localhost:3000",
                        "150.95.110.230",
                        "localhost:3001",
                        "localhost:3002",
                        "localhost:3006")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);;
    }
}
