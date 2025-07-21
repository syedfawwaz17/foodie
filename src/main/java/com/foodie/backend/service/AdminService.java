package com.foodie.backend.service;

import com.foodie.backend.dto.RestaurantDTO;
import com.foodie.backend.dto.UserDTO;

import java.util.List;

public interface AdminService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(String id);
    void deleteUser(String id);

    List<RestaurantDTO> getAllRestaurants();
    RestaurantDTO approveRestaurant(String restaurantId);
    void suspendRestaurant(String restaurantId);
}
