package com.foodie.backend.service;

import com.foodie.backend.dto.RestaurantRegistrationDTO;

public interface RestaurantRegistrationService {
    void registerRestaurant(RestaurantRegistrationDTO registrationDTO);
}