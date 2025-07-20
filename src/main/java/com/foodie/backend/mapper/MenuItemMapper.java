package com.foodie.backend.mapper;

import com.foodie.backend.dto.MenuItemDTO;
import com.foodie.backend.model.Menu;

public class MenuItemMapper {
    public MenuItemDTO toDto(Menu menu){
        if(menu == null) return null;
        MenuItemDTO dto = new MenuItemDTO();
        dto.setId(menu.getId());
        dto.setName(menu.getName());
        dto.setDescription(menu.getDescription());
        dto.setPrice(menu.getPrice());
        dto.setRestaurantId(menu.getRestaurantId());
        return  dto;
    }

    public Menu toEntity(MenuItemDTO menuItemDTO){
        if (menuItemDTO == null) return null;
        Menu menu = new Menu();
        menu.setId(menuItemDTO.getId());
        menu.setName(menuItemDTO.getName());
        menu.setDescription(menu.getDescription());
        menu.setPrice(menuItemDTO.getPrice());
        menu.setRestaurantId(menuItemDTO.getRestaurantId());
        return menu;
    }

}
