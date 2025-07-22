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
    public void registerRestaurant(RestaurantRegistrationDTO dto) {
        User owner = new User();
        owner.setEmail(dto.getOwnerEmail());
        owner.setPassword(passwordEncoder.encode(dto.getOwnerPassword()));
        owner.setRole(Role.RESTAURANT_OWNER);
        owner.setName(dto.getName()); // reuse restaurant name as default
        owner.setAddress(dto.getAddress());
        owner.setPhone("NA");
        User savedOwner = userRepository.save(owner);

        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setCuisineType(dto.getCuisineType());
        restaurant.setOwnerId(savedOwner.getId());
        restaurant.setApproved(false);
        restaurantRepository.save(restaurant);
    }

}