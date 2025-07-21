package com.foodie.backend.service;

import com.foodie.backend.dto.MenuItemDTO;
import com.foodie.backend.dto.RestaurantDTO;
import com.foodie.backend.exception.ResourceNotFoundException;
import com.foodie.backend.mapper.RestaurantMapper;
import com.foodie.backend.model.Restaurant;
import com.foodie.backend.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestaurantOwnerServiceImpl implements RestaurantOwnerService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Override
    public RestaurantDTO getMyRestaurant() {
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        return restaurantMapper.toDto(restaurant);
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setCuisineType(restaurantDTO.getCuisineType());

        return restaurantMapper.toDto(restaurantRepository.save(restaurant));
    }

    @Override
    public MenuItemDTO addMenuItem(MenuItemDTO menuItemDTO) {
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        Restaurant.MenuItem menuItem = new Restaurant.MenuItem();
        menuItem.setId(UUID.randomUUID().toString());
        menuItem.setName(menuItemDTO.getName());
        menuItem.setDescription(menuItemDTO.getDescription());
        menuItem.setPrice(menuItemDTO.getPrice());
        menuItem.setCategory(menuItemDTO.getCategory());

        restaurant.getMenuItems().add(menuItem);
        restaurantRepository.save(restaurant);
        menuItemDTO.setId(menuItem.getId());
        return menuItemDTO;
    }

    @Override
    public MenuItemDTO updateMenuItem(String itemId, MenuItemDTO menuItemDTO) {
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        Restaurant.MenuItem menuItem = restaurant.getMenuItems()
                .stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));

        menuItem.setName(menuItemDTO.getName());
        menuItem.setDescription(menuItemDTO.getDescription());
        menuItem.setPrice(menuItemDTO.getPrice());
        menuItem.setCategory(menuItemDTO.getCategory());

        restaurantRepository.save(restaurant);
        return menuItemDTO;
    }

    @Override
    public void removeMenuItem(String itemId) {
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        restaurant.getMenuItems().removeIf(item -> item.getId().equals(itemId));
        restaurantRepository.save(restaurant);
    }

    @Override
    public List<MenuItemDTO> getMenuItems() {
        String ownerId = SecurityContextHolder.getContext().getAuthentication().getName();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        return restaurant.getMenuItems().stream()
                .map(item -> {
                    MenuItemDTO dto = new MenuItemDTO();
                    dto.setId(item.getId());
                    dto.setName(item.getName());
                    dto.setDescription(item.getDescription());
                    dto.setPrice(item.getPrice());
                    dto.setCategory(item.getCategory());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
