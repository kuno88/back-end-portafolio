package com.example.backendportafolio.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigure(){
        return new WebMvcConfigurer(){
            @Override
                    public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/login")
                        .allowedOrigins("https://portafolio-f6f99.web.app")
                        .allowedMethods("*")
                        .exposedHeaders("*");

                registry.addMapping("/api/**")
                        .allowedOrigins("https://portafolio-f6f99.web.app")
                        .allowedMethods("*");


            }
        };
    }
}
