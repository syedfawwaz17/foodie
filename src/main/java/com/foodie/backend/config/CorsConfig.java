package com.foodie.backend.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // ✅ Update this list with frontend environments
    private final String[] allowedOrigins = {
            "http://localhost:3000",               // Dev frontend (Next.js)
            "https://foodie-app.web.app",          // Firebase deployed frontend (example)
            "https://admin.foodie.com"             // Custom admin panel (optional)
    };

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // covers RESTful methods
                .allowedHeaders("*")
                .allowCredentials(true); // required if you're sending JWT tokens or cookies
    }

    @PostConstruct
    public void logAllowedOrigins() {
        System.out.println("🔓 CORS: Allowed frontend origins:");
        for (String origin : allowedOrigins) {
            System.out.println("✅ " + origin);
        }
    }
}
