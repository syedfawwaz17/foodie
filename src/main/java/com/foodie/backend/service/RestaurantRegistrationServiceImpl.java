package com.foodie.backend.service;

import com.foodie.backend.dto.RestaurantRegistrationDTO;
import com.foodie.backend.dto.UserRegistrationDTO;
import com.foodie.backend.model.Restaurant;
import com.foodie.backend.model.Role;
import com.foodie.backend.model.User;
import com.foodie.backend.repository.RestaurantRepository;
import com.foodie.backend.repository.UserRepository;
import com.foodie.backend.service.RestaurantRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RestaurantRegistrationServiceImpl implements RestaurantRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerRestaurant(RestaurantRegistrationDTO registrationDTO) {
        // Create owner user
        User owner = new User();
        owner.setEmail(registrationDTO.getOwnerEmail());
        owner.setPassword(passwordEncoder.encode(registrationDTO.getOwnerPassword()));
        owner.setRole(Role.RESTAURANT_OWNER);
        User savedOwner = userRepository.save(owner);

        // Create restaurant
        Restaurant restaurant = new Restaurant();
        restaurant.setName(registrationDTO.getName());
        restaurant.setAddress(registrationDTO.getAddress());
        restaurant.setCuisineType(registrationDTO.getCuisineType());
        restaurant.setOwnerId(savedOwner.getId());
        restaurant.setApproved(false); // Needs admin approval
        restaurantRepository.save(restaurant);
    }
}