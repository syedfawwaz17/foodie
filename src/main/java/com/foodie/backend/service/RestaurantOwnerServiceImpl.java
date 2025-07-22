package com.foodie.backend.service;

import com.foodie.backend.dto.MenuItemDTO;
import com.foodie.backend.dto.RestaurantDTO;
import com.foodie.backend.exception.ResourceNotFoundException;
import com.foodie.backend.mapper.MenuItemMapper;
import com.foodie.backend.mapper.RestaurantMapper;
import com.foodie.backend.model.MenuItem;
import com.foodie.backend.model.Restaurant;
import com.foodie.backend.repository.MenuItemRepository;
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
    private MenuItemRepository menuItemRepository;

    @Autowired
    private MenuItemMapper menuItemMapper;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Override
    public RestaurantDTO getMyRestaurant() {
        String ownerId = getCurrentUserId();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        return restaurantMapper.toDto(restaurant);
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO) {
        String ownerId = getCurrentUserId();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
        restaurant.setName(restaurantDTO.getName());
        restaurant.setCuisineType(restaurantDTO.getCuisineType());
        restaurant.setAddress(restaurantDTO.getAddress());
        return restaurantMapper.toDto(restaurantRepository.save(restaurant));
    }

    @Override
    public MenuItemDTO addMenuItem(MenuItemDTO menuItemDTO) {
        String ownerId = getCurrentUserId();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        if (Boolean.FALSE.equals(restaurant.getApproved()) || Boolean.TRUE.equals(restaurant.getSuspended())) {
            throw new RuntimeException("Restaurant is not active");
        }

        menuItemDTO.setRestaurantId(restaurant.getId());
        MenuItem savedItem = menuItemRepository.save(menuItemMapper.toEntity(menuItemDTO));
        return menuItemMapper.toDto(savedItem);
    }

    @Override
    public MenuItemDTO updateMenuItem(String itemId, MenuItemDTO menuItemDTO) {
        MenuItem existing = menuItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));

        String ownerId = getCurrentUserId();
        Restaurant restaurant = restaurantRepository.findById(existing.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        if (!restaurant.getOwnerId().equals(ownerId))
            throw new RuntimeException("Access denied");

        existing.setName(menuItemDTO.getName());
        existing.setDescription(menuItemDTO.getDescription());
        existing.setPrice(menuItemDTO.getPrice());
        existing.setCategory(menuItemDTO.getCategory());

        MenuItem updated = menuItemRepository.save(existing);
        return menuItemMapper.toDto(updated);
    }

    @Override
    public void removeMenuItem(String itemId) {
        MenuItem item = menuItemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found"));

        String ownerId = getCurrentUserId();
        Restaurant restaurant = restaurantRepository.findById(item.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        if (!restaurant.getOwnerId().equals(ownerId))
            throw new RuntimeException("Access denied");

        menuItemRepository.deleteById(itemId);
    }

    @Override
    public List<MenuItemDTO> getMenuItems() {
        String ownerId = getCurrentUserId();
        Restaurant restaurant = restaurantRepository.findByOwnerId(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

        return menuItemRepository.findByRestaurantId(restaurant.getId())
                .stream()
                .map(menuItemMapper::toDto)
                .collect(Collectors.toList());
    }

    private String getCurrentUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
