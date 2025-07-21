package com.foodie.backend.mapper;

import com.foodie.backend.dto.MenuItemDTO;
import com.foodie.backend.model.MenuItem;
import org.springframework.stereotype.Component;

@Component
public class MenuItemMapper {

    public MenuItemDTO toDto(MenuItem menuItem) {
        if (menuItem == null) return null;

        MenuItemDTO dto = new MenuItemDTO();
        dto.setId(menuItem.getId());
        dto.setName(menuItem.getName());
        dto.setDescription(menuItem.getDescription());
        dto.setPrice(menuItem.getPrice());
        dto.setCategory(menuItem.getCategory());
        dto.setRestaurantId(menuItem.getRestaurantId());
        return dto;
    }

    public MenuItem toEntity(MenuItemDTO dto) {
        if (dto == null) return null;

        MenuItem entity = new MenuItem();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setCategory(dto.getCategory());
        entity.setRestaurantId(dto.getRestaurantId());
        return entity;
    }
}
