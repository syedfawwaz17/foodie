package com.foodie.backend.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Add all frontend URLs that need to access your backend here.
    private final String[] allowedOrigins = {
            "http://localhost:3000",
            "https://6000-firebase-studio-1753104222564.cluster-w5vd22whf5gmav2vgkomwtc4go.cloudworkstations.dev",
            // "https://your-production-frontend-url.com" // Add your production URL here when you deploy
    };

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Apply to all API routes
                .allowedOrigins(allowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    @PostConstruct
    public void printAllowedOrigins() {
        System.out.println("Allowed CORS origins configured:");
        for (String origin : allowedOrigins) {
            System.out.println(" - " + origin);
        }
    }
}
