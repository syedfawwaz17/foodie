package com.foodie.backend.service;

import com.foodie.backend.dto.RestaurantDTO;
import java.util.List;

public interface RestaurantService {
    RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO);
    RestaurantDTO getRestaurantById(String id);
    List<RestaurantDTO> getAllRestaurants();
    RestaurantDTO updateRestaurant(String id, RestaurantDTO restaurantDTO);
    void deleteRestaurant(String id);
}