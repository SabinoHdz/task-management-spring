package com.springboot.app.project_task.project_task.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
        registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET","POST")
        .allowedHeaders("*")
        .allowCredentials(true);
        
    }
}
