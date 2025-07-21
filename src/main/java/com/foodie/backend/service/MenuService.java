package com.foodie.backend.service;

import com.foodie.backend.dto.MenuItemDTO;

import java.util.List;

public interface MenuService {
    MenuItemDTO createMenuItem(MenuItemDTO menuItemDTO);
    MenuItemDTO getMenuItemById(String id);
    List<MenuItemDTO> getAllMenuItems();
    List<MenuItemDTO> getMenuItemsByRestaurantId(String restaurantId);
    MenuItemDTO updateMenuItem(String id, MenuItemDTO menuItemDTO);
    void deleteMenuItem(String id);
    boolean existsById(String id);
    long countByRestaurantId(String restaurantId);
}
