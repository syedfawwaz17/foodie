package com.foodie.backend.dto;

import lombok.Data;

@Data
public class RestaurantDTO {
    private String id;
    private String name;
    private String address;
    private String cuisineType;
}
