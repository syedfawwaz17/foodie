package com.foodie.backend.service;

import com.foodie.backend.dto.RestaurantDTO;
import com.foodie.backend.dto.UserDTO;
import com.foodie.backend.exception.ResourceNotFoundException;
import com.foodie.backend.mapper.RestaurantMapper;
import com.foodie.backend.mapper.UserMapper;
import com.foodie.backend.model.Restaurant;
import com.foodie.backend.model.User;
import com.foodie.backend.repository.RestaurantRepository;
import com.foodie.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserMapper userMapper;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository,
                            RestaurantRepository restaurantRepository,
                            UserMapper userMapper,
                            RestaurantMapper restaurantMapper) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.userMapper = userMapper;
        this.restaurantMapper = restaurantMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id = " + id));
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id = " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(restaurantMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDTO approveRestaurant(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id = " + restaurantId));

        restaurant.setApproved(true);
        restaurant.setSuspended(false); // Ensure it’s active
        return restaurantMapper.toDto(restaurantRepository.save(restaurant));
    }

    @Override
    public void suspendRestaurant(String restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id = " + restaurantId));

        restaurant.setSuspended(true);
        restaurantRepository.save(restaurant);
    }
}
