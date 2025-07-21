package com.foodie.backend.service;

import com.foodie.backend.dto.MenuItemDTO;
import com.foodie.backend.dto.RestaurantDTO;
import java.util.List;

public interface RestaurantOwnerService {
    RestaurantDTO getMyRestaurant();
    RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO);

    MenuItemDTO addMenuItem(MenuItemDTO menuItemDTO);
    MenuItemDTO updateMenuItem(String itemId, MenuItemDTO menuItemDTO);
    void removeMenuItem(String itemId);
    List<MenuItemDTO> getMenuItems();
}