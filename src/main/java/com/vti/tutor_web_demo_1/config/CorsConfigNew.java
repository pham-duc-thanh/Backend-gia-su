package com.vti.tutor_web_demo_1.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfigNew {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("http://150.95.110.230");
        corsConfig.addAllowedOrigin("http://localhost:81");
        corsConfig.addAllowedOrigin("http://localhost:80");
        corsConfig.addAllowedOrigin("http://localhost:3000");
        corsConfig.addAllowedOrigin("http://localhost:3001");
        corsConfig.addAllowedOrigin("http://localhost:3002");
        corsConfig.addAllowedOrigin("http://localhost:3006");
        corsConfig.addAllowedOrigin("http://163.44.206.118:80");
        corsConfig.addAllowedOrigin("http://163.44.206.118:81");

        // Add more allowed origins, headers, or methods as needed
        corsConfig.addAllowedMethod("*");
        corsConfig.addAllowedHeader("*");
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }
}
