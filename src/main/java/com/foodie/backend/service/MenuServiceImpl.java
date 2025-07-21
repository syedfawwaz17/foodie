package com.foodie.backend.service;

import com.foodie.backend.dto.MenuItemDTO;
import com.foodie.backend.mapper.MenuItemMapper;
import com.foodie.backend.model.MenuItem;
import com.foodie.backend.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    private final MenuItemRepository menuRepository;
    private final MenuItemMapper menuItemMapper;

    @Autowired
    public MenuServiceImpl(MenuItemRepository menuRepository, MenuItemMapper menuItemMapper) {
        this.menuRepository = menuRepository;
        this.menuItemMapper = menuItemMapper;
    }

    @Override
    public MenuItemDTO createMenuItem(MenuItemDTO menuItemDTO) {
        MenuItem entity = menuItemMapper.toEntity(menuItemDTO);
        MenuItem saved = menuRepository.save(entity);
        return menuItemMapper.toDto(saved);
    }

    @Override
    public MenuItemDTO getMenuItemById(String id) {
        MenuItem menuItem = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found with id: " + id));
        return menuItemMapper.toDto(menuItem);
    }

    @Override
    public List<MenuItemDTO> getAllMenuItems() {
        return menuRepository.findAll().stream()
                .map(menuItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuItemDTO> getMenuItemsByRestaurantId(String restaurantId) {
        return menuRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(menuItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MenuItemDTO updateMenuItem(String id, MenuItemDTO menuItemDTO) {
        MenuItem existing = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found with id: " + id));

        existing.setName(menuItemDTO.getName());
        existing.setDescription(menuItemDTO.getDescription());
        existing.setPrice(menuItemDTO.getPrice());
        existing.setCategory(menuItemDTO.getCategory());
        existing.setRestaurantId(menuItemDTO.getRestaurantId());

        MenuItem updated = menuRepository.save(existing);
        return menuItemMapper.toDto(updated);
    }

    @Override
    public void deleteMenuItem(String id) {
        if (!menuRepository.existsById(id)) {
            throw new RuntimeException("Menu item not found with id: " + id);
        }
        menuRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return menuRepository.existsById(id);
    }

    @Override
    public long countByRestaurantId(String restaurantId) {
        return menuRepository.countByRestaurantId(restaurantId);
    }
}
