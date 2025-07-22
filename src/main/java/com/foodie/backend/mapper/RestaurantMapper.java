package com.foodie.backend.mapper;

import com.foodie.backend.dto.RestaurantDTO;
import com.foodie.backend.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public RestaurantDTO toDto(Restaurant entity) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setCuisineType(entity.getCuisineType());
        dto.setApproved(entity.isApproved()); // This is now safe
        dto.setSuspended(entity.isSuspended());
        return dto;
    }

    public Restaurant toEntity(RestaurantDTO dto) {
        Restaurant entity = new Restaurant();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setCuisineType(dto.getCuisineType());
        entity.setApproved(Boolean.TRUE.equals(dto.getApproved()));
        entity.setSuspended(Boolean.TRUE.equals(dto.getSuspended()));
        return entity;
    }
}
