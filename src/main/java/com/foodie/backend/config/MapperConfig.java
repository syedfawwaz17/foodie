package com.foodie.backend.config;

import com.foodie.backend.mapper.OrderMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public OrderMapper orderMapper() {
        return new OrderMapper();
    }
}
