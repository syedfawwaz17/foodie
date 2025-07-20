package com.foodie.backend.mapper;

import com.foodie.backend.dto.RestaurantDTO;
import com.foodie.backend.model.Restaurant;

public class RestaurantMapper {
    public RestaurantDTO toDto(Restaurant restaurant){
        if( restaurant == null) return null;
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setAddress(restaurant.getAddress());
        dto.setCuisineType(restaurant.getCuisineType());
        return dto;

    }

    public Restaurant toEntity(RestaurantDTO dto){
        if(dto == null) return null;
        Restaurant restaurant = new Restaurant();
        restaurant.setId(dto.getId());
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setCuisineType(dto.getCuisineType());
        return restaurant;

    }
}
