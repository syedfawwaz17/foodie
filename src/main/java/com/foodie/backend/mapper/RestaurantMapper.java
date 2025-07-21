package com.foodie.backend.mapper;

import com.foodie.backend.dto.RestaurantDTO;
import com.foodie.backend.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

    public RestaurantDTO toDto(Restaurant restaurant) {
        if (restaurant == null) {
            return null;
        }

        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setAddress(restaurant.getAddress());
        dto.setCuisineType(restaurant.getCuisineType());
        return dto;
    }

    public Restaurant toEntity(RestaurantDTO restaurantDTO) {
        if (restaurantDTO == null) {
            return null;
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDTO.getId());
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setCuisineType(restaurantDTO.getCuisineType());
        return restaurant;
    }
}